package com.vincent.projetportailweb.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vincent.projetportailweb.entities.Fichier;

@Repository
public interface FichierRepository extends CrudRepository<Fichier, Integer> {



}
