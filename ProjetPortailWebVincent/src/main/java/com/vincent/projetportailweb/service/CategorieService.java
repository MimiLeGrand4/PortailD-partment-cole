package com.vincent.projetportailweb.service;



import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import com.vincent.projetportailweb.repos.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategorieService {
    @Autowired
    private CategorieRepository repo;

    public List<Categorie> afficherCategorie() {
        return (List<Categorie>) repo.findAll();
    }
    public Categorie ajouterCategorie(Categorie categorie){
        return  repo.save(categorie);
    }

    public List<Produit> getProduitsByCategorieId(long categorie_id) {
        return repo.findByCategorieId(categorie_id);
    }


}