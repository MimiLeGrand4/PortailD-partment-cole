package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import com.vincent.projetportailweb.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategorieController {

    @Autowired
    CategorieService service;

    @GetMapping("/categories")
    public String afficherCategorie(Model model) {
        Iterable<Categorie> listCategories = service.afficherCategorie();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String afficherFormulaireCategorie(Model model){
        Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);

        return "categories_form";
    }

    @PostMapping("/categories/save")
    public String ajouterCategorie(Categorie categorie){
        service.ajouterCategorie(categorie);
        return "redirect:/categories";
    }


    @GetMapping("/categories/{categorie_id}")
    public String afficherProduitsParCategorie_ID(@PathVariable("categorie_id") long categorie_id, Model model){
        Iterable<Produit> listProduits = service.getProduitsByCategorieId(categorie_id);
        model.addAttribute("listProduits",listProduits);
        return "produits_categorie";
    }

}