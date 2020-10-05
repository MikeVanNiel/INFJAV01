package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private Long id;
    @NotNull
    @Size(message = "Ongeldig IBAN-nummer", min = 18, max = 18)
    private String iban;
    private Double saldo;
    private Boolean isGeblokkeerd;
    private List<Rekeninghouder> rekeninghouders;

    public Rekening() {
        this.rekeninghouders = new ArrayList<Rekeninghouder>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIBAN() {
        return iban;
    }

    public void setIBAN(String iban) {
        this.iban = iban;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getGeblokkeerd() {
        return isGeblokkeerd;
    }

    public void setGeblokkeerd(Boolean geblokkeerd) {
        isGeblokkeerd = geblokkeerd;
    }

    public List<Rekeninghouder> getRekeninghouders() {
        return rekeninghouders;
    }

    public void addRekeninghouder(Rekeninghouder rekeninghouder) {
        rekeninghouders.add(rekeninghouder);
    }
}
