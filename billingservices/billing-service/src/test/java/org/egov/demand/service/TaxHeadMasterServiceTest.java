package org.egov.demand.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.demand.config.ApplicationProperties;
import org.egov.demand.model.TaxHeadMaster;
import org.egov.demand.model.TaxHeadMasterCriteria;
import org.egov.demand.model.TaxPeriod;
import org.egov.demand.model.enums.Category;
import org.egov.demand.producer.TaxHeadMasterProducer;
import org.egov.demand.repository.TaxHeadMasterRepository;
import org.egov.demand.web.contract.TaxHeadMasterRequest;
import org.egov.demand.web.contract.TaxHeadMasterResponse;
import org.egov.demand.web.contract.factory.ResponseFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TaxHeadMasterServiceTest {

	@InjectMocks
	private TaxHeadMasterService taxHeadMasterService;

	@Mock
	private ResponseFactory responseInfoFactory;

	@Mock
	private TaxHeadMasterRepository taxHeadMasterRepository;

	@Mock
	private ObjectMapper objectMapper;

	@Mock
	private TaxHeadMasterProducer taxHeadMasterProducer;

	@Mock
	private ApplicationProperties applicationProperties;

	@Test
	public void testSearch() {
		List<TaxHeadMaster> taxHeadMasters = new ArrayList<>();
		taxHeadMasters.add(getTaxHeadMaster());
		TaxHeadMasterResponse taxHeadMasterResponse = new TaxHeadMasterResponse();
		taxHeadMasterResponse.setTaxHeadMasters(taxHeadMasters);
		when(taxHeadMasterRepository.findForCriteria(Matchers.any(TaxHeadMasterCriteria.class)))
				.thenReturn(taxHeadMasters);
		TaxHeadMasterCriteria taxHeadMasterCriteria = TaxHeadMasterCriteria.builder().tenantId("ap.kurnool").build();
		assertEquals(taxHeadMasterResponse, taxHeadMasterService.getTaxHeads(taxHeadMasterCriteria, new RequestInfo()));
	}
	
	@Test
	public void testCreate() {
		List<TaxHeadMaster> taxHead = new ArrayList<>();
		TaxHeadMaster taxHeadMaster = getTaxHeadMaster();
		taxHead.add(taxHeadMaster);
		TaxHeadMasterRequest taxHeadMasterRequest = new TaxHeadMasterRequest();
		taxHeadMasterRequest.setTaxHeadMasters(taxHead);

		List<TaxHeadMaster> taxHeads = new ArrayList<>();
		taxHeads.add(taxHeadMaster);
		TaxHeadMasterResponse taxHeadMasterResponse = new TaxHeadMasterResponse();
		taxHeadMasterResponse.setResponseInfo(null);
		taxHeadMasterResponse.setTaxHeadMasters(taxHeads);

		when(taxHeadMasterRepository.create(any(TaxHeadMasterRequest.class))).thenReturn(taxHead);

		assertTrue(taxHeadMasterResponse.equals(taxHeadMasterService.create(taxHeadMasterRequest)));
	}

	private TaxHeadMaster getTaxHeadMaster() {
		TaxHeadMaster taxHeadMaster = new TaxHeadMaster();
		TaxPeriod taxPeriod = new TaxPeriod();
		taxHeadMaster.setId("23");
		taxHeadMaster.setCode("string");
		taxHeadMaster.setTenantId("ap.kurnool");
		taxHeadMaster.setCategory(Category.fromValue("TAX"));
		taxHeadMaster.setService("string");
		taxHeadMaster.setName("string");
		taxHeadMaster.setGlCode("string");
		taxHeadMaster.setIsDebit(true);
		taxHeadMaster.setIsActualDemand(true);
		taxPeriod.setId("string");
		taxPeriod.setCode("string");
		taxPeriod.setFinancialYear("2017-2018");
		taxPeriod.setService("string");
		taxPeriod.setFromDate(123L);
		taxPeriod.setToDate(345L);

		taxHeadMaster.setTaxPeriod(taxPeriod);
		return taxHeadMaster;
	}

}
