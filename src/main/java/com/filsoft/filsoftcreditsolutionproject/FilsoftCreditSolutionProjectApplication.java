package com.filsoft.filsoftcreditsolutionproject;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FilsoftCreditSolutionProjectApplication {

    public static void main(String[] args) {
        System.out.println("Salut");

        Rata rataNou1 = new Rata(100, 200);
        Rata rataNou2= new Rata(300,100);
        Credit creditNou = new Credit();

        System.out.println("Pentru acest credit, rata este: " + creditNou.getRataList() + " si perioada este: "+ creditNou.getPerioada());
        creditNou.setRataList(List.of(rataNou1,rataNou2));
        Integer perioadaNou= 360;
        creditNou.setPerioada(perioadaNou);
        System.out.println("Pentru acest credit, rata este: " + creditNou.getRataList() + " si perioada este: "+ creditNou.getPerioada());


        SpringApplication.run(FilsoftCreditSolutionProjectApplication.class, args);
    }

}
