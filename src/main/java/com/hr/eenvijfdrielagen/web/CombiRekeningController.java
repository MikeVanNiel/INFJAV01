package com.hr.eenvijfdrielagen.web;

import com.hr.eenvijfdrielagen.aop.LogExecutionTime;
import com.hr.eenvijfdrielagen.dto.CombiRekeningDto;
import com.hr.eenvijfdrielagen.dto.RekeningDto;
import com.hr.eenvijfdrielagen.model.CombiRekening;
import com.hr.eenvijfdrielagen.model.Rekening;
import com.hr.eenvijfdrielagen.service.CombiRekeningService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class CombiRekeningController {

    CombiRekeningService rekeningService;
    ModelMapper modelMapper;

    @Autowired
    public CombiRekeningController(CombiRekeningService rekeningService, ModelMapper modelMapper) {
        this.rekeningService = rekeningService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/combirekeningen")
    @LogExecutionTime
    public ResponseEntity<List<CombiRekeningDto>> get() {
        List<CombiRekeningDto> rekeningDtos = rekeningService
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<List<CombiRekeningDto>>(rekeningDtos, HttpStatus.OK);
    }

    @PostMapping("/combirekeningen")
    @LogExecutionTime
    public ResponseEntity<CombiRekeningDto> addRekening(@Valid @RequestBody CombiRekeningDto rekeningDto) throws ParseException {
        CombiRekening rekening = this.rekeningService.createRekening(convertToEntity(rekeningDto));
        return new ResponseEntity<CombiRekeningDto>(convertToDto(rekening), HttpStatus.OK);
    }

    @PutMapping("/combirekeningen/{id}")
    @LogExecutionTime
    public ResponseEntity<CombiRekeningDto> updateRekening(@Valid @RequestBody CombiRekeningDto rekeningDto) throws ParseException {
        CombiRekening rekening = this.rekeningService.updateRekening(convertToEntity(rekeningDto));
        return new ResponseEntity<CombiRekeningDto>(convertToDto(rekening), HttpStatus.OK);
    }

    @DeleteMapping("/combirekeningen/{id}")
    @LogExecutionTime
    public void deleteRekening(@PathVariable Long id) {
        rekeningService.deleteRekening(id);
    }


    private CombiRekeningDto convertToDto(CombiRekening rekening) {
        return modelMapper.map(rekening, CombiRekeningDto.class);
    }

    private CombiRekening convertToEntity(CombiRekeningDto rekeningDto) throws ParseException {
        return modelMapper.map(rekeningDto, CombiRekening.class);
    }
}
