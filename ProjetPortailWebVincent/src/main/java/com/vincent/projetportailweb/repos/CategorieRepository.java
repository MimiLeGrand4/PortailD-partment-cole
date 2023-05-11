package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

    @Query("SELECT u FROM Categorie u WHERE u.nom  LIKE %?1%")
    public List<Categorie> findAll(String keyword);

    @Query("SELECT u FROM Produit u JOIN u.categorie c WHERE c.id = :categorie_id")
    List<Produit> findByCategorieId(@Param("categorie_id") long categorie_id);

}
