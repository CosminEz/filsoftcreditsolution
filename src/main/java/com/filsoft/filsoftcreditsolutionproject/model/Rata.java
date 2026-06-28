package com.filsoft.filsoftcreditsolutionproject.model;

public class Rata {
    private Integer principal;
    private Integer dobanda;

    public Rata(Integer principal, Integer dobanda) {
        this.principal = principal;
        this.dobanda = dobanda;
    }

    public Rata() {
        this.principal=0;
        this.dobanda=0;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public Integer getDobanda() {
        return dobanda;
    }

    public String toString(){
        return "Principal: " + this.getPrincipal() + " si dobanda: "+ this.getDobanda();
    }
}

