package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Projet;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetController {

    @Autowired
    ProjetService service;
    @GetMapping("/listeProjet")
    public String afficherProjet(Model model){
        Iterable<Projet> listProjet= service.afficherProjet();
        model.addAttribute("listProjets",listProjet);
        Iterable<Utilisateur> listUtilisateurs = service.afficherUtilisateurs();
        model.addAttribute("listUtilisateurs",listUtilisateurs);
        return "listeProjet";


    }
}
