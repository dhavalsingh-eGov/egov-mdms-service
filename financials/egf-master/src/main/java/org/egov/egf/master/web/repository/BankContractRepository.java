package org.egov.egf.master.web.repository;

import org.egov.egf.master.web.contract.BankContract;
import org.egov.egf.master.web.requests.BankResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BankContractRepository {
	private RestTemplate restTemplate;
	private String hostUrl;
	public static final String SEARCH_URL = " /egf-master/banks/search?";
	@Autowired
	private ObjectMapper objectMapper;

	public BankContractRepository(@Value("${egf.masterhost.url}") String hostUrl, RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.hostUrl = hostUrl;
	}

	public BankContract findById(BankContract bankContract) {

		String url = String.format("%s%s", hostUrl, SEARCH_URL);
		StringBuffer content = new StringBuffer();
		if (bankContract.getId() != null) {
			content.append("id=" + bankContract.getId());
		}

		if (bankContract.getTenantId() != null) {
			content.append("&tenantId=" + bankContract.getTenantId());
		}
		url = url + content.toString();
		BankResponse result = restTemplate.postForObject(url, null, BankResponse.class);

		if (result.getBanks() != null && result.getBanks().size() == 1) {
			return result.getBanks().get(0);
		} else {
			return null;
		}

	}
}