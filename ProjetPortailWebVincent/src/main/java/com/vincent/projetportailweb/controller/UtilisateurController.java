package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Fichier;

import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.service.UtilisateurNotFoundException;
import com.vincent.projetportailweb.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class UtilisateurController {

 @Autowired
 UtilisateurService service;

    @GetMapping("/listeEtudiant")
    public String afficherUtilisateur(Model model){
        Iterable<Utilisateur> listUtilisateurs = service.afficherUtilisateurs();
        model.addAttribute("listUtilisateurs",listUtilisateurs);
        return "listeEtudiant";
    }
/*
    @GetMapping("/utilisateurs/new")
    public String afficherFormulaireUtilisateur(Model model){
        Utilisateur utilisateur = new Utilisateur();
       // utilisateur.setActive(true);

        model.addAttribute("utilisateur", utilisateur);
        List<Role> listeRole = service.afficherRoles();
        model.addAttribute("listeRole", listeRole);
        model.addAttribute("pageTitle","Ajouter un nouveau utilisateur");

        return "utilisateurs_form";
    }

    @PostMapping("/utilisateurs/save")
    public String ajouterUtilisateur(Utilisateur utilisateur, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file){
        // ajouter des données temporairement durant la requete
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec success");
        service.ajouterUtilisateur(utilisateur);
        return "redirect:/utilisateurs";
    }
*/
    @PostMapping("/inscription/save")
    public String ajouterUtilisateur(Utilisateur utilisateur, RedirectAttributes redirectAttributes){


        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec success");
        service.ajouterUtilisateur(utilisateur);
        return "redirect:/espaceEP";
    }
    @GetMapping("/listeEtudiant/delete/{id}")
    public String supprimerUtilisateur(@PathVariable(name = "id") Integer id,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {
        try {
            service.delete(id);;
            redirectAttributes.addFlashAttribute("message",
                    "L'utilisateur ID " + id + " a été supprimé avec succès ");
        } catch (UtilisateurNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver un utilisateur avec l'id " + id);
        }

        return "redirect:/listeEtudiant";
    }


//    @GetMapping("/notedecours")
//    public String afficherUtilisateur(Model model){
//        Iterable<Fichier> listfichiers = service.afficherNoteDeCours();
//        model.addAttribute("listfichiers",listfichiers);
//        return "notedecours";
//    }

}
