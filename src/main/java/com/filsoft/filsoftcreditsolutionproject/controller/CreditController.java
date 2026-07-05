package com.filsoft.filsoftcreditsolutionproject.controller;


import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.service.CreditService;
import com.filsoft.filsoftcreditsolutionproject.service.RataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private RataService rataService;


    @PostMapping("/create")


    public ResponseEntity<String> createCredit(@RequestBody CreditDTO creditDTO) {


        Credit creditT1 = creditDTO.toCredit();
        creditService.saveCredit(creditT1);
        // Logic to create a credit
        return ResponseEntity.ok("Credit created successfully with ID: " + creditT1.getId());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<CreditResponseDTO> getCredit(@PathVariable String id) {
        Credit credit = creditService.getCredit(UUID.fromString(id));
        if (credit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CreditResponseDTO.fromCredit(credit));
    }
}
