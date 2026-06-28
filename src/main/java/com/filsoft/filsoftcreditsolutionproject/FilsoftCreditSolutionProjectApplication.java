package com.filsoft.filsoftcreditsolutionproject;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.SourceDataLine;

@SpringBootApplication
public class FilsoftCreditSolutionProjectApplication {

    public static void main(String[] args) {
        System.out.println("Salut");

        Rata rataNou = new Rata(100, 200);
        System.out.println("Principalul pentru rata este: " + rataNou.getPrincipal() + " si dobanda este: " + rataNou.getDobanda());

        Credit creditNou = new Credit();

        System.out.println("Pentru acest credit, rata este: " + creditNou.getRata() + " si perioada este: "+ creditNou.getPerioada());
        creditNou.setRata(rataNou);
        Integer perioadaNou= 360;
        creditNou.setPerioada(perioadaNou);
        System.out.println("Pentru acest credit, rata este: " + creditNou.getRata() + " si perioada este: "+ creditNou.getPerioada());

        SpringApplication.run(FilsoftCreditSolutionProjectApplication.class, args);
    }

}
