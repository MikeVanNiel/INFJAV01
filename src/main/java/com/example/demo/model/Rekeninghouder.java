package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Rekeninghouder {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private List<Rekening> rekeningen;

    public Rekeninghouder() {
        this.rekeningen = new ArrayList<Rekening>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public List<Rekening> getRekeningen() {
        return rekeningen;
    }

    public void addRekening(Rekening rekening) {
        rekeningen.add(rekening);
    }
}
