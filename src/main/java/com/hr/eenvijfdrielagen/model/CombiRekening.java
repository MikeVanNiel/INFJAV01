package com.hr.eenvijfdrielagen.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Setter
@Getter
public class CombiRekening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rekeningNummer;

    private String iban;

    private Double saldo;

    private Boolean geblokkeerd;

    private List<Rekening> rekeningen;
}
