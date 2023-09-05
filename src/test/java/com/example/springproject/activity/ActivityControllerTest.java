package com.example.springproject.activity;

import com.example.springproject.activity.dto.ActivityDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ActivityControllerTest {

    @InjectMocks
    private ActivityController activityController;

    @Mock
    private ActivityService activityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("getAllActivity should return the list of all activities")
    public void getAllActivity() throws Exception {
        List<Activity> mockActivities = Arrays.asList(
                new Activity(1, "Test Activity 1", 1),
                new Activity(2, "Test Activity 2", 2)
        );

        when(activityService.getAllActivity()).thenReturn(CompletableFuture.completedFuture(mockActivities));

        CompletableFuture<List<Activity>> res = activityController.getAllActivity();

        List<Activity> activities = res.get();

        assertNotNull(activities);
        assertEquals(mockActivities, activities);
    }

    @Test
    @DisplayName("createActivity should return a new activity")
    public void createActivity() throws Exception {
        ActivityDTO mockActivityDTO = new ActivityDTO();
        mockActivityDTO.setName("Test Activity");
        mockActivityDTO.setDifficulty(3);

        BindingResult mockBindingResult = mock(BindingResult.class);

        Activity mockActivity = new Activity(1, "Test Activity", 1);

        when(activityService.createActivity(mockActivityDTO)).thenReturn(CompletableFuture.completedFuture(mockActivity));

        CompletableFuture<Activity> res = activityController.createActivity(mockActivityDTO, mockBindingResult);

        Activity activityResponse = res.get();

        assertNotNull(activityResponse);
        assertEquals(mockActivity, activityResponse);
    }

    @Test
    @DisplayName("deletedActivity should delete an activity")
    public void deleteActivity() throws Exception {
        int activityId = 1;

        when(activityService.deleteActivity(activityId)).thenReturn(CompletableFuture.completedFuture(
                "Activity deleted."));

        CompletableFuture<String> res = activityController.deleteActivity(activityId);

        String deleteResult = res.get();

        assertEquals("Activity deleted.", deleteResult);
    }
}
