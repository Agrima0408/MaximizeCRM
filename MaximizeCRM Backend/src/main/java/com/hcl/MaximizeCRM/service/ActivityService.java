package com.hcl.MaximizeCRM.service;

import com.hcl.MaximizeCRM.model.Activity;
import com.hcl.MaximizeCRM.model.Product;
import com.hcl.MaximizeCRM.repository.ActivityRepository;
import com.hcl.MaximizeCRM.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ProductRepository productRepository;

    public ActivityService(ActivityRepository activityRepository,
                           ProductRepository productRepository) {
        this.activityRepository = activityRepository;
        this.productRepository = productRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }

    public Activity save(Activity activity) {

        if (activity.getProducts() != null) {

            List<Product> products = activity.getProducts().stream()
                    .map(product -> productRepository.findById(product.getId())
                            .orElseThrow(() ->
                                    new RuntimeException("Product not found: " + product.getId())))
                    .toList();

            activity.setProducts(products);
        }

        return activityRepository.save(activity);
    }

    public void deleteById(Long id) {
        activityRepository.deleteById(id);
    }
}