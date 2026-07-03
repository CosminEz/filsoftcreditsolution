package com.filsoft.filsoftcreditsolutionproject.service;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.repository.CreditRepository;
import com.filsoft.filsoftcreditsolutionproject.repository.RataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
}
