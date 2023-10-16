package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Integer> {



}
