package com.example.assurance.services;

import com.example.assurance.entities.Assurance;
import com.example.assurance.entities.Benefeciaire;
import com.example.assurance.entities.Contrat;
import com.example.assurance.repositories.AssuranceRepository;
import com.example.assurance.repositories.BeneficiaireRepository;
import com.example.assurance.repositories.ContratRepository;
import org.springframework.stereotype.Service;

@Service
public class AssurExamServiceImpl implements IAssurExamService{

    final AssuranceRepository assuranceRepository;
    final BeneficiaireRepository beneficiaireRepository;
    final ContratRepository contratRepository;

    public AssurExamServiceImpl(AssuranceRepository assuranceRepository,
                                BeneficiaireRepository beneficiaireRepository,
                                ContratRepository contratRepository)
    {
        this.assuranceRepository = assuranceRepository;
        this.beneficiaireRepository = beneficiaireRepository;
        this.contratRepository = contratRepository;
    }


    @Override
    public Benefeciaire ajouterBeneficiaire(Benefeciaire bf) {
        return  beneficiaireRepository.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Benefeciaire benefeciaire = beneficiaireRepository.getByCin(cinBf);
        Contrat contrat = contratRepository.getByMatricule(matricule);

        a.setBenefeciaire(benefeciaire);
        a.setContrat(contrat);
        return   assuranceRepository.save(a);
    }
}
