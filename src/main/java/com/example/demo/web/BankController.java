package com.example.demo.web;

import com.example.demo.exceptions.RekeningNotFoundException;
import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import com.example.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.Produces;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/rekeningen")
    public ResponseEntity<Iterable<Rekening>> getRekeningen() {
        return new ResponseEntity<Iterable<Rekening>>(this.bankService.allRekeningen(), HttpStatus.OK);
    }

    @PostMapping("/rekeningen")
    public ResponseEntity<Rekening> addRekening(@Valid @ModelAttribute Rekening rekening) {
        return new ResponseEntity<Rekening>(this.bankService.addRekening(rekening), HttpStatus.OK);
    }

    @PutMapping("/rekeningen/{id}")
    public ResponseEntity<Rekening> blockRekening(@PathVariable Long id) {
        return new ResponseEntity<Rekening>(this.bankService.blockRekeningById(id), HttpStatus.OK);
    }

    @DeleteMapping("/rekeningen/{id}")
    public ResponseEntity<Rekening> deleteRekening(@PathVariable Long id) {
        Optional<Rekening> optionalRekening = this.bankService.deleteRekeningById(id);
        Rekening rekening = optionalRekening.orElseThrow(RekeningNotFoundException::new);
        return ResponseEntity.ok(rekening);
    }


    @GetMapping("/rekeningenvanhouder/{id}")
    public ResponseEntity<List<Rekening>> getRekeningenVanHouder(@PathVariable Long id) {
        return new ResponseEntity<List<Rekening>>(this.bankService.allRekeningenVanHouder(id), HttpStatus.OK);
    }

    @PostMapping("/rekeninghouders")
    public ResponseEntity<Rekeninghouder> addRekeninghouder(@ModelAttribute Rekeninghouder newRekeninghouder) {
        return new ResponseEntity<Rekeninghouder>(this.bankService.addRekeninghouder(newRekeninghouder), HttpStatus.OK);
    }

    @DeleteMapping("/rekeninghouders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRekeninghouder(@PathVariable Long id) {
        this.bankService.deleteRekeninghouderById(id);
    }

}
