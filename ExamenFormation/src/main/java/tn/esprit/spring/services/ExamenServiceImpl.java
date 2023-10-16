package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;
import tn.esprit.spring.interfaces.IExamenService;
import tn.esprit.spring.repositories.ApprenantRepository;
import tn.esprit.spring.repositories.FormateurRepository;
import tn.esprit.spring.repositories.FormationRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ExamenServiceImpl implements IExamenService {

@Autowired
    ApprenantRepository apprenantRepository;

    @Autowired
    FormateurRepository formateurRepository;

    @Autowired
    FormationRepository formationRepository;
    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
    }

    @Override
    public void ajouterFormateur(Formateur formateur) {

        formateurRepository.save(formateur);
    }


    @Override
    public void ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur) {
        Formateur formateur = formateurRepository.findById(idFormateur).orElse(null);
        formation.setFormateur(formateur);
        formationRepository.save(formation);
    }

    @Override
    public void affecterApprenantFormation(Integer idApprenant, Integer idFormation) {
        Apprenant apprenant = apprenantRepository.findById(idApprenant).orElse(null);
        Formation formation = formationRepository.findById(idFormation).orElse(null);

        if(formation.getNbrMaxParticipant()>=formation.getListApprenants().size())
        {
            formation.getListApprenants().add(apprenant);
            formationRepository.save(formation);
        }
        else {
            log.info("Nombre maximal atteint");
        }

    }
   //@Scheduled(fixedRate = 300000) ou bien
  @Scheduled(cron = "*/30 * * * * *")

    @Override
    public void getNbrApprenantByFormation() {

        List<Formation> listFormation =  formationRepository.findAll();

        listFormation.forEach(formation -> {
            log.info("La formation  "+ formation.getTitle()+" contient : "+ formation.getListApprenants().size()+ "apprenants");
        });

    }

    @Override
    public Integer getFormateurRemunerationByDate(Integer idFormateur, LocalDate dateDebut, LocalDate dateFin) {
Integer somme = 0;
        Formateur formateur = formateurRepository.findById(idFormateur).orElse(null);
        for (Formation formation : formateur.getListFormations()){
            if(formation.getDateDebut().isAfter(dateDebut) && formation.getDateFin().isBefore(dateFin)){
                somme +=  formation.getNbHeure()* formation.getFormateur().getTarifHoraire();
            }
        }
        return somme;
    }

    @Override
    public Integer getRevenuByFormation(Integer idFormation) {
        Formation formation = formationRepository.findById(idFormation).orElse(null);
        return  formation.getListApprenants().size() * formation.getFrais();


    }
}
