package com.hr.eenvijfdrielagen.web;

import com.hr.eenvijfdrielagen.dto.RekeningDto;
import com.hr.eenvijfdrielagen.model.Rekening;
import com.hr.eenvijfdrielagen.service.RekeningService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class RekeningController {

    RekeningService rekeningService;
    ModelMapper modelMapper;

    @Autowired
    public RekeningController(RekeningService rekeningService, ModelMapper modelMapper) {
        this.rekeningService = rekeningService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/rekeningen")
    public ResponseEntity<List<RekeningDto>> get() {
        List<RekeningDto> rekeningDtos = rekeningService
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<List<RekeningDto>>(rekeningDtos, HttpStatus.OK);
    }

    @PostMapping("/rekeningen")
    public ResponseEntity<RekeningDto> addRekening(@RequestBody RekeningDto rekeningDto) throws ParseException {
        Rekening rekening = this.rekeningService.createRekening(convertToEntity(rekeningDto));
        return new ResponseEntity<RekeningDto>(convertToDto(rekening), HttpStatus.OK);
    }

    @PutMapping("/rekeningen/{id}")
    public ResponseEntity<RekeningDto> updateRekening(@RequestBody RekeningDto rekeningDto) throws ParseException {
        Rekening rekening = this.rekeningService.updateRekening(convertToEntity(rekeningDto));
        return new ResponseEntity<RekeningDto>(convertToDto(rekening), HttpStatus.OK);
    }

    @DeleteMapping("/rekeningen/{id}")
    public void deleteRekening(@PathVariable Long id) {
        rekeningService.deleteRekening(id);
    }


    private RekeningDto convertToDto(Rekening rekening) {
        return modelMapper.map(rekening, RekeningDto.class);
    }

    private Rekening convertToEntity(RekeningDto rekeningDto) throws ParseException {
        return modelMapper.map(rekeningDto, Rekening.class);
    }
}
