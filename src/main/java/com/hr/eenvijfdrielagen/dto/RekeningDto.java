package com.hr.eenvijfdrielagen.dto;

import com.sun.istack.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RekeningDto {
    private Long id;

    @NotNull
    @Size(min = 18, max = 18)
    private String iban;

    private Double saldo;

    private Boolean geblokkeerd;
}
