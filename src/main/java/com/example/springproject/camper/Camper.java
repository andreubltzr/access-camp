package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private int id;
    private String name;
    private int age;
    private String username;
    private String password;

    public Camper(CamperDTO camperDTO) {
        this.name = camperDTO.getName();
        this.age = camperDTO.getAge();
        this.username = camperDTO.getUsername();
        this.password = camperDTO.getPassword();
    }
}
