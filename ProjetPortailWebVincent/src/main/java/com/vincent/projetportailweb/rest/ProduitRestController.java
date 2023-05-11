package com.vincent.projetportailweb.rest;

import com.vincent.projetportailweb.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestController {
    @Autowired
    ProduitService service;

    @PostMapping("/produits/check_nom")
    public String verifierDoublonNom(@Param("nom") String nom) {
        return service.isProduitNomUnique(nom) ? "OK" : "Doublon";
    }
}
