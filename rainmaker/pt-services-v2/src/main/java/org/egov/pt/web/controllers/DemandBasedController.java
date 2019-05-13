package org.egov.pt.web.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.egov.pt.config.PropertyConfiguration;
import org.egov.pt.producer.Producer;
import org.egov.pt.repository.ServiceRequestRepository;
import org.egov.pt.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/demandBased")
public class DemandBasedController {

    @Autowired
    private PropertyConfiguration config;

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Producer producer;




    @RequestMapping(value = "/_generate", method = RequestMethod.POST)
    public ResponseEntity<DemandBasedAssessmentResponse> create(@Valid @RequestBody DemandGenerationRequest demandGenerationRequest) {

        SearchCriteriaRequest searchCriteriaRequest = SearchCriteriaRequest.builder()
                .searchCriteria(demandGenerationRequest.getSearchCriteria())
                .requestInfo(demandGenerationRequest.getRequestInfo())
                .build();

        Object response = serviceRequestRepository.fetchResult(getSearcherUrl(), searchCriteriaRequest);
        DemandBasedAssessmentResponse demandBasedAssessmentResponse = mapper.convertValue(response,DemandBasedAssessmentResponse.class);
        enrichFinancialYear(demandBasedAssessmentResponse.getDemandBasedAssessments(), demandGenerationRequest.getFinancialYear());
        DemandBasedAssessmentRequest request = DemandBasedAssessmentRequest.builder()
                .requestInfo(demandGenerationRequest.getRequestInfo())
                .demandBasedAssessments(demandBasedAssessmentResponse.getDemandBasedAssessments())
                .build();
        producer.push(config.getDemandBasedPTTopic(),request);
        return new ResponseEntity<>(demandBasedAssessmentResponse, HttpStatus.OK);
    }


    private StringBuilder getSearcherUrl(){
       StringBuilder url = new StringBuilder(config.getDemandBasedSearcherHost());
       url.append(config.getDemandBasedSearcherEndpoint());
       return url;
    }


    private void enrichFinancialYear(List<DemandBasedAssessment> demandBasedAssessments,String financialYear){
        demandBasedAssessments.forEach(demandBasedAssessment -> {
            demandBasedAssessment.setFinancialYear(financialYear);
        });
    }


}
