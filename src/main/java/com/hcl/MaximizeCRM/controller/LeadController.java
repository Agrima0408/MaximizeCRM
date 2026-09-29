package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadController {
    private LeadService leadService;
    @Autowired
    public void SetLeadService(LeadService leadService) {
        this.leadService=leadService;
    }
}
