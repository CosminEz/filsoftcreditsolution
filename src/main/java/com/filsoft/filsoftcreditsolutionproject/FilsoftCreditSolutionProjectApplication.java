package com.filsoft.filsoftcreditsolutionproject;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.service.CreditService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
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
        Credit creditIulia = Credit.builder()
                .nume("Iulia2")
                .perioada(360)
                .fiscalCode(239)
                .build();

        Credit credit2 = Credit.builder()
                .nume("Roma")
                .perioada(240)
                .fiscalCode(2307)
                .build();

        Credit credit3 = Credit.builder()
                .nume("Audi")
                .perioada(900)
                .fiscalCode(5008)
                .build();

        Credit credit4 = Credit.builder()
                .nume("Bali")
                .perioada(40)
                .fiscalCode(3290)
                .build();

        Credit creditAudi=creditService.getCredit(UUID.fromString("a2b84b25-b3d6-4cc0-87a6-2d47361dabee"));
        creditAudi.setNume("BMW");
        creditService.saveCredit(creditAudi);

        List<Credit> list = creditService.getAllCredits();
        System.out.println(list + " size: " + list.size());
//        System.out.println("Credit salvat cu id: " + credit.getId());

        Rata rata1= Rata.builder()
                .principal(300)
                .dobanda(200)
                .build();

        Rata rata2=Rata.builder()
                .principal(800)
                .dobanda(400)
                .build();
        List<Rata> rataList=List.of(rata1,rata2);
        creditAudi.setRataList(rataList);
        creditService.saveCredit(creditAudi);
    }

}
