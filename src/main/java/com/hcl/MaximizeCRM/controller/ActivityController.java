package com.hcl.MaximizeCRM.controller;

import com.hcl.MaximizeCRM.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    private ActivityService activityService;
    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
