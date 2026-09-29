package com.hcl.MaximizeCRM.service;

import com.hcl.MaximizeCRM.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
}
