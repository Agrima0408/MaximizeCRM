package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.repository.OpportunityRepository;
import com.hcl.MaximizeCRM.repository.ProductRepository;
import com.hcl.MaximizeCRM.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {
    private final OpportunityRepository opportunityRepository;
    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }
}
