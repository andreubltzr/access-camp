package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Async
    public CompletableFuture<Camper> createCamper(CamperDTO camperDTO) {
        try {
        Camper camper = new Camper(camperDTO);
        camperRepository.save(camper);
        return CompletableFuture.completedFuture(camper);
        } catch (Exception e)  {
            throw new RuntimeException("Error creating new camper.", e);
        }
    }
}
