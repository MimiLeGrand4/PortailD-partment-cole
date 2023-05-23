package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends CrudRepository<Projet,Integer> {

    @Query("SELECT u FROM Projet u WHERE u.nom  LIKE %?1% ")
    public List<Projet> findAll(String keyword);
    @Query("SELECT u FROM Projet u WHERE u.user_id.id= :keyword ")
    public List<Projet> findProjetById(@Param("keyword") int keyword);
}
