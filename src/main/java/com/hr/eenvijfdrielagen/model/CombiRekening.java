package com.hr.eenvijfdrielagen.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class CombiRekening extends BaseRekening {

    @OneToMany(targetEntity=Rekening.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Rekening> rekeningen;

}
