package com.example.boutique.repositories;

import com.example.boutique.entities.Boutique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoutiqueRepository extends CrudRepository<Boutique, Long> {

}
