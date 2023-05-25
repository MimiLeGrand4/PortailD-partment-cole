package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Tuteur;
import com.vincent.projetportailweb.repos.TuteurRepository;
import com.vincent.projetportailweb.service.TutoratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TuteurController {

    @Autowired
    private TutoratService tutoratService;

    @GetMapping("/tutorat")
    public String getTutoratPage(Model model) {
        List<Tuteur> tuteurs = tutoratService.getTuteursDisponibles();
        model.addAttribute("tuteurs", tuteurs);
        model.addAttribute("demandeAide", new Tuteur());
        return "tutorat";
    }
    @PostMapping("/envoyer-demande")
    public String envoyerDemande(@ModelAttribute("demandeAide") Tuteur demandeAide) {
        boolean demandeEnvoyee = tutoratService.demanderAide(demandeAide);
        // Ajoutez le code nécessaire pour traiter la demande envoyée
        return "confirmation"; // Redirigez vers une page de confirmation
    }




}

