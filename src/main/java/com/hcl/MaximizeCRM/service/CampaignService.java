package com.hcl.MaximizeCRM.service;

import com.hcl.MaximizeCRM.repository.CampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }
}
