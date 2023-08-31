package com.example.springproject.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(ActivityDTO activityDTO) {
        try {
            Activity activity = new Activity();
            activity.setName(activityDTO.getName());
            activity.setDifficulty(activityDTO.getDifficulty());

            return activityRepository.save(activity);
        } catch (Exception e) {
            throw new RuntimeException("Error creating activity.", e);
        }
    }

    public List<Activity> getAllActivity() {
        return activityRepository.findAll();
    }
}
