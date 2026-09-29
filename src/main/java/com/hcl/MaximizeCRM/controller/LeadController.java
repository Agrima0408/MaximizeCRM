package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.model.Customer;
import com.hcl.MaximizeCRM.model.Lead;
import com.hcl.MaximizeCRM.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeadController {
    private LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService=leadService;
    }

    @GetMapping("/api/leads")
    public List<Lead> getLeads(){
        return leadService.findAll();
    }

    @GetMapping("/api/leads/{id}")
    public Optional<Lead> getLeadById(@PathVariable Long id){
        return leadService.findById(id);
    }

    @PostMapping("/api/leads")
    public Lead save(@RequestBody Lead lead){
        return leadService.save(lead);
    }

    @DeleteMapping("/api/leads/{id}")
    public void deleteLeadById(@PathVariable Long id){
        leadService.deleteById(id);
    }
}
