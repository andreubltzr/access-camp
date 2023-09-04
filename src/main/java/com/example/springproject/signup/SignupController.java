package com.example.springproject.signup;

import com.example.springproject.signup.dto.SignupDTO;
import com.example.springproject.signup.dto.SignupResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping
    public SignupResponseDTO createSignup(@Valid @RequestBody SignupDTO signupDTO) {
        Signup signup = signupService.createSignup(signupDTO);
        return new SignupResponseDTO(signup);
    }
}
