package com.example.springproject.signup.dto;

import com.example.springproject.camper.dto.CamperResponseDTO;
import com.example.springproject.signup.Signup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponseDTO {

    private int id;
    private int camper_id;
    private int activity_id;
    private int time;

    public SignupResponseDTO(Signup signup) {
        this.id = signup.getId();
        this.camper_id = signup.getCamper().getId();
        this.activity_id = signup.getActivity().getId();
        this.time = signup.getTime();
    }
}
