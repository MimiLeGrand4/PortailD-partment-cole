package com.vincent.projetportailweb.service;



import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import com.vincent.projetportailweb.repos.CategorieRepository;
import com.vincent.projetportailweb.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProduitService {
    @Autowired
    private ProduitRepository repo;
    @Autowired
    private CategorieRepository categorieRepo;
    public List<Produit> afficherProduit() {
        return (List<Produit>) repo.findAll();
    }
    public Produit ajouterProduit(Produit produit){
        return  repo.save(produit);
    }


    public List<Categorie> afficherCategorie(){

        return ( List<Categorie>)  categorieRepo.findAll();
    }
    public boolean isProduitNomUnique(String nom) {
        Produit produitByNom = repo.getProduitByNom(nom);
        if (produitByNom == null) return true;
        return false;

    }



}