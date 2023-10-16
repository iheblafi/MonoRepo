package tn.esprit.spring.interfaces;


import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;

import java.time.LocalDate;

public interface IExamenService {
    public void ajouterApprenant (Apprenant apprenant);
    public void ajouterFormateur(Formateur formateur);
    public void ajouterEtAffecterFormationAFormateur (Formation formation, Integer idFormateur);
    public void affecterApprenantFormation (Integer idApprenant, Integer idFormation);
    public void getNbrApprenantByFormation ();
    public Integer getFormateurRemunerationByDate(Integer idFormateur, LocalDate dateDebut, LocalDate dateFin) ;
    public Integer getRevenuByFormation(Integer idFormation);

}

