package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.model.Opportunity;
import com.hcl.MaximizeCRM.repository.OpportunityRepository;
import com.hcl.MaximizeCRM.repository.ProductRepository;
import com.hcl.MaximizeCRM.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService {
    private final OpportunityRepository opportunityRepository;
    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }
    public Optional<Opportunity> findById(Long id) {
        return opportunityRepository.findById(id);
    }
    public Opportunity save(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }
    public void deleteById(Long id) {
        opportunityRepository.deleteById(id);
    }
}
