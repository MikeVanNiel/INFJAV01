package com.example.demo.repository;

import com.example.demo.model.Rekeninghouder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class RekeninghouderRepository implements RepositoryInterface<Rekeninghouder> {

    private List<Rekeninghouder> rekeningHouders;

    public RekeninghouderRepository() {
        this.rekeningHouders = new ArrayList<Rekeninghouder>();
    }

    @Override
    public List<Rekeninghouder> findAll() {
        return this.rekeningHouders;
    }

    @Override
    public Optional<Rekeninghouder> findOne(Long id) {
        return this.rekeningHouders
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public Rekeninghouder save(Rekeninghouder rekeningHouder) {
        if (this.rekeningHouders.contains(rekeningHouder)) {
            this.rekeningHouders.set(this.rekeningHouders.indexOf(rekeningHouder), rekeningHouder);
        } else {
            rekeningHouder.setId(getNewId());
            this.rekeningHouders.add(rekeningHouder);
        }
        return rekeningHouder;
    }

    public void delete(Rekeninghouder rekeningHouder) {
        if (this.rekeningHouders.contains(rekeningHouder)) {
            this.rekeningHouders.remove(rekeningHouder);
        }
    }

    private Long getNewId() {
        Comparator<Rekeninghouder> comparator = Comparator.comparing(Rekeninghouder::getId);
        return this.rekeningHouders.stream().max(comparator).get().getId() + 1;
    }
}
