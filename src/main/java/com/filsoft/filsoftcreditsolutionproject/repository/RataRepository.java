package com.filsoft.filsoftcreditsolutionproject.repository;

import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RataRepository extends JpaRepository<Rata, UUID> {

    List<Rata> findByCreditId(UUID creditId);

}