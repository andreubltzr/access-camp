package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.camper.dto.CamperResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Validated
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Async
    public CompletableFuture<CamperResponseDTO> createCamper(CamperDTO camperDTO) {
        try {
        Camper camper = new Camper(camperDTO);
        camperRepository.save(camper);
        CamperResponseDTO camperResponseDTO = new CamperResponseDTO(camper);
        return CompletableFuture.completedFuture(camperResponseDTO);
        } catch (Exception e)  {
            throw new RuntimeException("Error creating new camper.", e);
        }
    }

    @Async
    public CompletableFuture<List<CamperResponseDTO>> getAllCampers() {
        try {
            List<Camper> campers = camperRepository.findAll();

            ModelMapper modelMapper = new ModelMapper();

            List<CamperResponseDTO> camperResponseDTOList = campers.stream().map(camper -> modelMapper.map(camper,
                    CamperResponseDTO.class)).collect(Collectors.toList());

            return CompletableFuture.completedFuture(camperResponseDTOList);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all campers.", e);
        }
    }
}
