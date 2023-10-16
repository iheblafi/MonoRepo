package com.example.assurance.controllers;

import com.example.assurance.entities.Benefeciaire;
import com.example.assurance.entities.Contrat;
import com.example.assurance.services.IAssurExamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("assurance")
@AllArgsConstructor
public class AssurExamController {


    @Autowired
    IAssurExamService iAssurExamService;

    @PostMapping("/addBeneficiaire")
    Benefeciaire addBeneficiaire(@RequestBody Benefeciaire benefeciaire){
        return iAssurExamService.ajouterBeneficiaire(benefeciaire);
    }

    @PostMapping("/addContrat")
    Contrat addContrat(@RequestBody Contrat contrat){
        return iAssurExamService.ajouterContrat(contrat);
    }
}
