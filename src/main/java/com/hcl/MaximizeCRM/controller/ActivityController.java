package com.hcl.MaximizeCRM.controller;

import com.hcl.MaximizeCRM.model.Activity;
import com.hcl.MaximizeCRM.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {
    private ActivityService activityService;
    
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/api/activities")
    public List<Activity> getActivities(){
        return activityService.findAll();
    }

    @GetMapping("/api/activities/{id}")
    public Optional<Activity> getActivityById(@PathVariable Long id){
        return activityService.findById(id);
    }

    @PostMapping("/api/activities")
    public Activity createActivity(@Valid @RequestBody Activity activity){
        return activityService.save(activity);
    }

    @DeleteMapping("/api/activities/{id}")
    public void deleteActivityById(@PathVariable Long id){
        activityService.deleteById(id);
    }
}
