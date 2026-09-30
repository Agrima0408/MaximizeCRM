package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.model.Product;
import com.hcl.MaximizeCRM.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/api/products")
    public Product saveProduct(@Valid @RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }
}
