package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant,Integer> {


}
