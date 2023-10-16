package com.example.assurance.services;

import ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator;
import com.example.assurance.entities.Assurance;
import com.example.assurance.entities.Benefeciaire;
import com.example.assurance.entities.Contrat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface IAssurExamService {
    public Benefeciaire ajouterBeneficiaire(Benefeciaire bf);
    public Contrat ajouterContrat(Contrat c);
    public Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);


}
