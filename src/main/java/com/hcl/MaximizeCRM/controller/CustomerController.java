package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
