package com.example.springproject.camper.dto;

import com.example.springproject.camper.Camper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CamperMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CamperMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Camper mapToEntity(CamperDTO camperDTO) {
        return modelMapper.map(camperDTO, Camper.class);
    }

    public CamperResponseDTO mapToResponseDTO(Camper camper) {
        return modelMapper.map(camper, CamperResponseDTO.class);
    }

    public List<CamperResponseDTO> mapToResponseDTOList(List<Camper> campers) {
        return campers.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }
}
