package com.filsoft.filsoftcreditsolutionproject.model;

public class PlataAnticipata {
    private Integer sumaPrincipal;

    public PlataAnticipata(){
        this.sumaPrincipal=0;
    }

    public PlataAnticipata(Integer sumaPrincipal){
        this.sumaPrincipal=sumaPrincipal;

    }
     public Integer getSumaPrincipal(){
        return sumaPrincipal;
     }

     public void setSumaPrincipal(Integer sumaPrincipal){
        this.sumaPrincipal=sumaPrincipal;
     }

}
