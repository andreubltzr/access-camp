package com.example.springproject.camper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Camper")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name required.")
    @NotNull(message = "Name required.")
    private String name;

    @Min(value = 8, message = "Minimum age: 8.")
    @Max(value = 18, message = "Maximum age: 18.")
    private Integer age;

    @NotEmpty(message = "Username required.")
    @NotNull(message = "Username required.")
    private String username;

    @NotEmpty(message = "Password required.")
    @NotNull(message = "Password required.")
    @Size(min = 8, message = "Password must have at least 8 characters.")
    private String password;
}
