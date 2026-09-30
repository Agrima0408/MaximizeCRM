package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String UserName;
    @Email
    @NotBlank
    private String UserEmail;
    @NotBlank
    private String UserPassword;
    public enum UserRole {
        Admin , Sales_Executive , Manager;
    }
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @NotNull
    private Long UserPhone;
    private boolean UserActive;

    @OneToMany(mappedBy="userEntity")
    @JsonManagedReference("user-opportunities")
    private List<Opportunity> opportunities = new ArrayList<>();

    @OneToMany(mappedBy="userEntity")
    @JsonManagedReference("user-leads")
    private List<Lead> leads = new ArrayList<>();

    @OneToMany(mappedBy="userEntity")
    @JsonManagedReference("user-activities")
    private List<Activity> activities = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public Long getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(Long userPhone) {
        UserPhone = userPhone;
    }

    public boolean isUserActive() {
        return UserActive;
    }

    public void setUserActive(boolean userActive) {
        UserActive = userActive;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
