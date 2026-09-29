package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
    private CampaignService campaignService;
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }
}
