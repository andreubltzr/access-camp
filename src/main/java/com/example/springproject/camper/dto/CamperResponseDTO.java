package com.example.springproject.camper.dto;

import com.example.springproject.camper.Camper;
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

    public CamperResponseDTO(Camper camper) {
        this.id = camper.getId();
        this.name = camper.getName();
        this.age = camper.getAge();
    }
}
