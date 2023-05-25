package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.Projet;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @GetMapping("/projetEtudiant")
    public String afficher(Model model) {
        Iterable<Projet> fileList = service.afficherProjet();
        model.addAttribute("list", fileList);
        return "projetEtudiant";
    }


    @GetMapping("/projetEtudiant/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = service.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/projetEtudiant")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model, RedirectAttributes redirectAttributes) throws IOException {
        service.uploadImage(file);
        Iterable<Projet> fileList = service.afficherProjet();
        model.addAttribute("list", fileList);
        redirectAttributes.addFlashAttribute("message", "Le projet a été ajouter avec succès");

        return "redirect:/projetEtudiant";

    }
}
