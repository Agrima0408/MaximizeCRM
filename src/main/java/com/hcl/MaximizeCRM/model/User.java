package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private enum UserRole {
        Admin , Sales_Executive , Manager;
    }
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
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
