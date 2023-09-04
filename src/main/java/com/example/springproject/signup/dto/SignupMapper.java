package com.example.springproject.signup.dto;

import com.example.springproject.activity.Activity;
import com.example.springproject.camper.Camper;
import com.example.springproject.signup.Signup;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Signup mapToEntity(SignupDTO signupDTO, Camper camper, Activity activity) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Signup signup = modelMapper.map(signupDTO, Signup.class);
        signup.setCamper(camper);
        signup.setActivity(activity);
        return signup;
    }

    public SignupResponseDTO mapToResponseDTO(Signup signup) {
        return new SignupResponseDTO(signup);
    }
}
