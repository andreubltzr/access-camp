package com.example.springproject.camper.dto;

import com.example.springproject.activity.dto.ActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamperActivityDTO {

    private int id;
    private String name;
    private int age;
    private List<ActivityDTO> activityList;
}
