package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.model.Campaign;
import com.hcl.MaximizeCRM.service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CampaignController {
    private CampaignService campaignService;
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/api/campaigns")
    public List<Campaign> findAllCampaigns() {
        return campaignService.findAll();
    }

    @GetMapping("/api/campaigns/{id}")
    public Optional<Campaign> findById(@PathVariable Long id) {
        return campaignService.findById(id);
    }

    @PostMapping("/api/campaigns")
    public Campaign save(@Valid @RequestBody Campaign campaign) {
        return campaignService.save(campaign);
    }

    @DeleteMapping("/api/campaigns/{id}")
    public void deleteById(@PathVariable Long id) {
        campaignService.deleteById(id);
    }
}
