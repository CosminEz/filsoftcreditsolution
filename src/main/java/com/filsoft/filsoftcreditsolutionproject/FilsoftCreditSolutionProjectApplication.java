package com.filsoft.filsoftcreditsolutionproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FilsoftCreditSolutionProjectApplication {

    public static void main(String[] args) {

        // 1. Pornim aplicatia si obtinem contextul Spring
        ConfigurableApplicationContext context =
                SpringApplication.run(FilsoftCreditSolutionProjectApplication.class, args);
//
//        // 2. Luam beanul CreditService din context (are deja CreditRepository injectat)
//        CreditService creditService = context.getBean(CreditService.class);
//        RataService rataService = context.getBean(RataService.class);
//
////        //TEMA
//        Credit creditT1 = Credit.builder()
//                .nume("CreditTema1")
//                .perioada(120)
//                .fiscalCode(100)
//                .build();
////
//        Credit creditT2 = Credit.builder()
//                .nume("CreditTema2")
//                .perioada(240)
//                .fiscalCode(200)
//                .build();
////
//        Credit creditT3 = Credit.builder()
//                .nume("CreditTema3")
//                .perioada(360)
//                .fiscalCode(300)
//                .build();
////
//        Credit creditT4 = Credit.builder()
//                .nume("CreditTema4")
//                .perioada(480)
//                .fiscalCode(400)
//                .build();
//
//        List.of(creditT1,creditT2, creditT3, creditT3).forEach(creditService::saveCredit);


////TEMA
//        Rata rata10 = Rata.builder()
//                .principal(500)
//                .dobanda(150)
//                .build();
//
//        Rata rata11 = Rata.builder()
//                .principal(1000)
//                .dobanda(250)
//                .build();
//
//        Rata rata12 = Rata.builder()
//                .principal(1500)
//                .dobanda(350)
//                .build();
//
//        Rata rata13 = Rata.builder()
//                .principal(2000)
//                .dobanda(300)
//                .build();
//
//        Rata rata14 = Rata.builder()
//                .principal(3390)
//                .dobanda(550)
//                .build();
//        rata10.setCredit(creditT2);
//        rata11.setCredit(creditT2);
//        rata12.setCredit(creditT1);
//        rata13.setCredit(creditT3);
//        rata14.setCredit(creditT1);
//
//        rataService.saveRata(rata10);
//        rataService.saveRata(rata11);
//        rataService.saveRata(rata12);
//        rataService.saveRata(rata13);
//        rataService.saveRata(rata14);
    }
}