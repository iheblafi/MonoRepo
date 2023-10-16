package com.example.boutique.services;

import com.example.boutique.entities.Boutique;
import com.example.boutique.entities.Categorie;
import com.example.boutique.entities.CentreCommercial;
import com.example.boutique.entities.Client;

import java.util.List;

public interface IExamService {

    void ajoutCentre(CentreCommercial centre);
    void ajouterEtAffecterListeBoutiques(List<Boutique> lb, Long idCentre);
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutique);
    List<Client> listeClients(Long idCentre);
    List<Boutique> listeBoutiques(Long idCentre);
    List<Client> listeDeClientsParCategorie(Categorie categorie);

}
