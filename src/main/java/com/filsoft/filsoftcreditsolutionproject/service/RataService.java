package com.filsoft.filsoftcreditsolutionproject.service;

import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.repository.RataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RataService {

    @Autowired
    private RataRepository rataRepository;

    public RataService(RataRepository rataRepository) {
        this.rataRepository = rataRepository;
    }

    public void saveRata(Rata rata) {
        rataRepository.saveAndFlush(rata);
    }

    public List<Rata> getAllRate() {
        return rataRepository.findAll();
    }

    public Rata getRataByIdCreditAndIdRata(UUID idCredit, Integer idRata){
        return rataRepository.findByCreditIdAndId(idCredit, idRata)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Rata not found for credit " + idCredit + " and rata id " + idRata));
    }

    public Rata payRata(Rata rata) {
        rata.setStatus(true);
        return rataRepository.saveAndFlush(rata);
    }
}