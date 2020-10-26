package com.hr.eenvijfdrielagen.service;

import com.hr.eenvijfdrielagen.model.Rekening;
import com.hr.eenvijfdrielagen.repository.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RekeningService {

    RekeningRepository rekeningRepo;

    @Autowired
    public RekeningService(RekeningRepository rekeningRepo) {
        this.rekeningRepo = rekeningRepo;
    }

    @Cacheable("rekeningen")
    public List<Rekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Cacheable("rekening")
    public Rekening getRekening(Long id) {
        return rekeningRepo.getOne(id);
    }

    @CachePut(value = "rekeningen", key = "rekening.id")
    public Rekening createRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CachePut(value = "rekeningen", key = "rekening.id")
    public Rekening updateRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CacheEvict(value = "rekeningen", key = "rekening.id")
    public void deleteRekening(Long id) {
        Rekening rekening = this.getRekening(id);
        rekeningRepo.delete(rekening);
    }
}
