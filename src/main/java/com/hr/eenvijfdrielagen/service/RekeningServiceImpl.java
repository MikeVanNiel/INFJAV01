package com.hr.eenvijfdrielagen.service;

import com.hr.eenvijfdrielagen.model.Rekening;
import com.hr.eenvijfdrielagen.repository.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RekeningServiceImpl implements RekeningService {

    RekeningRepository rekeningRepo;

    @Autowired
    public RekeningServiceImpl(RekeningRepository rekeningRepo) {
        this.rekeningRepo = rekeningRepo;
    }

    @Override
    public List<Rekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Override
    public Rekening getRekening(Long id) {
        return rekeningRepo.getOne(id);
    }

    @Override
    public Rekening createRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @Override
    public Rekening updateRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @Override
    public void deleteRekening(Long id) {
        Rekening rekening = this.getRekening(id);
        rekeningRepo.delete(rekening);
    }
}
