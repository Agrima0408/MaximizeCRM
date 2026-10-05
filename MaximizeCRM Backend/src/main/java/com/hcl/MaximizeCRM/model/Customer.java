package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String CustomerName;
    @Email
    @NotBlank
    private String CustomerEmail;
    @NotBlank
    private String CustomerPhone;
    private String CustomerAddress;
    private String CustomerCity;
    public enum CustomerType {
        New,
        Existing
    }
    @Enumerated(EnumType.STRING)
    private CustomerType CustomerType;

    private LocalDateTime CustomerCreatedAt;

    @OneToMany(mappedBy="customerEntity")
    @JsonManagedReference("customer-opportunities")
    private List<Opportunity> opportunities = new ArrayList<>();

    @OneToMany(mappedBy="customerEntity")
    @JsonManagedReference("customer-activities")
    private List<Activity> activities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public void setCustomerCity(String customerCity) {
        CustomerCity = customerCity;
    }

    public CustomerType getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(CustomerType customerType) {
        CustomerType = customerType;
    }

    public LocalDateTime getCustomerCreatedAt() {
        return CustomerCreatedAt;
    }

    public void setCustomerCreatedAt(LocalDateTime customerCreatedAt) {
        CustomerCreatedAt = customerCreatedAt;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
