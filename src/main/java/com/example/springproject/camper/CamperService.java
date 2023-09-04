package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.camper.dto.CamperMapper;
import com.example.springproject.camper.dto.CamperResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class CamperService {

    private final CamperRepository camperRepository;
    private final CamperMapper camperMapper;

    @Autowired
    public CamperService(CamperRepository camperRepository, CamperMapper camperMapper) {
        this.camperRepository = camperRepository;
        this.camperMapper = camperMapper;
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
}
