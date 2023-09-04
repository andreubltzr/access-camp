package com.example.springproject.activity;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {

    private int id;
    @NotEmpty(message = "Name is required.")
    private String name;
    @NotNull(message = "Difficulty is required.")
    private int difficulty;

    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.name = activity.getName();
        this.difficulty = activity.getDifficulty();
    }
}
