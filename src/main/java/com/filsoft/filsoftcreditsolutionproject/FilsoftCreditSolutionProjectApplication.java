package com.filsoft.filsoftcreditsolutionproject;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.service.CreditService;
import com.filsoft.filsoftcreditsolutionproject.service.RataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
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
        RataService rataService = context.getBean(RataService.class);
//
//        // 3. Construim Creditul (fara id, e generat automat de @GeneratedValue)
//        Credit credit = Credit.builder()
//                .nume("Credit Test Nou")
//                .perioada(123)
//                .fiscalCode(1)
//                .build();
//        Credit creditIulia = Credit.builder()
//                .nume("Iulia2")
//                .perioada(360)
//                .fiscalCode(239)
//                .build();
//
//        Credit credit2 = Credit.builder()
//                .nume("Roma")
//                .perioada(240)
//                .fiscalCode(2307)
//                .build();
//
//        Credit credit3 = Credit.builder()
//                .nume("Audi")
//                .perioada(900)
//                .fiscalCode(5008)
//                .build();
//
//        Credit credit4 = Credit.builder()
//                .nume("Bali")
//                .perioada(40)
//                .fiscalCode(3290)
//                .build();


        //  Credit creditAudi=creditService.getCredit(UUID.fromString("a2b84b25-b3d6-4cc0-87a6-2d47361dabee"));
//        creditAudi.setNume("BMW");
//        creditService.saveCredit(creditAudi);
//
//        List<Credit> list = creditService.getAllCredits();
//        System.out.println(list + " size: " + list.size());
////        System.out.println("Credit salvat cu id: " + credit.getId());
//
//        Rata rata1= Rata.builder()
//                .principal(300)
//                .dobanda(200)
//                .build();
//
//        Rata rata2=Rata.builder()
//                .principal(800)
//                .dobanda(400)
//                .build();
//        List<Rata> rataList=List.of(rata1,rata2);
//        creditAudi.setRataList(rataList);
//        creditService.saveCredit(creditAudi);


//        //TEMA
        Credit creditT1 = Credit.builder()
                .nume("CreditTema1")
                .perioada(120)
                .fiscalCode(100)
                .build();
//
        Credit creditT2 = Credit.builder()
                .nume("CreditTema2")
                .perioada(240)
                .fiscalCode(200)
                .build();
//
        Credit creditT3 = Credit.builder()
                .nume("CreditTema3")
                .perioada(360)
                .fiscalCode(300)
                .build();
//
        Credit creditT4 = Credit.builder()
                .nume("CreditTema4")
                .perioada(480)
                .fiscalCode(400)
                .build();

        creditService.saveCredit(creditT1);
        creditService.saveCredit(creditT2);
        creditService.saveCredit(creditT3);
        creditService.saveCredit(creditT4);}}
//
//        creditT2.setNume("Credit999");
//        creditService.saveCredit(creditT2);
////
//      //  creditService.deleteCredit("2f82cd26-299f-416e-bb84-f199dbe86ba3");
////
//        creditT4.setPerioada(1000);
//        creditService.saveCredit(creditT4);
////
//   creditT1.setFiscalCode(1111);
//  creditService.saveCredit(creditT1);}}
//2
//        List<Rata> rataList = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//
//            Rata rata = Rata.builder()
//                    .principal(i * 1000)
//                    .dobanda(i * 300 - 50)
//                    .build();
//
//            rata.setCredit(creditT4);
//            rataList.add(rata);
//
//
//        }
//
//        creditT4.setRataList(rataList);
//        creditService.saveCredit(creditT4);
//        creditT4.getRataList().remove(6);
//        creditService.saveCredit(creditT4);
//
//        Rata rataNoua1 = Rata.builder()
//                .principal(500)
//                .dobanda(150)
//                .build();
//
//        Rata rataNoua2 = Rata.builder()
//                .principal(1600)
//                .dobanda(400)
//                .build();
//
//        Rata rataNoua3 = Rata.builder()
//                .principal(2700)
//                .dobanda(650)
//                .build();
//
//
//        rataNoua1.setCredit(creditT4);
//        rataNoua2.setCredit(creditT4);
//        rataNoua3.setCredit(creditT4);
//
//
//       creditT4.getRataList().add(rataNoua1);
//        creditT4.getRataList().add(rataNoua2);
//        creditT4.getRataList().add(rataNoua3);
//
//
//        creditService.saveCredit(creditT4);
//    }

//TEMA
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
//    }}