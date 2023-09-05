package com.example.springproject.activity;

import com.example.springproject.activity.dto.ActivityDTO;
import com.example.springproject.utils.ValidationUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public CompletableFuture<Activity> createActivity(@Valid @RequestBody ActivityDTO activityDTO, BindingResult bindingResult) {
        ValidationUtility.validateDTO(bindingResult);
        return activityService.createActivity(activityDTO);
    }

    @GetMapping
    public CompletableFuture<List<Activity>> getAllActivity() {
        return activityService.getAllActivity();
    }

    @DeleteMapping("/{activityId}")
    public CompletableFuture<String> deleteActivity(@PathVariable int activityId) {
        return activityService.deleteActivity(activityId);
    }
}
