package com.vincent.projetportailweb.repos;






import com.vincent.projetportailweb.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

    @Query("SELECT u FROM Produit u WHERE u.nom  LIKE %?1%")
    public List<Produit> findAll(String keyword);
    @Query("SELECT u FROM Produit u WHERE u.nom = :nom")
    public Produit getProduitByNom(@Param("nom") String nom);

}
