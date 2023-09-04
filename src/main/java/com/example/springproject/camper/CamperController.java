package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperActivityDTO;
import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.camper.dto.CamperResponseDTO;
import com.example.springproject.utils.ValidationUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/camper")
public class CamperController {

    @Autowired
    private CamperService camperService;

    @PostMapping
    public CompletableFuture<CamperResponseDTO> createCamper(@Valid @RequestBody CamperDTO camperDTO, BindingResult bindingResult) {
        ValidationUtility.validateDTO(bindingResult);
        return camperService.createCamper(camperDTO);
    }

    @GetMapping
    public CompletableFuture<List<CamperResponseDTO>> getAllCampers() {
        return camperService.getAllCampers();
    }

    @GetMapping("/{id}")
    public CamperActivityDTO getCamperActivity(@PathVariable int id) {

        return camperService.getCamperById(id);
    }
}
