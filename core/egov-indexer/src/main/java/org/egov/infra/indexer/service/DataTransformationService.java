package org.egov.infra.indexer.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.infra.indexer.util.IndexerConstants;
import org.egov.infra.indexer.util.IndexerUtils;
import org.egov.infra.indexer.web.contract.CustomJsonMapping;
import org.egov.infra.indexer.web.contract.FieldMapping;
import org.egov.infra.indexer.web.contract.Index;
import org.egov.infra.indexer.web.contract.UriMapping;
import org.egov.tracer.model.CustomException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataTransformationService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IndexerUtils indexerUtils;

	@Value("${egov.core.reindex.topic.name}")
	private String reindexTopic;

	@Value("${egov.core.legacyindex.topic.name}")
	private String legacyIndexTopic;

	@Value("${egov.indexer.persister.create.topic}")
	private String persisterCreate;

	@Value("${egov.indexer.persister.update.topic}")
	private String persisterUpdate;

	@Value("${reindex.pagination.size.default}")
	private Integer defaultPageSizeForReindex;

	@Value("${legacyindex.pagination.size.default}")
	private Integer defaultPageSizeForLegacyindex;

	@Value("${egov.service.host}")
	private String serviceHost;

	@Value("${egov.infra.indexer.host}")
	private String esHostUrl;

	/**
	 * Tranformation method that transforms the input data to match the es index as
	 * per config
	 * 
	 * @param index
	 * @param kafkaJson
	 * @param isBulk
	 * @param isCustom
	 * @return
	 */
	public String buildJsonForIndex(Index index, String kafkaJson, boolean isBulk, boolean isCustom) {
		StringBuilder jsonTobeIndexed = new StringBuilder();
		String result = null;
		JSONArray kafkaJsonArray = null;
		try {
			kafkaJsonArray = indexerUtils.constructArrayForBulkIndex(kafkaJson, index, isBulk);
			for (int i = 0; i < kafkaJsonArray.length(); i++) {
				if (null != kafkaJsonArray.get(i)) {
					String stringifiedObject = indexerUtils.buildString(kafkaJsonArray.get(i));
					if (isCustom) {
						String customIndexJson = buildCustomJsonForIndex(index.getCustomJsonMapping(),
								stringifiedObject);
						StringBuilder builder = appendIdToJson(index, jsonTobeIndexed, stringifiedObject,
								customIndexJson);
						if (null != builder)
							jsonTobeIndexed = builder;
					} else {
						StringBuilder builder = appendIdToJson(index, jsonTobeIndexed, stringifiedObject, null);
						if (null != builder)
							jsonTobeIndexed = builder;
					}
				} else {
					log.info("null json in kafkajsonarray, index: " + i);
					continue;
				}
			}
			result = jsonTobeIndexed.toString();
		} catch (Exception e) {
			log.error("Error while building jsonstring for indexing", e);
		}

		return result;
	}

	/**
	 * Attaches Index Id to the json to be indexed on es.
	 * 
	 * @param index
	 * @param jsonTobeIndexed
	 * @param stringifiedObject
	 * @param customIndexJson
	 * @return
	 */
	public StringBuilder appendIdToJson(Index index, StringBuilder jsonTobeIndexed, String stringifiedObject,
			String customIndexJson) {
		String id = indexerUtils.buildIndexId(index, stringifiedObject);
		if (StringUtils.isEmpty(id)) {
			return null;
		} else {
			final String actionMetaData = String.format(IndexerConstants.ES_INDEX_HEADER_FORMAT, "" + id);
			if (null != customIndexJson)
				jsonTobeIndexed.append(actionMetaData).append(customIndexJson).append("\n");
			else
				jsonTobeIndexed.append(actionMetaData).append(stringifiedObject).append("\n");
		}

		return jsonTobeIndexed;
	}

	/**
	 * Helper method that builds the custom object for index. It performs following
	 * actions: 1. Takes fields from the record received on the queue and maps it to
	 * the object to be newly created. 2. Performs denormalization of data and
	 * attaching new data by making external API calls as mentioned in the config.
	 * 3. Performs denormalization of data by making MDMS called as mentioned in the
	 * config.
	 * 
	 * @param customJsonMappings
	 * @param kafkaJson
	 * @param urlForMap
	 * @return
	 */
	public String buildCustomJsonForIndex(CustomJsonMapping customJsonMappings, String kafkaJson) {
		Object indexMap = null;
		if (null != customJsonMappings.getIndexMapping()) {
			indexMap = customJsonMappings.getIndexMapping();
		} else {
			throw new CustomException("EGOV_INDEXER_MISSING_CUSTOM_MAPPING",
					"Custom mapping for the given request is missing!");
		}
		DocumentContext documentContext = JsonPath.parse(indexMap);
		if (!CollectionUtils.isEmpty(customJsonMappings.getFieldMapping())) {
			for (FieldMapping fieldMapping : customJsonMappings.getFieldMapping()) {
				String[] expressionArray = (fieldMapping.getOutJsonPath()).split("[.]");
				String expression = indexerUtils.getProcessedJsonPath(fieldMapping.getOutJsonPath());
				try {
					documentContext.put(expression, expressionArray[expressionArray.length - 1],
							JsonPath.read(kafkaJson, fieldMapping.getInjsonpath()));
				} catch (Exception e) {
					continue;
				}

			}
		}
		documentContext = enrichDataUsingExternalServices(documentContext, customJsonMappings, kafkaJson);
		documentContext = denormalizeDataFromMDMS(documentContext, customJsonMappings, kafkaJson);

		return documentContext.jsonString().toString(); // jsonString has to be converted to string
	}

	/**
	 * Performs enrichment of data by attaching new data obtained from making
	 * external API calls as mentioned in the config.
	 * 
	 * @param documentContext
	 * @param customJsonMappings
	 * @param kafkaJson
	 * @return
	 */
	public DocumentContext enrichDataUsingExternalServices(DocumentContext documentContext,
			CustomJsonMapping customJsonMappings, String kafkaJson) {
		ObjectMapper mapper = new ObjectMapper();
		if (!CollectionUtils.isEmpty(customJsonMappings.getExternalUriMapping())) {
			for (UriMapping uriMapping : customJsonMappings.getExternalUriMapping()) {
				Object response = null;
				String uri = null;
				try {
					uri = indexerUtils.buildUri(uriMapping, kafkaJson);
					response = restTemplate.postForObject(uri, uriMapping.getRequest(), Map.class);
					if (null == response)
						continue;
				} catch (Exception e) {
					log.error("Exception while trying to hit: " + uri, e);
					continue;
				}
				log.debug("Response: " + response + " from the URI: " + uriMapping.getPath());
				for (FieldMapping fieldMapping : uriMapping.getUriResponseMapping()) {
					String[] expressionArray = (fieldMapping.getOutJsonPath()).split("[.]");
					String expression = indexerUtils.getProcessedJsonPath(fieldMapping.getOutJsonPath());
					try {
						Object value = JsonPath.read(mapper.writeValueAsString(response), fieldMapping.getInjsonpath());
						documentContext.put(expression, expressionArray[expressionArray.length - 1], value);
					} catch (Exception e) {
						log.error("Value: " + fieldMapping.getInjsonpath() + " is not found!");
						log.info("URI: " + uri);
						documentContext.put(expression, expressionArray[expressionArray.length - 1], null);
						continue;
					}
				}

			}
		}
		return documentContext;
	}

	/**
	 * Performs denormalization of data by making MDMS calls as mentioned in the
	 * config.
	 * 
	 * @param documentContext
	 * @param customJsonMappings
	 * @param kafkaJson
	 * @return
	 */
	public DocumentContext denormalizeDataFromMDMS(DocumentContext documentContext,
			CustomJsonMapping customJsonMappings, String kafkaJson) {
		ObjectMapper mapper = new ObjectMapper();
		if (!CollectionUtils.isEmpty(customJsonMappings.getMdmsMapping())) {
			for (UriMapping uriMapping : customJsonMappings.getMdmsMapping()) {
				Object response = null;
				StringBuilder uri = new StringBuilder();
				uri.append(uriMapping.getPath());
				Object request = null;
				try {
					request = indexerUtils.prepareMDMSSearchReq(uri, new RequestInfo(), kafkaJson, uriMapping);
					response = restTemplate.postForObject(uri.toString(), request, Map.class);
					if (null == response)
						continue;
				} catch (Exception e) {
					log.error("Exception while trying to hit: " + uri, e);
					log.info("Request: " + uriMapping.getRequest());
					continue;
				}
				log.debug("Response: " + response + " from the URI: " + uriMapping.getPath());
				for (FieldMapping fieldMapping : uriMapping.getUriResponseMapping()) {
					String[] expressionArray = (fieldMapping.getOutJsonPath()).split("[.]");
					String expression = indexerUtils.getProcessedJsonPath(fieldMapping.getOutJsonPath());
					try {
						Object value = JsonPath.read(mapper.writeValueAsString(response), fieldMapping.getInjsonpath());
						if (value instanceof List) {
							if (((List) value).size() == 1) {
								value = ((List) value).get(0);
							}
						}
						documentContext.put(expression, expressionArray[expressionArray.length - 1], value);
					} catch (Exception e) {
						log.error("Value: " + fieldMapping.getInjsonpath() + " is not found!");
						log.info("MDMS Request: " + uriMapping.getRequest());
						documentContext.put(expression, expressionArray[expressionArray.length - 1], null);
						continue;
					}
				}

			}
		}
		return documentContext;

	}
}
