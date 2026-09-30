package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.model.Opportunity;
import com.hcl.MaximizeCRM.service.OpportunityService;
import com.hcl.MaximizeCRM.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityController {
    private OpportunityService opportunityService;
    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    @GetMapping("/api/opportunities")
    public List<Opportunity> getOpportunities() {
        return opportunityService.findAll();
    }

    @GetMapping("/api/opportunities/{id}")
    public Optional<Opportunity> getOpportunityById(@PathVariable Long id) {
        return opportunityService.findById(id);
    }

    @PostMapping("/api/opportunities")
    public Opportunity createOpportunity(@Valid @RequestBody Opportunity opp) {
        return opportunityService.save(opp);
    }

    @DeleteMapping("/api/opportunities/{id}")
    public void deleteOpportunityById(@PathVariable Long id) {
        opportunityService.deleteById(id);
    }
}
