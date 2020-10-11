package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "rekeninghouder_id"))
public class Rekeninghouder extends BaseEntity {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @JsonIgnore
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


    public List<Rekening> getRekeningen() {
        return rekeningen;
    }

    public void addRekening(Rekening rekening) {
        rekeningen.add(rekening);
    }
}
