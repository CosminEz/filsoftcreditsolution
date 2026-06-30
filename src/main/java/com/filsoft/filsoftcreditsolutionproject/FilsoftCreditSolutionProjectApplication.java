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

        // 4. Salvam in baza de date prin service
        //creditService.saveCredit(creditIulia);
       // creditService.saveCredit(credit2);
        //creditService.saveCredit(credit3);

       // creditService.saveCredit(credit4);

        //creditService.deleteCredit(UUID.fromString("5d5874a5-9454-499b-abf3-ab93c46c8791"));
        //creditService.deleteCredit(UUID.fromString("ece1ebab-192f-43f3-9483-3781f9bf87c7"));
        //creditService.deleteCredit(UUID.fromString("84a2d122-8912-41e6-8e0d-c7d476d843f8"));
        //creditService.deleteCredit(UUID.fromString("0398bf06-ab03-4602-ae68-421995f5b4fc"));
        //creditService.deleteCredit(UUID.fromString("b658c407-5fd0-4241-9280-c55925c69f50"));
        //creditService.deleteCredit(UUID.fromString("4f06aa2d-f4f7-4a71-ae78-96da36ef1cc9"));
        //creditService.deleteCredit(UUID.fromString("5148c28d-6d5e-4fc0-9a3f-0d4bb677f562"));
        //creditService.deleteCredit(UUID.fromString("8bc9438c-a666-48c9-87a3-73e648549459"));
        //creditService.deleteCredit(UUID.fromString("91bf6002-d501-4796-914c-5bc1d26cdc8f"));
        //creditService.deleteCredit(UUID.fromString("f5f004db-9be4-4f0a-b6e1-273f9a6d833b"));
        //creditService.deleteCredit(UUID.fromString("476fc32b-7317-46eb-93e5-0fef73256558"));
        //creditService.deleteCredit(UUID.fromString("2e5591a5-3c0a-4d1c-8ff1-737f292ec2a0"));
        //creditService.deleteCredit(UUID.fromString("00348ac7-6a28-4b63-8b49-b79ca4f9c1c9"));

        System.out.println("Credit salvat cu id: " + credit.getId());
    }

}
