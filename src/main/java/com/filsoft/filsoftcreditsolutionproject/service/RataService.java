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

    public void deleteRata(UUID id) {
        rataRepository.deleteById(id);
    }

    public Rata getRataById(UUID id) {
        return rataRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Rata not found with id: " + id));
    }

    public List<Rata> getAllRate() {
        return rataRepository.findAll();
    }
}