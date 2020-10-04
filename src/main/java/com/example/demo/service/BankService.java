package com.example.demo.service;


import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepo;

    @Autowired
    public BankService(BankRepository repository) {
        this.bankRepo = repository;
    }

    public List<Rekening> allRekeningen() {
        return bankRepo.allRekeningen();
    }

    public Rekening addRekening(Rekening rekening) {
        return bankRepo.saveRekening(rekening);
    }

    public Rekening blockRekeningById(Long id) {
        Optional<Rekening> rekening = bankRepo.findRekeningById(id);

        if (rekening.isPresent()) {
            Rekening rek = rekening.get();
            rek.setGeblokkeerd(true);
            bankRepo.saveRekening(rek);
            return rek;
        }
        return null;
    }

    public Optional<Rekening> deleteRekeningById(Long id) {
        Optional<Rekening> rekening = bankRepo.findRekeningById(id);

        if (rekening.isPresent()) {
            bankRepo.deleteRekening(rekening.get());
        }

        return rekening;
    }


    public List<Rekening> allRekeningenVanHouder(Long id) {
        return bankRepo.findRekeningenVanHouderById(id);
    }

    public Rekeninghouder addRekeninghouder(Rekeninghouder rekeningHouder) {
        return bankRepo.saveRekeninghouder(rekeningHouder);
    }

    public boolean deleteRekeninghouderById(Long id) {
        Optional<Rekeninghouder> rekeningHouder = bankRepo.findRekeninghouderById(id);

        if (rekeningHouder.isPresent()) {
            bankRepo.deleteRekeninghouder(rekeningHouder.get());
            return true;
        }
        return false;
    }
}
