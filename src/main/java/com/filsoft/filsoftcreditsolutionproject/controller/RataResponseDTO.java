package com.filsoft.filsoftcreditsolutionproject.controller;

import com.filsoft.filsoftcreditsolutionproject.model.Rata;

import java.util.UUID;

public class RataResponseDTO {
    private UUID id;
    private Integer principal;
    private Integer dobanda;

    public RataResponseDTO() {
    }

    public RataResponseDTO(UUID id, Integer principal, Integer dobanda) {
        this.id = id;
        this.principal = principal;
        this.dobanda = dobanda;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Integer getDobanda() {
        return dobanda;
    }

    public void setDobanda(Integer dobanda) {
        this.dobanda = dobanda;
    }

    public static RataResponseDTO  fromRata(Rata rata) {
        return new RataResponseDTO(rata.getId(), rata.getPrincipal(), rata.getDobanda());
    }
}