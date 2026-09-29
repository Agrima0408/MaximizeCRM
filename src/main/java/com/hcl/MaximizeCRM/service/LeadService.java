package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.model.Lead;
import com.hcl.MaximizeCRM.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    private final LeadRepository leadRepository;
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public List<Lead> findAll(){
        return leadRepository.findAll();
    }

    public Optional<Lead> findById(Long id){
        return leadRepository.findById(id);
    }

    public Lead save(Lead lead){
        return leadRepository.save(lead);
    }


    public void deleteById(Long id){
        leadRepository.deleteById(id);
    }

//    public getLeadsByStatus(Lead.LeadStatus status){
//
//    }
}
