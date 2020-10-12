package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rekening extends BaseEntity {


    @Column(length=20, nullable=false)
    @NotNull
    @Size(message = "Ongeldig IBAN-nummer", min = 18, max = 18)
    private String iban;

    @Column
    private Double saldo;

    @Column
    private Boolean isGeblokkeerd;

    @ManyToMany
    @JoinTable(
            name = "RekeningRekeninghouder",
            joinColumns = @JoinColumn(name = "rekeningId"),
            inverseJoinColumns = @JoinColumn(name = "rekeninghouderId"))
    @ElementCollection(targetClass=Long.class)
    private List<Rekeninghouder> rekeninghouders;


    public Rekening() {
        this.rekeninghouders = new ArrayList<Rekeninghouder>();
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
