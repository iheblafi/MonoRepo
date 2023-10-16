package com.example.boutique.repositories;

import com.example.boutique.entities.CentreCommercial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreCommercialRepository extends CrudRepository<CentreCommercial, Long> {
}
