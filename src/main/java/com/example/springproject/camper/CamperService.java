package com.example.springproject.camper;

import com.example.springproject.activity.Activity;
import com.example.springproject.activity.ActivityDTO;
import com.example.springproject.activity.ActivityRepository;
import com.example.springproject.camper.dto.CamperActivityDTO;
import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.camper.dto.CamperMapper;
import com.example.springproject.camper.dto.CamperResponseDTO;
import com.example.springproject.signup.Signup;
import com.example.springproject.signup.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Validated
public class CamperService {

    private final CamperRepository camperRepository;
    private final CamperMapper camperMapper;
    private final ActivityRepository activityRepository;
    private final SignupRepository signupRepository;

    @Autowired
    public CamperService(CamperRepository camperRepository, CamperMapper camperMapper,
                         ActivityRepository activityRepository, SignupRepository signupRepository) {
        this.camperRepository = camperRepository;
        this.camperMapper = camperMapper;
        this.activityRepository = activityRepository;
        this.signupRepository = signupRepository;
    }

    @Async
    public CompletableFuture<CamperResponseDTO> createCamper(CamperDTO camperDTO) {
        try {
        Camper camper = camperMapper.mapToEntity(camperDTO);
        camperRepository.save(camper);
        CamperResponseDTO camperResponseDTO = camperMapper.mapToResponseDTO(camper);
        return CompletableFuture.completedFuture(camperResponseDTO);
        } catch (Exception e)  {
            throw new RuntimeException("Error creating new camper.", e);
        }
    }

    @Async
    public CompletableFuture<List<CamperResponseDTO>> getAllCampers() {
        try {
            List<Camper> campers = camperRepository.findAll();

            List<CamperResponseDTO> camperResponseDTOList = camperMapper.mapToResponseDTOList(campers);

            return CompletableFuture.completedFuture(camperResponseDTOList);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all campers.", e);
        }
    }

    public CamperActivityDTO getCamperById(int id) {
        List<Signup> signups = signupRepository.findByCamperId(id);

        List<Activity> activities = signups.stream().map(Signup::getActivity).toList();

        Camper camper = camperRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        CamperActivityDTO camperActivityDTO = new CamperActivityDTO();
        camperActivityDTO.setId(id);
        camperActivityDTO.setName(camper.getName());
        camperActivityDTO.setAge(camper.getAge());
        camperActivityDTO.setActivityList(activities.stream().map(ActivityDTO::new).collect(Collectors.toList()));

        return  camperActivityDTO;
    }
}
