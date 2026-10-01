package com.hcl.MaximizeCRM.repository;

import com.hcl.MaximizeCRM.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}