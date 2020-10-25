package com.hr.eenvijfdrielagen.service;

import com.hr.eenvijfdrielagen.model.Rekening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RekeningService {

    List<Rekening> findAll();

    Rekening getRekening(Long id);

    Rekening createRekening(Rekening rekening);

    Rekening updateRekening(Rekening rekening);

    void deleteRekening(Long id);

}
