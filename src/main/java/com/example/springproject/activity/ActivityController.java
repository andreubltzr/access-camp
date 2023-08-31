package com.example.springproject.activity;

import com.example.springproject.utils.ValidationUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public Activity createActivity(@Valid @RequestBody ActivityDTO activityDTO, BindingResult bindingResult) {

        ValidationUtility.validateDTO(bindingResult);

        return activityService.createActivity(activityDTO);
    }

    @GetMapping
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }
}
