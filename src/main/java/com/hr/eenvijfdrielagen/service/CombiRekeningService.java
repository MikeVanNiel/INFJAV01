package com.hr.eenvijfdrielagen.service;

import com.hr.eenvijfdrielagen.aop.RequestHeaderDetector;
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
    @RequestHeaderDetector(value = "X-Trace-Database-Time")
    public List<CombiRekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Cacheable("combiRekening")
    @RequestHeaderDetector(value = "X-Trace-Database-Time")
    public CombiRekening getRekening(Long id) {
        return rekeningRepo.getOne(id);
    }

    @CachePut(value = "combiRekeningen", key = "rekening.id")
    @RequestHeaderDetector(value = "X-Trace-Database-Time")
    public CombiRekening createRekening(CombiRekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CachePut(value = "combiRekeningen", key = "rekening.id")
    @RequestHeaderDetector(value = "X-Trace-Database-Time")
    public CombiRekening updateRekening(CombiRekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @CacheEvict(value = "combiRekeningen", key = "rekening.id")
    @RequestHeaderDetector(value = "X-Trace-Database-Time")
    public void deleteRekening(Long id) {
        CombiRekening rekening = this.getRekening(id);
        rekeningRepo.delete(rekening);
    }
}
