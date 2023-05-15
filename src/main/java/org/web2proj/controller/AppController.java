package org.web2proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AppController {

    @GetMapping("/")
    public String pageAccueil (){
        return "index";
    }

    @GetMapping("/connexion")
    public String pageConnexion (){
        return "connexion";
    }

    @GetMapping("/espaceEP")
    public String pageEspaceEP (){
        return "espaceEP";
    }

    @GetMapping("/espaceEP_Admin")
    public String pageEspaceEPAdmin (){
        return "espaceEP_Admin";
    }

    @GetMapping("/espaceEP_Professeur")
    public String pageEspaceEPProfesseur (){
        return "espaceEP_Professeur";
    }

    @GetMapping("/espaceEP_Visiteur")
    public String pageEspaceEPVisiteur (){
        return "espaceEP_Visiteur";
    }

    @GetMapping("/tutorat")
    public String pageTutorat (){
        return "tutorat";
    }

    @GetMapping("/inscription")
    public String pageInscription (){
        return "inscription";
    }

}

