package com.filsoft.filsoftcreditsolutionproject.controller;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreditResponseDTO {
    private UUID id;
    private String nume;
    private Integer perioada;
    private Integer fiscalCode;
    private List<RataResponseDTO> rataList;
    private Integer dobandaTotala;
    private Integer principalTotal;
    private Double rataLunaraCosntanta;

    public CreditResponseDTO() {
    }

    public CreditResponseDTO(UUID id, String nume, Integer perioada, Integer fiscalCode, List<RataResponseDTO> rataList, Integer dobandaTotala, Integer principalTotal, Double rataLunaraCosntanta) {
        this.id = id;
        this.nume = nume;
        this.perioada = perioada;
        this.fiscalCode = fiscalCode;
        this.rataList = rataList;
        this.dobandaTotala = dobandaTotala;
        this.principalTotal = principalTotal;
        this.rataLunaraCosntanta = rataLunaraCosntanta;
    }

    public Integer getPrincipalTotal() {
        return principalTotal;
    }

    public void setPrincipalTotal(Integer principalTotal) {
        this.principalTotal = principalTotal;
    }

    public Integer getDobandaTotala() {
        return dobandaTotala;
    }

    public void setDobandaTotala(Integer dobandaTotala) {
        this.dobandaTotala = dobandaTotala;
    }

    public Double getRataLunaraCosntanta() {
        return rataLunaraCosntanta;
    }

    public void setRataLunaraCosntanta(Double rataLunaraCosntanta) {
        this.rataLunaraCosntanta = rataLunaraCosntanta;
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

    public static CreditResponseDTO fromCredit(Credit credit) {

        List<Rata> rataList = credit.getRataList();

        List<RataResponseDTO> rataResponseDTOList = new ArrayList<>();

        int dobandaTotala = 0;
        double rataLunaraConstanta = 0;
        int principalTotal = 0;

        for(int i=0; i< rataList.size(); i++){
            RataResponseDTO newRata = RataResponseDTO.fromRata(rataList.get(i));
            rataResponseDTOList.add(newRata);

            dobandaTotala = dobandaTotala + rataList.get(i).getDobanda();
            principalTotal = principalTotal + rataList.get(i).getPrincipal();

            rataLunaraConstanta = rataList.get(i).getPrincipal() + rataList.get(i).getDobanda();
        }

        return new CreditResponseDTO(
                credit.getId(),
                credit.getNume(),
                credit.getPerioada(),
                credit.getFiscalCode(),
                rataResponseDTOList,
                dobandaTotala,
                principalTotal,
                rataLunaraConstanta
                );

    }
}
