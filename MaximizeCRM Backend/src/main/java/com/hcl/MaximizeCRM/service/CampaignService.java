package com.hcl.MaximizeCRM.service;

import com.hcl.MaximizeCRM.model.Campaign;
import com.hcl.MaximizeCRM.repository.CampaignRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }


    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> findById(Long id) {
        return campaignRepository.findById(id);
    }

    public Campaign save(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteById(Long id) {
        campaignRepository.deleteById(id);
    }
}
