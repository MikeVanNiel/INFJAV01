package com.hr.eenvijfdrielagen.service;

import com.hr.eenvijfdrielagen.model.Rekening;
import com.hr.eenvijfdrielagen.model.CombiRekening;
import com.hr.eenvijfdrielagen.repository.CombiRekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombiRekeningService {
    CombiRekeningRepository rekeningRepo;

    @Autowired
    public CombiRekeningService(CombiRekeningRepository rekeningRepo) {
        this.rekeningRepo = rekeningRepo;
    }

    @Cacheable("combiRekeningen")
    public List<CombiRekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Cacheable("combiRekening")
    public CombiRekening getRekening(Long id) {
        return rekeningRepo.getOne(id);
    }

    @CachePut(value = "combiRekeningen", key = "rekening.id")
    public CombiRekening createRekening(CombiRekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CachePut(value = "combiRekeningen", key = "rekening.id")
    public CombiRekening updateRekening(CombiRekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CacheEvict(value = "combiRekeningen", key = "rekening.id")
    public void deleteRekening(Long id) {
        CombiRekening rekening = this.getRekening(id);
        rekeningRepo.delete(rekening);
    }
}
