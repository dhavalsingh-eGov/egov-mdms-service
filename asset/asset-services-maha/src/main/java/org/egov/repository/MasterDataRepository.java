package org.egov.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.egov.common.contract.request.RequestInfo;
import org.egov.contract.FinancialYear;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsResponse;
import org.egov.mdms.service.MdmsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.minidev.json.JSONArray;

@Repository
public class MasterDataRepository {

	@Autowired
	private MdmsClientService mdmsClientService;

	public Map<String, Map<String, JSONArray>> getMastersByListParams(
			Map<String, Map<String, Map<String, String>>> moduleMap, RequestInfo requestInfo, String tenantId) {

		System.out.println("the map recieved : " +moduleMap);
		Map<String, List<MasterDetail>> map = new HashMap<>();

		for (String moduleKey : moduleMap.keySet()) {
			System.out.println("the module key");
			Map<String, Map<String, String>> masterMap = moduleMap.get(moduleKey);

			List<MasterDetail> masterDetails = new ArrayList<>();

			for (String masterKey : masterMap.keySet()) {

				Map<String, String> fieldMap = masterMap.get(masterKey);
				StringBuilder filterString = new StringBuilder("[?( ");

				Set<String> fieldSet = fieldMap.keySet();
				System.out.println("the field key set : "+ fieldSet);
				String[] fieldSetArray = new String[fieldSet.size()];
				fieldSetArray = fieldSet.toArray(fieldSetArray);
				System.out.println("the array size : "+ fieldSetArray.length);
				for (int index = 0; index < fieldSetArray.length; index++) {
					String fieldName = fieldSetArray[index];
					System.err.println("index : "+index + " value of name : "+fieldName);
					if (index != 0)
						filterString.append(" && ");
					filterString.append("@." + fieldName + " in [" + fieldMap.get(fieldName) + "]");
				}
				filterString.append(")]");
				System.err.println("the filter and master name : " + filterString + " module name : " + moduleKey);
				masterDetails.add(MasterDetail.builder().name(masterKey).filter(filterString.toString()).build());
			}
			map.put(moduleKey, masterDetails);
		}

		MdmsResponse mdmsResponse = mdmsClientService.getMaster(requestInfo, tenantId, map);

		return mdmsResponse.getMdmsRes();
	}

	public FinancialYear getFinancialYears(Long toDate, RequestInfo requestInfo, String tenantId) {

		Map<String, List<MasterDetail>> map = new HashMap<>();
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(MasterDetail.builder().name("financialYears")
				.filter("[?( @.startingDate <= " + toDate + " && @.endingDate >=" + toDate + ")]").build());
		map.put("egf-master", masterDetails);

		if (!tenantId.equals("default"))
			tenantId = tenantId.split(".")[0];
		mdmsClientService.getMaster(requestInfo, tenantId, map).getMdmsRes().get("egf-master").get("financialYears")
				.get(0);

		return (FinancialYear) mdmsClientService.getMaster(requestInfo, tenantId, map).getMdmsRes().get("egf-master")
				.get("financialYears").get(0);
	}

}
