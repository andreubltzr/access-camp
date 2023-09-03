package com.example.springproject.camper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamperResponseDTO {

    private int id;
    private String name;
    private int age;
}
