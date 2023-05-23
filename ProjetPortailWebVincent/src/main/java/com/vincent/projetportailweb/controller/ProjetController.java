package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Projet;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProjetController {

    @Autowired
    ProjetService service;
    @GetMapping("/listeProjet")
    public String afficherProjet(Model model){
        Iterable<Projet> listProjet= service.afficherProjet();
        model.addAttribute("listProjets",listProjet);
        return "listeProjet";


    }
    @GetMapping("/recherche/projet")
    public String rechercheProjet(Model model, @Param("keyword") String keyword){
        Iterable<Projet> listProjet= service.afficherProjet(keyword);
        model.addAttribute("listProjets",listProjet);
        model.addAttribute("keyword", keyword);
        return "listeProjet";
    }

    @GetMapping("/listeMesProjet")
    public String afficherMesProjet(Model model, HttpSession session){
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        Iterable<Projet> listProjet= service.afficherMesProjet(utilisateur.getId());
        model.addAttribute("listProjets",listProjet);
        return "listeProjet";

    }
}
