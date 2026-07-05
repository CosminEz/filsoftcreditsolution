package com.filsoft.filsoftcreditsolutionproject.controller;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;

import java.util.List;
import java.util.UUID;

public class CreditResponseDTO {
    private UUID id;
    private String nume;
    private Integer perioada;
    private Integer fiscalCode;
    private List<RataResponseDTO> rataList;

    public CreditResponseDTO() {
    }

    public CreditResponseDTO(UUID id, String nume, Integer perioada, Integer fiscalCode, List<RataResponseDTO> rataList) {
        this.id = id;
        this.nume = nume;
        this.perioada = perioada;
        this.fiscalCode = fiscalCode;
        this.rataList = rataList;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<RataResponseDTO> getRataList() {
        return rataList;
    }

    public void setRataList(List<RataResponseDTO> rataList) {
        this.rataList = rataList;
    }

    public CreditResponseDTO fromCredit(Credit credit) {
        return new CreditResponseDTO(
                credit.getId(),
                credit.getNume(),
                credit.getPerioada(),
                credit.getFiscalCode(),
                credit.getRataList().forEach(rata -> new RataResponseDTO(rata)));

    }
}
