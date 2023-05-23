package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.AccountType;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/")
    public String pageAccueil(Model model, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        if (utilisateur != null) {
            model.addAttribute("nomUtilisateur", utilisateur.getNom());
            model.addAttribute("prenomUtilisateur", utilisateur.getPrenom());
        }
        return "index";
    }


    @GetMapping("/espaceEP")
    public String pageEspaceEP() {
        return "espaceEP";
    }

    @GetMapping("/espaceEP_Admin")
    public String pageEspaceEPAdmin() {
        return "espaceEP_Admin";
    }

    @GetMapping("/espaceEP_Professeur")
    public String pageEspaceEPProfesseur() {
        return "espaceEP_Professeur";
    }

    @GetMapping("/espaceEP_Visiteur")
    public String pageEspaceEPVisiteur() {
        return "espaceEP_Visiteur";
    }

    @GetMapping("/tutorat")
    public String pageTutorat() {
        return "tutorat";
    }





    @GetMapping("/inscription")
    public String afficherFormulaireUtilisateur(Model model){
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        List<AccountType> listeRoles = utilisateurService.afficherRoles();
        model.addAttribute("listeRoles", listeRoles);
        model.addAttribute("pageTitle", "Inscription");
        return "inscription";
    }
    @PostMapping("/inscription")
    public String enregistrerUtilisateur(@ModelAttribute Utilisateur utilisateur, @RequestParam("utilisateur.accountType.id") int accountTypeId) {
        AccountType accountType = new AccountType();
        accountType.setId(accountTypeId);
        utilisateur.setAccountType(accountType);

        // Ajoutez ici la logique pour enregistrer l'utilisateur dans la base de données
        utilisateurService.enregistrerUtilisateur(utilisateur);

        // Redirigez l'utilisateur vers une autre page (par exemple, une page de confirmation)
        return "redirect:/";
    }

    @GetMapping("/connexion")
    public String afficherPageConnexion() {
        return "connexion";
    }
    @PostMapping("/connexion")
    public String submitLoginForm(@RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  @RequestParam(value = "sauvegarde", required = false) String rememberMe,
                                  HttpServletResponse response,
                                  HttpSession session) {
        Utilisateur user = utilisateurService.validateUser(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (rememberMe != null && rememberMe.equals("yes")) {
                Cookie emailCookie = new Cookie("email", email);
                Cookie passwordCookie = new Cookie("password", password);
                emailCookie.setMaxAge(60 * 60 * 24 * 7);  // cookie expire après 7 jours
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);  // cookie expire après 7 jours
                response.addCookie(emailCookie);
                response.addCookie(passwordCookie);
            }
            if (email.equals("admin@admin.com") && password.equals("admin")) {
                return "redirect:/espaceEP_Admin";
            }
            // Vérifier le rôle de l'utilisateur et effectuer la redirection en conséquence
            if (user.getAccountType().getNom().equals("admin")) {
                return "redirect:/espaceEP_Admin";
            } else if (user.getAccountType().getNom().equals("professeur")) {
                return "redirect:/espaceEP_Professeur";
            } else {
                return "redirect:/";
            }

        }

        return "redirect:/connexion";
    }
    @GetMapping("/recherche")
    public String recherche() {
        return "recherche";
    }


}


