package com.filsoft.filsoftcreditsolutionproject.repository;

import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.model.RataId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RataRepository extends JpaRepository<Rata, RataId> {

    List<Rata> findByCreditId(UUID creditId);

    Optional<Rata> findByCreditIdAndId(UUID creditId, Integer id);

}