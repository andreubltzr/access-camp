package com.example.springproject.signup.dto;

import com.example.springproject.activity.ActivityDTO;
import com.example.springproject.camper.dto.CamperDTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    @NotNull(message = "Camper ID required.")
    private Integer camper_id;

    @NotNull(message = "Activity ID required.")
    private Integer activity_id;

    @NotNull(message = "Time required.")
    @Min(value = 0, message = "Time should be between 0 and 23.")
    @Max(value = 23, message = "Time should be between 0 and 23.")
    private Integer time;
}
