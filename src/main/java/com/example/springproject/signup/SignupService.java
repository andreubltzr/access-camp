package com.example.springproject.signup;

import com.example.springproject.signup.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    public Signup createSignup(SignupDTO signupDTO) {
        try {
        Signup signup = new Signup(signupDTO.getCamper_id(), signupDTO.getActivity_id(), signupDTO.getTime());
        return signupRepository.save(signup);
        } catch (Exception e) {
            throw new RuntimeException("Error signing up.", e);
        }
    }
}
