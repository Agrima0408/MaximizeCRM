package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CampaignName;
    private String CampaignDescription;
    private LocalDate CampaignStartDate;
    private LocalDate CampaignEndDate;
    private Long CampaignBudget;
    private enum CampaignStatus{
        PLANNED,
        ACTIVE,
        COMPLETED,
        CANCELLED;
    }
    @Enumerated(EnumType.STRING)
    private CampaignStatus campaignStatus;

    @OneToMany(mappedBy = "campaignEntity")
    @JsonManagedReference("campaign-leads")
    private List<Lead> leads = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampaignName() {
        return CampaignName;
    }

    public void setCampaignName(String campaignName) {
        CampaignName = campaignName;
    }

    public String getCampaignDescription() {
        return CampaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        CampaignDescription = campaignDescription;
    }

    public LocalDate getCampaignStartDate() {
        return CampaignStartDate;
    }

    public void setCampaignStartDate(LocalDate campaignStartDate) {
        CampaignStartDate = campaignStartDate;
    }

    public LocalDate getCampaignEndDate() {
        return CampaignEndDate;
    }

    public void setCampaignEndDate(LocalDate campaignEndDate) {
        CampaignEndDate = campaignEndDate;
    }

    public Long getCampaignBudget() {
        return CampaignBudget;
    }

    public void setCampaignBudget(Long campaignBudget) {
        CampaignBudget = campaignBudget;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public CampaignStatus getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
    }
}
