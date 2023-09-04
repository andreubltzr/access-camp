package com.example.springproject.signup.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    @NotNull(message = "Camper ID required.")
    private Integer camperId;

    @NotNull(message = "Activity ID required.")
    private Integer activityId;

    @NotNull(message = "Time required.")
    @Min(value = 0, message = "Time should be between 0 and 23.")
    @Max(value = 23, message = "Time should be between 0 and 23.")
    private Integer time;
}
