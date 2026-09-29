package com.hcl.MaximizeCRM.repository;


import com.hcl.MaximizeCRM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Customer,Long> {
}
