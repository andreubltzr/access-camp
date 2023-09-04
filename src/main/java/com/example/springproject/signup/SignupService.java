package com.example.springproject.signup;

import com.example.springproject.activity.Activity;
import com.example.springproject.activity.ActivityRepository;
import com.example.springproject.camper.Camper;
import com.example.springproject.camper.CamperRepository;
import com.example.springproject.signup.dto.SignupDTO;
import com.example.springproject.signup.dto.SignupMapper;
import com.example.springproject.signup.dto.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

@Service
@Validated
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;
    @Autowired
    private CamperRepository camperRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private SignupMapper signupMapper;

    public SignupResponseDTO createSignup(SignupDTO signupDTO) {
        try {
            Camper camper =
                    camperRepository.findById(signupDTO.getCamperId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Camper not found"));
            Activity activity =
                    activityRepository.findById(signupDTO.getActivityId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Activity not found"));

            Signup signup = signupMapper.mapToEntity(signupDTO, camper, activity);

            Signup createdSignup = signupRepository.save(signup);

            return signupMapper.mapToResponseDTO(createdSignup);
        } catch (Exception e) {
            throw new RuntimeException("Error signing up.", e);
        }
    }
}
