package com.filsoft.filsoftcreditsolutionproject.service;

import com.filsoft.filsoftcreditsolutionproject.controller.CreditDTO;
import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.repository.CreditRepository;
import com.filsoft.filsoftcreditsolutionproject.repository.RataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public void saveCredit(Credit credit){
        creditRepository.saveAndFlush(credit);
    }

    public void deleteCredit(UUID id){
        creditRepository.deleteById(id);
    }

    @Autowired
    private RataRepository rataRepository;
    public List<Rata> getListOfRata(Credit credit) {
        return rataRepository.findByCreditId(credit.getId());
    }

    public Credit getCredit(UUID id){
        return creditRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Credit not found with id: " + id));
    }

    public List<Credit> getAllCredits(){return creditRepository.findAll();}

    public List<Credit> searchCredits(String nume, Integer fiscalCode) {
        if (fiscalCode != null) {
            return creditRepository.findByFiscalCode(fiscalCode);
        }
        if (nume != null && !nume.isBlank()) {

            return creditRepository.findByNumeContainingIgnoreCase(nume.trim());
        }
        return new ArrayList<>();
    }


    public List<Rata> getListOfCalculatedRatesForCredit(CreditDTO creditDTO){
        // P = principalul (suma imprumutata)
        double principal = creditDTO.getSuma();

        // n = numarul total de rate (luni) - perioada este deja exprimata in luni
        int n = creditDTO.getPerioada();

        // r = dobanda lunara = dobanda anuala / 12 / 100
        double r = creditDTO.getDobanda() / 12.0 / 100.0;

        List<Rata> rateList = new ArrayList<>();

        // R = rata lunara (constanta pe toata perioada)
        // R = P * ( r * (1 + r)^n ) / ( (1 + r)^n - 1 )
        double rataLunara;
        if (r == 0) {
            // credit fara dobanda: rata este pur si simplu P / n
            rataLunara = principal / n;
        } else {
            double factor = Math.pow(1 + r, n);
            rataLunara = principal * (r * factor) / (factor - 1);
        }

        double soldRamas = principal;

        for (int i = 0; i < n; i++) {
            // dobanda lunara aplicata la soldul ramas
            double dobandaLuna = soldRamas * r;
            // partea de principal din rata curenta
            double principalLuna = rataLunara - dobandaLuna;

            // se scade principalul platit din soldul ramas
            soldRamas -= principalLuna;

            Rata rata = Rata.builder()
                    .id(i + 1) // id-ul face parte din cheia compusa (numarul ratei: 1, 2, 3...)
                    .principal((int) Math.round(principalLuna))
                    .dobanda((int) Math.round(dobandaLuna))
                    .status(false) // rata neplatita
                    .build();

            rateList.add(rata);
        }

        return rateList;
    }
}
