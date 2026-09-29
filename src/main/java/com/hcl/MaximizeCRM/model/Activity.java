package com.hcl.MaximizeCRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activity {

    @ManyToOne
    @JsonBackReference("customer-activities")
    private Customer customerEntity;

    @ManyToOne
    @JsonBackReference("user-activities")
    private User userEntity;

    @ManyToMany
    @JoinTable(
            name = "activity_product",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference("activity-products")
    private List<Product> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum ActivityTitle{
        CALL,
        MEETING,
        FOLLOW_UP;
    }
    private String ActivityDescription;
    private LocalDate ActivityScheduledAt;
    private enum ActivityStatus{
        PENDING,
        COMPLETED,
        CANCELLED;
    }

    @Enumerated(EnumType.STRING)
    private ActivityTitle activityTitle;

    @Enumerated(EnumType.STRING)
    private ActivityStatus activityStatus;


    //GETTER & SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityDescription() {
        return ActivityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        ActivityDescription = activityDescription;
    }

    public LocalDate getActivityScheduledAt() {
        return ActivityScheduledAt;
    }

    public void setActivityScheduledAt(LocalDate activityScheduledAt) {
        ActivityScheduledAt = activityScheduledAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public ActivityTitle getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(ActivityTitle activityTitle) {
        this.activityTitle = activityTitle;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }
}
