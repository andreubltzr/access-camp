package com.example.springproject.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Async
    public CompletableFuture<Activity> createActivity(ActivityDTO activityDTO) {
        try {
            Activity activity = new Activity(activityDTO);
            activityRepository.save(activity);
            return CompletableFuture.completedFuture(activity);
        } catch (Exception e) {
            throw new RuntimeException("Error creating activity.", e);
        }
    }

    @Async
    public CompletableFuture<List<Activity>> getAllActivity() {
        try {
        List<Activity> activities = activityRepository.findAll();
        return CompletableFuture.completedFuture(activities);
        } catch (Exception e) {
            throw new RuntimeException("Error getting activities list.", e);
        }
    }

    @Async
    public CompletableFuture<String> deleteActivity(int activityId) {
        try {
        activityRepository.deleteById(activityId);
        return CompletableFuture.completedFuture("Activity deleted.");
        } catch (Exception e) {
            throw new RuntimeException("Error deleting activity", e);
        }
    }
}
