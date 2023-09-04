package com.example.springproject.signup.dto;

import com.example.springproject.signup.Signup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponseDTO {

    private int id;
    private int camperId;
    private int activityId;
    private int time;

    public SignupResponseDTO(Signup signup) {
        this.id = signup.getId();
        this.camperId = signup.getCamper().getId();
        this.activityId = signup.getActivity().getId();
        this.time = signup.getTime();
    }
}
