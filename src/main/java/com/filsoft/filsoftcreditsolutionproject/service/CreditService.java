package com.filsoft.filsoftcreditsolutionproject.service;

import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Credit getCredit(UUID id){return creditRepository.getReferenceById(id);}
}
