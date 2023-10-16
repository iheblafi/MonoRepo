package com.example.assurance.repositories;

import com.example.assurance.entities.Benefeciaire;
import com.example.assurance.entities.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer> {

    Contrat getByMatricule(String matricule);
}
