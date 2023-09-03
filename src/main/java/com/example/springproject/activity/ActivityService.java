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
            Activity activity = new Activity();
            activity.setName(activityDTO.getName());
            activity.setDifficulty(activityDTO.getDifficulty());
            activityRepository.save(activity);
            return CompletableFuture.completedFuture(activity);
        } catch (Exception e) {
            throw new RuntimeException("Error creating activity.", e);
        }
    }

    @Async
    public CompletableFuture<List<Activity>> getAllActivity() {
        List<Activity> activities = activityRepository.findAll();
        return CompletableFuture.completedFuture(activities);
    }

    @Async
    public CompletableFuture<String> deleteActivity(Integer activityId) {
        activityRepository.deleteById(activityId);

        return CompletableFuture.completedFuture("Activity deleted.");
    }
}
