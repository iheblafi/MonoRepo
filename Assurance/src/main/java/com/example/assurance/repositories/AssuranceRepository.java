package com.example.assurance.repositories;

import com.example.assurance.entities.Assurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends CrudRepository<Assurance, Integer> {
}
