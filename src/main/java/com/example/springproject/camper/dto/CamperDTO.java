package com.example.springproject.camper.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamperDTO {

    @NotEmpty(message = "Name required.")
    @NotNull(message = "Name required.")
    private String name;

    @Min(value = 8, message = "Minimum age: 8.")
    @Max(value = 18, message = "Maximum age: 18.")
    @NotNull(message = "Age required.")
    private int age;

    @NotEmpty(message = "Username required.")
    @NotNull(message = "Username required.")
    private String username;

    @NotEmpty(message = "Password required.")
    @NotNull(message = "Password required.")
    @Size(min = 8, message = "Password must have at least 8 characters.")
    private String password;
}
