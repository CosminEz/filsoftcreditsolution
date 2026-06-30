package com.filsoft.filsoftcreditsolutionproject;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.service.CreditService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.UUID;


@SpringBootApplication
public class FilsoftCreditSolutionProjectApplication {

    public static void main(String[] args) {

        // 1. Pornim aplicatia si obtinem contextul Spring
        ConfigurableApplicationContext context =
                SpringApplication.run(FilsoftCreditSolutionProjectApplication.class, args);

        // 2. Luam beanul CreditService din context (are deja CreditRepository injectat)
        CreditService creditService = context.getBean(CreditService.class);

        // 3. Construim Creditul (fara id, e generat automat de @GeneratedValue)
        Credit credit = Credit.builder()
                .nume("Credit Test Nou")
                .perioada(123)
                .fiscalCode(1)
                .build();

        // 4. Salvam in baza de date prin service
//        creditService.saveCredit(credit);

        creditService.deleteCredit(UUID.fromString("5d5874a5-9454-499b-abf3-ab93c46c8791"));


        System.out.println("Credit salvat cu id: " + credit.getId());
    }

}
