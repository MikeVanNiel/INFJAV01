package com.example.demo.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private Long id;
    @NotNull
    @Size(message = "Ongeldig IBAN-nummer", min = 18, max = 18)
    private String IBAN;
    private Double saldo;
    private Boolean isGeblokkeerd;
    private List<Rekeninghouder> Rekeninghouders;

    public Rekening() {
        this.Rekeninghouders = new ArrayList<Rekeninghouder>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
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
        return Rekeninghouders;
    }

    public void addRekeninghouder(Rekeninghouder rekeninghouder) {
        Rekeninghouders.add(rekeninghouder);
    }
}
