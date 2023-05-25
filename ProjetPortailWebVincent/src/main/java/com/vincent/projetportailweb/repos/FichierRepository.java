package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Fichier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichierRepository extends CrudRepository<Fichier, Integer> {



}
