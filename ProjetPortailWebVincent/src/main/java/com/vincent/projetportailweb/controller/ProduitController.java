package com.vincent.projetportailweb.controller;


import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import com.vincent.projetportailweb.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    ProduitService service;
    @GetMapping("/produits") //LINK
    public String afficherProduit(Model model){
        Iterable<Produit> listProduits = service.afficherProduit();
        model.addAttribute("listProduits",listProduits);
        return "produits"; // depends on the html file, in this case it's produits.html
    }



    @GetMapping("/produits/new")
    public String afficherFormulaireProduit(Model model){
        Produit produit = new Produit();
        model.addAttribute("produit", produit);

        List<Categorie> listCategorie = service.afficherCategorie();
        model.addAttribute("listCategorie", listCategorie);
        return "produits_form"; //HTML
    }

    @PostMapping("/produits/save")
    public String ajouterProduit(Produit produit, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, Model model){


        // L'interface MultipartFile permet de representer un fichier recu en paramètre dans une requete

        //  la méthode getOriginalFilename retourne le contenu du fichier
        // la méthode getContentType permet de savoir le type du contenu
        String chemin =  file.getOriginalFilename();
        String typeContenu =  file.getContentType();
        System.out.println("chemin : " + chemin);
        System.out.println("typeContenu : " + typeContenu);
        //Nettegoe du nom fichier en cas des séquences indésirable.
        String fileName = StringUtils.cleanPath(chemin);

        produit.setUrl_photo(fileName);
        // ajouter des données temporairement durant la requete
        redirectAttributes.addFlashAttribute("message","Le produit a été ajouté avec success");

        service.ajouterProduit(produit);
        return "redirect:/produits";
    }




}
