package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Entity
public class Opportunity {
    @ManyToOne
    @JsonBackReference("customer-opportunities")
    private Customer customerEntity;

    @ManyToOne
    @JsonBackReference("user-opportunities")
    private User userEntity;

    @ManyToOne
    @JsonBackReference("lead-opportunities")
    private Lead leadEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String Title;
    private String Description;
    @NotNull
    @PositiveOrZero
    @Column(name = "opportunity_value")
    private Long Value;

    public enum Status{
        OPEN,
        NEGOTIATION,
        WON,
        LOST;
    }
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    private LocalDateTime expectedCloseDate;
    private LocalDateTime CreatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getValue() {
        return Value;
    }

    public void setValue(Long value) {
        Value = value;
    }

    public LocalDateTime getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate(LocalDateTime expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public Customer getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(Customer customerEntity) {
        this.customerEntity = customerEntity;
    }

    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User userEntity) {
        this.userEntity = userEntity;
    }

    public Lead getLeadEntity() {
        return leadEntity;
    }

    public void setLeadEntity(Lead leadEntity) {
        this.leadEntity = leadEntity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
