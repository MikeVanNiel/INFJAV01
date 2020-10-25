package com.hr.eenvijfdrielagen.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RekeningDto {
    private Long id;

    private String iban;

    private Double saldo;

    private Boolean geblokkeerd;
}
