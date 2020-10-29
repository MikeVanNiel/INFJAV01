package com.week6.security.controller;

import com.week6.security.dto.GebruikerDto;
import com.week6.security.model.Gebruiker;
import com.week6.security.service.GebruikerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class GebruikerController {

    GebruikerService gebruikerService;
    ModelMapper modelMapper;

    @Autowired
    public GebruikerController(GebruikerService gebruikerService, ModelMapper modelMapper) {
        this.gebruikerService = gebruikerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/gebruikers")
    public ResponseEntity<List<GebruikerDto>> get() {
        List<GebruikerDto> gebruikerDtos = gebruikerService
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<List<GebruikerDto>>(gebruikerDtos, HttpStatus.OK);
    }


    private GebruikerDto convertToDto(Gebruiker gebruiker) {
        return modelMapper.map(gebruiker, GebruikerDto.class);
    }

    private Gebruiker convertToEntity(GebruikerDto gebruikerDto) throws ParseException {
        return modelMapper.map(gebruikerDto, Gebruiker.class);
    }
}
