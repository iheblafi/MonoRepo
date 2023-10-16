package com.example.boutique.services;

import com.example.boutique.entities.Boutique;
import com.example.boutique.entities.Categorie;
import com.example.boutique.entities.CentreCommercial;
import com.example.boutique.entities.Client;
import com.example.boutique.repositories.BoutiqueRepository;
import com.example.boutique.repositories.CentreCommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@Service
public class ExamServiceImpl implements IExamService {


    final CentreCommercialRepository centreCommercialRepository;
    private final BoutiqueRepository boutiqueRepository;

    @Autowired
    public ExamServiceImpl(CentreCommercialRepository centreCommercialRepository,
                           BoutiqueRepository boutiqueRepository) {
        this.centreCommercialRepository = centreCommercialRepository;
        this.boutiqueRepository = boutiqueRepository;
    }

    @Override
    public void ajoutCentre(CentreCommercial centre) {

        centreCommercialRepository.save(centre);
    }

    @Override
    public void ajouterEtAffecterListeBoutiques(List<Boutique> lb, Long idCentre) {

        CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);
        Set<Boutique> b= new HashSet<Boutique>();
        centreCommercial.setBoutiques(b);

        centreCommercialRepository.save(centreCommercial);
    }

    @Override
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutique) {

    }

    @Override
    public List<Client> listeClients(Long idCentre) {
        return null;
    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        return null;
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        return null;
    }
}
