package com.filsoft.filsoftcreditsolutionproject.repository;


import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditRepository extends JpaRepository<Credit, UUID> {

    List<Credit> findByNumeContainingIgnoreCase(String nume);

    List<Credit> findByFiscalCode(Integer fiscalCode);
}

