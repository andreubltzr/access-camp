package com.example.springproject.signup;

import com.example.springproject.activity.Activity;
import com.example.springproject.camper.Camper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Signup")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "camper_id", referencedColumnName = "id")
    private Camper camper;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

    private int time;

}
