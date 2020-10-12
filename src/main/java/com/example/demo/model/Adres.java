package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {
    private String straat;
    private int huisnummer;
    private String huisnummerToevoeging;
    private String postcode;
    private String plaats;

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }


    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }


    public String getHuisnummerToevoeging() {
        return huisnummerToevoeging;
    }

    public void setHuisnummerToevoeging(String huisnummerToevoeging) {
        this.huisnummerToevoeging = huisnummerToevoeging;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }
}
