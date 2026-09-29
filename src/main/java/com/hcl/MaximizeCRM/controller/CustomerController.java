package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.model.Customer;
import com.hcl.MaximizeCRM.model.User;
import com.hcl.MaximizeCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/api/customers")
    public List<Customer> getCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/api/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PostMapping("/api/customers")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteById(id);
    }
}
