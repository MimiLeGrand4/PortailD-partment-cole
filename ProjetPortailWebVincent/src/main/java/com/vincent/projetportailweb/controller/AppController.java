package com.vincent.projetportailweb.controller;

import com.vincent.projetportailweb.entities.AccountType;
import com.vincent.projetportailweb.entities.Message;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.MessageRepository;
import com.vincent.projetportailweb.service.ChatService;
import com.vincent.projetportailweb.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/")
    public String pageAccueil(Model model, HttpSession session,RedirectAttributes redirectAttributes) {
        String messageInscription = (String) redirectAttributes.getAttribute("messageInscription");
        if (messageInscription != null) {
            model.addAttribute("messageInscription", messageInscription);
        }


        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        if (utilisateur != null) {
            model.addAttribute("nomUtilisateur", utilisateur.getNom());
            model.addAttribute("prenomUtilisateur", utilisateur.getPrenom());
        } else {
            model.addAttribute("nomUtilisateur", "Invité");
            model.addAttribute("prenomUtilisateur", "Invité");
        }
        return "index";
    }

    @Autowired
    private MessageRepository messageRepository;



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







    @GetMapping("/inscription")
    public String afficherFormulaireUtilisateur(Model model){
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        List<AccountType> listeRoles = utilisateurService.afficherRoles();
        model.addAttribute("listeRoles", listeRoles);
        model.addAttribute("inscriptionReussie", false); // Par défaut, l'inscription n'est pas réussie
        model.addAttribute("pageTitle", "Inscription");
        return "inscription";
    }
    @PostMapping("/inscription")
    public String enregistrerUtilisateur(@ModelAttribute Utilisateur utilisateur, @RequestParam("utilisateur.accountType.id") int accountTypeId, Model model, RedirectAttributes redirectAttributes) {
        AccountType accountType = new AccountType();
        accountType.setId(accountTypeId);
        utilisateur.setAccountType(accountType);

        // Ajoutez ici la logique pour enregistrer l'utilisateur dans la base de données
        utilisateurService.enregistrerUtilisateur(utilisateur);


        redirectAttributes.addFlashAttribute("messageInscription", "Inscription réussie !");







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
            if (user.getAccountType().getNom().equals("administrator")) {
                return "redirect:/espaceEP_Admin";
            }
            else if (user.getAccountType().getNom().equals("professeur")) {
                return "redirect:/espaceEP_Professeur";
            }
            else if (user.getAccountType().getNom().equals("etudiant")) {
                return "redirect:/espaceEP";
            }
            else
            {
                return "redirect:/";
            }

        }

        return "redirect:/connexion";
    }
    @GetMapping("/maPage")
    public String maPage(HttpSession session, Model model) {
        // Obtenir l'utilisateur de la session
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        String vue;
        if (utilisateur != null && utilisateur.getAccountType() != null) {
            switch(utilisateur.getAccountType().getNom()) {
                case "administrator":
                    vue = "redirect:/espaceEP_Admin";
                    break;
                case "professeur":
                    vue = "redirect:/espaceEP_Professeur";
                    break;
                case "etudiant":
                    vue = "redirect:/espaceEP";
                    break;
                default:
                    vue = "redirect:/espaceEP_Visiteur";
            }
        } else {
            vue = "redirect:/espaceEP_Visiteur";
        }

        return vue;
    }
    @GetMapping("/deconnexion")
    public String deconnexion(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.invalidate(); // Invalide la session de l'utilisateur
        Cookie[] cookies = request.getCookies(); // Récupère tous les cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // Définit la durée de vie des cookies à 0 pour les supprimer
                response.addCookie(cookie); // Ajoute les cookies à la réponse
            }
        }
        return "redirect:/"; // Redirige vers la page d'accueil ou une autre page appropriée
    }

    @GetMapping("/recherche")
    public String recherche() {
        return "recherche";
    }
    // Ajoutez cette méthode dans votre contrôleur

    // Ajoutez cette méthode dans votre contrôleur

    @PostMapping("/forum/creer-discussion")
    public String creerDiscussion(@RequestParam("titre") String titre, @RequestParam("message") String message) {
        // Ajoutez ici la logique pour créer une nouvelle discussion dans le forum
        // en utilisant le titre et le message fournis

        // Redirigez l'utilisateur vers la page du forum ou une autre page appropriée
        return "redirect:/forum";
    }
    // Ajoutez cette méthode dans votre contrôleur
    // Ajoutez ici la logique pour traiter l'envoi d'un nouveau message dans le chat
// en utilisant le message fourni

    // Supposez que vous ayez une classe de service appelée ChatService pour gérer les opérations liées au chat.
// Injectez cette classe de service dans votre contrôleur.
    @Autowired
    private ChatService chatService;






    @GetMapping("/chat")
    public String pageChat(Model model, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        if (utilisateur == null) {
            // Aucun utilisateur n'est connecté, donc on le redirige vers la page de connexion
            return "redirect:/connexion";
        }

        model.addAttribute("utilisateur", utilisateur);

        List<Message> messages = chatService.getMessagesWithUser(); // Récupérer tous les messages avec les utilisateurs associés
        model.addAttribute("messages", messages);

        return "chat";
    }



    @PostMapping("/chat/envoyer-message")
    public String envoyerMessage(@RequestParam("message") String message, HttpSession session) {
        // Récupérer l'utilisateur connecté à partir de la session
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        if (utilisateur != null) {

            // Ajouter le message dans le service
            chatService.envoyerMessage(utilisateur, message);
        } else {
            // Si aucun utilisateur n'est connecté, créer un utilisateur invité avec le nom "Invité"
            utilisateur = new Utilisateur();
            utilisateur.setNom("Invité");
            // Ajouter le message avec l'utilisateur invité dans le service
            chatService.envoyerMessage(utilisateur, message);
        }
        // Rediriger l'utilisateur vers la page du chat ou une autre page appropriée
        return "redirect:/chat";
    }












}


