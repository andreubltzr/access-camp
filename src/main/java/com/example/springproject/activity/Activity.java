package com.example.springproject.activity;

import com.example.springproject.activity.dto.ActivityDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Activity")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int difficulty;

    public Activity(ActivityDTO activityDTO) {
        this.name = activityDTO.getName();
        this.difficulty = activityDTO.getDifficulty();
    }
}
