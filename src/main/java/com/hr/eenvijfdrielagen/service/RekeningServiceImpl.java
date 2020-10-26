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
public class RekeningServiceImpl implements RekeningService {

    RekeningRepository rekeningRepo;

    @Autowired
    public RekeningServiceImpl(RekeningRepository rekeningRepo) {
        this.rekeningRepo = rekeningRepo;
    }

    @Override
    @Cacheable("rekeningen")
    public List<Rekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Override
    @Cacheable("rekening")
    public Rekening getRekening(Long id) {
        return rekeningRepo.getOne(id);
    }

    @Override
    @CachePut(value = "rekeningen", key = "rekening.id")
    public Rekening createRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @Override
    @CachePut(value = "rekeningen", key = "rekening.id")
    public Rekening updateRekening(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    @Override
    @CacheEvict(value = "rekeningen", key = "rekening.id")
    public void deleteRekening(Long id) {
        Rekening rekening = this.getRekening(id);
        rekeningRepo.delete(rekening);
    }
}
