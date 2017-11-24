package org.egov.inv.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.common.JdbcRepository;
import org.egov.common.Pagination;
import org.egov.inv.model.MaterialIssue;
import org.egov.inv.model.MaterialIssueDetail;
import org.egov.inv.model.MaterialIssueSearchContract;
import org.egov.inv.persistence.entity.MaterialIssueDetailEntity;
import org.egov.inv.persistence.entity.MaterialIssueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MaterialIssueJdbcRepository extends JdbcRepository {
	
	  @Autowired
	    public JdbcTemplate jdbcTemplate;

	public Pagination<MaterialIssue> search(final MaterialIssueSearchContract searchContract) {
		String searchQuery = "select * from materialissue :condition :orderby";
		StringBuffer params = new StringBuffer();
		Map<String, Object> paramValues = new HashMap<>();
		if (searchContract.getSortBy() != null && !searchContract.getSortBy().isEmpty()) {
			validateSortByOrder(searchContract.getSortBy());
			validateEntityFieldName(searchContract.getSortBy(), MaterialIssueSearchContract.class);
		}
		String orderBy = "order by id";
		if (searchContract.getSortBy() != null && !searchContract.getSortBy().isEmpty()) {
			orderBy = "order by " + searchContract.getSortBy();
		}
		if (searchContract.getId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("id in (:ids)");
			paramValues.put("ids", searchContract.getId());
		}

		if (searchContract.getFromStore() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("fromstore = :fromstore");
			paramValues.put("fromstore", searchContract.getFromStore());
		}
		if (searchContract.getToStore() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("tostore = :tostore");
			paramValues.put("tostore", searchContract.getToStore());
		}
		if (searchContract.getIssueNoteNumber() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("issuenumber = :issuenumber");
			paramValues.put("issuenumber", searchContract.getIssueNoteNumber());
		}
		if (searchContract.getIssueDate() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("issuedate = :issuedate");
			paramValues.put("issuedate", searchContract.getIssueDate());
		}
		if (searchContract.getMaterialIssueStatus() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("materialissuestatus = :materialissuestatus");
			paramValues.put("materialissuestatus", searchContract.getMaterialIssueStatus());
		}
		if (searchContract.getDescription() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("description = :description");
			paramValues.put("description", searchContract.getDescription());
		}
		if (searchContract.getTotalIssueValue() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("totalissuevalue = :totalissuevalue");
			paramValues.put("totalissuevalue", searchContract.getTotalIssueValue());
		}
		if (searchContract.getTenantId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("tenantid = :tenantid");
			paramValues.put("tenantid", searchContract.getTenantId());
		}
		Pagination<MaterialIssue> page = new Pagination<>();
		if (searchContract.getPageSize() != null)
			page.setPageSize(searchContract.getPageSize());
		if (searchContract.getPageNumber() != null)
			page.setOffset(searchContract.getPageNumber());
		if (params.length() > 0)
			searchQuery = searchQuery.replace(":condition", " where " + params.toString());
		else
			searchQuery = searchQuery.replace(":condition", "");

		searchQuery = searchQuery.replace(":orderby", orderBy);
		page = (Pagination<MaterialIssue>) getPagination(searchQuery, page, paramValues);

		searchQuery = searchQuery + " :pagination";
		searchQuery = searchQuery.replace(":pagination",
				"limit " + page.getPageSize() + " offset " + page.getOffset() * page.getPageSize());
		BeanPropertyRowMapper row = new BeanPropertyRowMapper(MaterialIssueEntity.class);

		List<MaterialIssue> materialIssueList = new ArrayList<>();

		List<MaterialIssueEntity> materialIssueEntities = namedParameterJdbcTemplate.query(searchQuery.toString(),
				paramValues, row);

		for (MaterialIssueEntity materialIssueEntity : materialIssueEntities) {

			materialIssueList.add(materialIssueEntity.toDomain());
		}

		page.setTotalResults(materialIssueList.size());

		page.setPagedData(materialIssueList);

		return page;
	}
	
	public List<MaterialIssueDetail> getMaterialIssueDetailsByIssueNumber(String tenantId, List<String> materialIssueNumbers) {
		BeanPropertyRowMapper row = new BeanPropertyRowMapper(MaterialIssueDetailEntity.class);
		List<MaterialIssueDetail> materialIssueDetails = new ArrayList<>();
		Map<String,Object> paramValues = new HashMap<>();
		paramValues.put("tenantId", tenantId);
		paramValues.put("materialissuenumber", materialIssueNumbers);	
		List<MaterialIssueDetailEntity> materialIssueDetailEntities = namedParameterJdbcTemplate.
				query(getDetailQuery(), paramValues, row);
		for(MaterialIssueDetailEntity materialIssueDetailEntity : materialIssueDetailEntities ){
			materialIssueDetails.add(materialIssueDetailEntity.toDomain());
		}
		return materialIssueDetails;
}

	private String getDetailQuery() {
       return "select * from materialissuedetail where tenantId = :tenantId and materialissuenumber in (:materialissuenumber)";		
	}

	public void compareAndGenerateObjects(List<MaterialIssue> materialIssues,
			List<MaterialIssueDetail> materialIssueDetails) {
		List<MaterialIssueDetail> materialIssueDetail = new ArrayList<>();
		for(MaterialIssue materialIssue :materialIssues ){
			materialIssueDetail.addAll(materialIssue.getMaterialIssueDetails());
		}
		
		
		
	
		
	}
}