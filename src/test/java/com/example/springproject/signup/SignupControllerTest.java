package com.example.springproject.signup;

import com.example.springproject.signup.dto.SignupDTO;
import com.example.springproject.signup.dto.SignupResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SignupControllerTest {

    @InjectMocks
    private SignupController signupController;

    @Mock
    private SignupService signupService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("createSignup should return a new signup")
    public void createSignup() {
        SignupDTO mockSignupDTO = new SignupDTO();
        mockSignupDTO.setTime(9);
        mockSignupDTO.setCamperId(2);
        mockSignupDTO.setActivityId(5);

        SignupResponseDTO mockResponseDTO = new SignupResponseDTO(1, 2, 3, 10);

        when(signupService.createSignup(mockSignupDTO)).thenReturn(mockResponseDTO);

        SignupResponseDTO res = signupController.createSignup(mockSignupDTO);

        assertNotNull(res);
    }
}
