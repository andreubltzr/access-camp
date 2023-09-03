package com.example.springproject.camper;

import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.utils.ValidationUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/camper")
public class CamperController {

    @Autowired
    private CamperService camperService;

    @PostMapping
    public CompletableFuture<Camper> createCamper(@Valid @RequestBody CamperDTO camperDTO, BindingResult bindingResult) {
        ValidationUtility.validateDTO(bindingResult);
        return camperService.createCamper(camperDTO);
    }
}
