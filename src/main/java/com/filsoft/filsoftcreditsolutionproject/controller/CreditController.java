package com.filsoft.filsoftcreditsolutionproject.controller;


import com.filsoft.filsoftcreditsolutionproject.model.Credit;
import com.filsoft.filsoftcreditsolutionproject.model.Rata;
import com.filsoft.filsoftcreditsolutionproject.service.CreditService;
import com.filsoft.filsoftcreditsolutionproject.service.RataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/credit")
@CrossOrigin
public class CreditController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private RataService rataService;


    @PostMapping("/create")
    public ResponseEntity<String> createCredit(@RequestBody CreditDTO creditDTO) {


        Credit creditT1 = creditDTO.toCredit();

        List<Rata> listRata = creditService.getListOfCalculatedRatesForCredit(creditDTO);

        creditT1.setRataList(listRata);
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

    @GetMapping("/search")
    public ResponseEntity<List<CreditResponseDTO>> searchCredits(
            @RequestParam(required = false) String nume,
            @RequestParam(required = false) Integer fiscalCode) {

        List<Credit> credits = creditService.searchCredits(nume, fiscalCode);
        List<CreditResponseDTO> result = credits.stream()
                .map(CreditResponseDTO::fromCredit)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{idCredit}/{idRata}/pay")
    public ResponseEntity<RataResponseDTO> payRata(@PathVariable String idCredit,
                                                   @PathVariable Integer idRata) {

        Rata rata = rataService.getRataByIdCreditAndIdRata(UUID.fromString(idCredit), idRata);

        Rata rataPayed = rataService.payRata(rata);

        return ResponseEntity.ok(RataResponseDTO.fromRata(rataPayed));
    }

}
