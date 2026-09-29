package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
    private CampaignService campaignService;
    @Autowired
    public void setCampaignService(CampaignService campaignService) {
        this.campaignService = campaignService;
    }
}
