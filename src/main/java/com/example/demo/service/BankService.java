package com.example.demo.service;


import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import com.example.demo.repository.RekeningRepository;
import com.example.demo.repository.RekeninghouderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final RekeningRepository rekeningRepo;
    private final RekeninghouderRepository rekeninghouderRepo;


    @Autowired
    public BankService(RekeningRepository rekeningRepo, RekeninghouderRepository rekeninghouderRepo) {
        this.rekeningRepo = rekeningRepo;
        this.rekeninghouderRepo = rekeninghouderRepo;
    }


    public List<Rekening> allRekeningen() {
        return rekeningRepo.findAll();
    }

    public Rekening addRekening(Rekening rekening) {
        for (Rekeninghouder rekeningHouder : rekening.getRekeninghouders()) {
            rekeninghouderRepo.save(rekeningHouder);
        }
        return rekeningRepo.save(rekening);
    }

    public Rekening blockRekeningById(Long id) {
        Optional<Rekening> rekening = rekeningRepo.findOne(id);

        if (rekening.isPresent()) {
            Rekening rek = rekening.get();
            rek.setGeblokkeerd(true);
            return rekeningRepo.save(rek);
        }

        return null;
    }

    public Optional<Rekening> deleteRekeningById(Long id) {
        Optional<Rekening> rekening = rekeningRepo.findOne(id);

        if (rekening.isPresent()) {
            rekeningRepo.delete(rekening.get());
        }

        return rekening;
    }


    public List<Rekening> allRekeningenVanHouder(Long id) {
        return rekeninghouderRepo.findOne(id).get().getRekeningen();
    }

    public Rekeninghouder addRekeninghouder(Rekeninghouder rekeningHouder) {
        for (Rekening rekening : rekeningHouder.getRekeningen()) {
            rekeningRepo.save(rekening);
        }
        return rekeninghouderRepo.save(rekeningHouder);
    }

    public void deleteRekeninghouderById(Long id) {
        Optional<Rekeninghouder> rekeningHouder = rekeninghouderRepo.findOne(id);

        if (rekeningHouder.isPresent()) {
            rekeninghouderRepo.delete(rekeningHouder.get());
        }
    }

}
