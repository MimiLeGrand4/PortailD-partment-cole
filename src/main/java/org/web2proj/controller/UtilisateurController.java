package org.web2proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web2proj.entities.Fichier;
import org.web2proj.entities.Utilisateur;
import org.web2proj.service.UtilisateurService;

import java.util.List;

@Controller
public class UtilisateurController {

 @Autowired
    UtilisateurService service;


    @PostMapping("/inscription/save")
    public String ajouterUtilisateur(Utilisateur utilisateur, RedirectAttributes redirectAttributes){


        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec success");
        service.ajouterUtilisateur(utilisateur);
        return "redirect:/espaceEP";
    }


    @GetMapping("/notedecours")
    public String afficherUtilisateur(Model model){
        Iterable<Fichier> listfichiers = service.afficherNoteDeCours();
        model.addAttribute("listfichiers",listfichiers);
        return "notedecours";
    }
}
