package com.filsoft.filsoftcreditsolutionproject.model;

public class Credit {
    private Rata rata;
    private Integer perioada;

    public Credit(){
        this.perioada=0;
        this.rata=new Rata();
    }

    public Credit(Rata rata,Integer perioada){
        this.rata=rata;
        this.perioada=perioada;
    }

    public Credit(Credit credit){
        this.rata=credit.getRata();
        this.perioada=credit.getPerioada();
    }
    public Integer getPerioada(){
        return perioada;
    }

    public Rata getRata(){
        return rata;
    }

    public void setPerioada(Integer perioada){
        this.perioada=perioada;
    }

    public void setRata(Rata rata){
        this.rata=rata;
    }
}
