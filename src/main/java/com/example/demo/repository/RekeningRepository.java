package com.example.demo.repository;

import com.example.demo.model.Rekening;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class RekeningRepository implements RepositoryInterface<Rekening> {

    private List<Rekening> rekeningen;

    public RekeningRepository() {
        this.rekeningen = new ArrayList<Rekening>();
    }

    @Override
    public List<Rekening> findAll() {
        return this.rekeningen;
    }

    @Override
    public Optional<Rekening> findOne(Long id) {
        return this.rekeningen
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }


    public Rekening save(Rekening rekening) {
        if (this.rekeningen.contains(rekening)) {
            this.rekeningen.set(this.rekeningen.indexOf(rekening), rekening);
        } else {
            rekening.setId(getNewId());
            this.rekeningen.add(rekening);
        }
        return rekening;
    }

    public void delete(Rekening rekening) {
        if (this.rekeningen.contains(rekening)) {
            this.rekeningen.remove(rekening);
        }
    }

    private Long getNewId() {
        Comparator<Rekening> comparator = Comparator.comparing(Rekening::getId);
        return this.rekeningen.stream().max(comparator).get().getId() + 1;
    }
}
