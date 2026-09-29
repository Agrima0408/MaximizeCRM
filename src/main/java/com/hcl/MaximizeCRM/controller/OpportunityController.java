package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.OpportunityService;
import com.hcl.MaximizeCRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpportunityController {
    private OpportunityService opportunityService;
    public OpportunityController(OpportunityService oppotunityService) {
        this.opportunityService = oppotunityService;
    }
}
