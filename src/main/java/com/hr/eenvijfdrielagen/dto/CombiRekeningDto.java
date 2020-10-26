package com.hr.eenvijfdrielagen.dto;

import com.hr.eenvijfdrielagen.model.Rekening;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class CombiRekeningDto {
    private Long id;

    @NotNull
    @Size(min = 18, max = 18)
    private String iban;

    private Double saldo;

    private Boolean geblokkeerd;

    private List<Rekening> rekeningen;
}
