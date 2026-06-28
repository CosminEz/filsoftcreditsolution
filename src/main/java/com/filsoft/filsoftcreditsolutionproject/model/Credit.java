package com.filsoft.filsoftcreditsolutionproject.model;

import java.util.List;

public class Credit {
    private List<Rata> rataList;
    private String nume;
    private Integer perioada;
    private Integer fiscalCode;

    public Credit(List<Rata> rataList, String nume, Integer perioada, Integer fiscalCode) {
        this.rataList = rataList;
        this.nume = nume;
        this.perioada = perioada;
        this.fiscalCode = fiscalCode;
    }

    public Credit() {
    }

    public List<Rata> getRataList() {
        return rataList;
    }

    public String getNume() {
        return nume;
    }

    public Integer getPerioada() {
        return perioada;
    }

    public Integer getFiscalCode() {
        return fiscalCode;
    }

    public void setRataList(List<Rata> rataList) {
        this.rataList = rataList;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPerioada(Integer perioada) {
        this.perioada = perioada;
    }

    public void setFiscalCode(Integer fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
