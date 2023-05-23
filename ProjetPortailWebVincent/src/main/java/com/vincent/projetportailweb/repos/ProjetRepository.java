package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Projet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends CrudRepository<Projet,Integer> {
}
