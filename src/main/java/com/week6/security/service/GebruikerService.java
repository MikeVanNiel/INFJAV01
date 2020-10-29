package com.week6.security.service;

import com.week6.security.model.Gebruiker;
import com.week6.security.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GebruikerService {

    GebruikerRepository gebruikerRepo;

    @Autowired
    public GebruikerService(GebruikerRepository gebruikerRepo) {
        this.gebruikerRepo = gebruikerRepo;
    }

    public List<Gebruiker> findAll() {
        return gebruikerRepo.findAll();
    }

    public Gebruiker getRekening(Long id) {
        return gebruikerRepo.getOne(id);
    }

    public Gebruiker createRekening(Gebruiker gebruiker) {
        return gebruikerRepo.save(gebruiker);
    }

    public Gebruiker updateRekening(Gebruiker gebruiker) {
        return gebruikerRepo.save(gebruiker);
    }

    public void deleteRekening(Long id) {
        Gebruiker rekening = this.getRekening(id);
        gebruikerRepo.delete(rekening);
    }
}
