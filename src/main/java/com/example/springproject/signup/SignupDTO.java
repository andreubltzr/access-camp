package com.example.springproject.signup;

import com.example.springproject.activity.ActivityDTO;
import com.example.springproject.camper.CamperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    private CamperDTO camperDTO;
    private ActivityDTO activityDTO;
}
