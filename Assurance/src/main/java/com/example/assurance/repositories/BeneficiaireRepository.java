package com.example.assurance.repositories;

import com.example.assurance.entities.Benefeciaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaireRepository extends CrudRepository<Benefeciaire, Integer> {
    Benefeciaire getByCin(int cinBf);W
}
