package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.repository.LeadRepository;
import org.springframework.stereotype.Service;

@Service
public class LeadService {
    private final LeadRepository leadRepository;
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }
}
