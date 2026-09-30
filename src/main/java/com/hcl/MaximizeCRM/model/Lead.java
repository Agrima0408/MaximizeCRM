package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String LeadName;
    @Email
    @NotBlank
    private String LeadEmail;
    @NotBlank
    private String LeadPhone;
    private enum LeadSource {
        WEBSITE,SOCIAL_MEDIA,ADVERTISEMENT,REFERRAL;
    }
    private enum LeadStatus{
        PENDING,
        ACTIVE,
        ON_HOLD,
        SUCCESSFUL,
        UNSUCCESSFUL
    }
    //    PENDING → Lead has been added but hasn't been actively worked on yet.
//    ACTIVE → Sales team is currently dealing with the lead.
//    ON_HOLD → Interaction is temporarily paused.
//    SUCCESSFUL → Lead resulted in a successful conversion.
//    UNSUCCESSFUL → Lead didn't convert / opportunity was lost.

    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;

    @Enumerated(EnumType.STRING)
    private LeadSource leadSource;

    @ElementCollection
    private List<String> requirement;

    private LocalDateTime LeadCreatedAt;
    private String LeadAssignedTo;

    @ManyToOne
    @JsonBackReference("campaign-leads")
    private Campaign campaignEntity;

    @ManyToOne
    @JsonBackReference("user-leads")
    private User userEntity;

    @OneToMany(mappedBy = "leadEntity")
    @JsonManagedReference("lead-opportunities")
    private List<Opportunity> opportunities = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeadName() {
        return LeadName;
    }

    public void setLeadName(String leadName) {
        LeadName = leadName;
    }

    public String getLeadEmail() {
        return LeadEmail;
    }

    public void setLeadEmail(String leadEmail) {
        LeadEmail = leadEmail;
    }

    public String getLeadPhone() {
        return LeadPhone;
    }

    public void setLeadPhone(String leadPhone) {
        LeadPhone = leadPhone;
    }

    public List<String> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<String> requirement) {
        this.requirement = requirement;
    }

    public LocalDateTime getLeadCreatedAt() {
        return LeadCreatedAt;
    }

    public void setLeadCreatedAt(LocalDateTime leadCreatedAt) {
        LeadCreatedAt = leadCreatedAt;
    }

    public String getLeadAssignedTo() {
        return LeadAssignedTo;
    }

    public void setLeadAssignedTo(String leadAssignedTo) {
        LeadAssignedTo = leadAssignedTo;
    }

    public Campaign getCampaignEntity() {
        return campaignEntity;
    }

    public void setCampaignEntity(Campaign campaignEntity) {
        this.campaignEntity = campaignEntity;
    }

    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User userEntity) {
        this.userEntity = userEntity;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(LeadStatus leadStatus) {
        this.leadStatus = leadStatus;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(LeadSource leadSource) {
        this.leadSource = leadSource;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
