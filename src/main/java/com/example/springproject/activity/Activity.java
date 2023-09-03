package com.example.springproject.activity;

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
    private Integer id;
    private String name;
    private Integer difficulty;

    public Activity(ActivityDTO activityDTO) {
        this.name = activityDTO.getName();
        this.difficulty = activityDTO.getDifficulty();
    }
}
