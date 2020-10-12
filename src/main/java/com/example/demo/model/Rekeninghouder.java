package com.example.demo.model;

import com.example.demo.enums.Geslacht;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rekeninghouder extends BaseEntity {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    private Geslacht geslacht;

    @Embedded
    private Adres adres;

    @ManyToMany(mappedBy = "rekeninghouders")
    @ElementCollection(targetClass=Long.class)
    private List<Rekening> rekeningen;


    public Rekeninghouder() {
        this.rekeningen = new ArrayList<Rekening>();
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }


    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }


    public List<Rekening> getRekeningen() {
        return rekeningen;
    }

    public void addRekening(Rekening rekening) {
        rekeningen.add(rekening);
    }
}
