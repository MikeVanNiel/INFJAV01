package com.week6.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class GebruikerDto {
    private Long id;

    @NotNull
    @Size(min = 2)
    private String naam;

    private String adres;
}
