package com.filsoft.filsoftcreditsolutionproject.controller;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;

public class CreditDTO {
    private String nume;
    private Integer perioada;
    private Integer fiscalCode;
    private Integer dobanda;
    private Integer suma;

    public CreditDTO() {
    }

    public CreditDTO(String nume, Integer perioada, Integer fiscalCode, Integer dobanda, Integer suma) {
        this.nume = nume;
        this.perioada = perioada;
        this.fiscalCode = fiscalCode;
        this.dobanda = dobanda;
        this.suma = suma;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getPerioada() {
        return perioada;
    }

    public void setPerioada(Integer perioada) {
        this.perioada = perioada;
    }

    public Integer getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(Integer fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Integer getDobanda() {
        return dobanda;
    }

    public void setDobanda(Integer dobanda) {
        this.dobanda = dobanda;
    }

    public Integer getSuma() {
        return suma;
    }

    public void setSuma(Integer suma) {
        this.suma = suma;
    }

    public Credit toCredit(){
        return Credit.builder()
                .nume(this.getNume())
                .perioada(this.getPerioada())
                .fiscalCode(this.getFiscalCode())
                .build();
    }
}
