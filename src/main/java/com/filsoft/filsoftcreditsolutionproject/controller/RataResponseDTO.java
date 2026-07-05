package com.filsoft.filsoftcreditsolutionproject.controller;

import com.filsoft.filsoftcreditsolutionproject.model.Rata;

import java.util.UUID;

public class RataResponseDTO {
    private Integer id;
    private Integer principal;
    private Integer dobanda;
    private Boolean status;

    public RataResponseDTO() {
    }

    public RataResponseDTO(Integer id, Integer principal, Integer dobanda, Boolean status) {
        this.id = id;
        this.principal = principal;
        this.dobanda = dobanda;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        return new RataResponseDTO(rata.getId(), rata.getPrincipal(), rata.getDobanda(), rata.getStatus());
    }
}