package com.example.demo.repository;

import java.util.*;

import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepository {

    List<Rekening> rekeningen;
    List<Rekeninghouder> rekeningHouders;

    public BankRepository() {
        this.rekeningen = new ArrayList<Rekening>();
        this.rekeningHouders = new ArrayList<Rekeninghouder>();
        createTestData();
    }


    public List<Rekening> allRekeningen() {
        return rekeningen;
    }

    public Optional<Rekening> findRekeningById(Long id) {
        return this.rekeningen
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public Rekening saveRekening(Rekening rekening) {
        if (this.rekeningen.contains(rekening)) {
            this.rekeningen.set(this.rekeningen.indexOf(rekening), rekening);
        } else {
            Comparator<Rekening> comparator = Comparator.comparing(Rekening::getId);
            rekening.setId(this.rekeningen.stream().max(comparator).get().getId() + 1);
            this.rekeningen.add(rekening);
        }
        return rekening;
    }

    public boolean deleteRekening(Rekening rekening) {
        if (this.rekeningen.contains(rekening)) {
            // remove rekening from the rekeninghouders
            for (Rekeninghouder rekHouder : rekening.getRekeninghouders()) {
                rekHouder.getRekeningen().remove(rekening);
            }
            // remove actual rekening
            this.rekeningen.remove(rekening);
            return true;
        }
        return false;
    }


    public List<Rekeninghouder> allRekeninghouders() {
        return rekeningHouders;
    }

    public Optional<Rekeninghouder> findRekeninghouderById(Long id) {
        return this.rekeningHouders
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public List<Rekening> findRekeningenVanHouderById(Long id) {
        return this.rekeningHouders
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .get()
                .getRekeningen();
    }

    public Rekeninghouder saveRekeninghouder(Rekeninghouder rekeningHouder) {
        if (this.rekeningHouders.contains(rekeningHouder)) {
            this.rekeningHouders.set(this.rekeningen.indexOf(rekeningHouder), rekeningHouder);
        } else {
            Comparator<Rekeninghouder> comparator = Comparator.comparing(Rekeninghouder::getId);
            rekeningHouder.setId(this.rekeningHouders.stream().max(comparator).get().getId() + 1);
            this.rekeningHouders.add(rekeningHouder);
        }
        return rekeningHouder;
    }

    public boolean deleteRekeninghouder(Rekeninghouder rekeningHouder) {
        if (this.rekeningHouders.contains(rekeningHouder)) {
            // remove rekeninghouder from the rekeningen
            for (Rekening rekening : rekeningHouder.getRekeningen()) {
                rekening.getRekeninghouders().remove(rekeningHouder);
            }
            // remove rekeninghouder from the list
            this.rekeningHouders.remove(rekeningHouder);
            return true;
        }
        return false;
    }


    @Profile("dev")
    private void createTestData() {
        Rekeninghouder rekeningHouder1 = new Rekeninghouder();
        rekeningHouder1.setId((long) 1);
        rekeningHouder1.setFirstName("Tinus");
        rekeningHouder1.setLastName("Meijer");
        rekeningHouders.add(rekeningHouder1);

        Rekeninghouder rekeningHouder2 = new Rekeninghouder();
        rekeningHouder2.setId((long) 2);
        rekeningHouder2.setFirstName("Truus");
        rekeningHouder2.setLastName("Meijer");
        rekeningHouders.add(rekeningHouder2);

        Rekening rekening1 = new Rekening();
        rekening1.setId((long) 1);
        rekening1.setIBAN("NL27BKMG0159109167");
        rekening1.setSaldo(496.38);
        rekening1.setGeblokkeerd(false);
        rekening1.addRekeninghouder(rekeningHouder1);
        rekening1.addRekeninghouder(rekeningHouder2);
        rekeningHouder1.addRekening(rekening1);
        rekeningHouder2.addRekening(rekening1);
        rekeningen.add(rekening1);

        Rekening rekening2 = new Rekening();
        rekening2.setId((long) 2);
        rekening2.setIBAN("NL96INGB0316203645");
        rekening2.setSaldo(789.05);
        rekening2.setGeblokkeerd(false);
        rekening2.addRekeninghouder(rekeningHouder1);
        rekeningHouder1.addRekening(rekening2);
        rekeningen.add(rekening2);
    }

}
