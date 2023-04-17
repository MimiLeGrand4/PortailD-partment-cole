/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import com.ralphchg.portaildepartementinformatique.model.entities.Role;
import com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur;
import java.util.List;
import java.util.Scanner;


public class UtilisateurImplDaoTest {
    public static void main(String[] args){
    //testFindAll();
   //testFindAllFichiers();
  
  
  
       // testAjouterEtudiant();
     //testUpdateEtudiant();
     // testDelete();
     //testUpdateProf();
     //testAjouterProf();
     //testAjouterNotesDeCours();
     //testUpdateNotesDeCours();
    // testDeleteNotesDeCours();
     
    }
     public static void testFindAll() {
        System.out.println("findAll");
        UtilisateurImplDao instance = new UtilisateurImplDao();
        List<Utilisateur> result = instance.findAll();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Utilisateur utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }

     

     public static void testAjouterEtudiant(){
        System.out.println("ajouter Etudiant");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);


        
        System.out.println("Entrez le nom de l'étudiant");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        
      
        
        boolean active = false;
        int accountType_id = 2;
        

        utilisateur = new Utilisateur( active , nom, prenom , password , accountType_id );
     
        boolean result = instance.ajouterEtudiant(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
        
        
   
     }
     public static void testAjouterProf(){
        System.out.println("ajouter Prof");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);


        
        System.out.println("Entrez le nom du prof");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        
      
        
        boolean active = false;
        int accountType_id = 2;
        

        utilisateur = new Utilisateur( active , nom, prenom , password , accountType_id );
     
        boolean result = instance.ajouterProfesseur(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
        
        
   
     }

        public static void testUpdateEtudiant(){
            System.out.println("update Etudiant");
            Utilisateur utilisateur = null;
            UtilisateurImplDao instance = new UtilisateurImplDao();
            Scanner lectureClavier = new Scanner(System.in);
            System.out.println("Entrez l'id de l'étudiant à mettre à jour : ");
            int id = lectureClavier.nextInt();
            utilisateur = instance.findById(id);

            if(utilisateur == null) {
                System.out.println("L'étudiant n'existe pas !");
                return;
            }

            System.out.println("Entrez le nom de l'étudiant");
            String nom = lectureClavier.next();
            utilisateur.setNom(nom);
            System.out.println("Entrez le prénom ");
            String prenom = lectureClavier.next();
            utilisateur.setPrenom(prenom);
            System.out.println("Entrez le mot de passe");
            String password = lectureClavier.next();
            utilisateur.setPassword(password);

            boolean result = instance.updateEtudiant(utilisateur);
            if (result) {
                System.out.println("L'étudiant est mis à jour ");
            } else {
                System.out.println("Échec de mise à jour ");
            }
        }

     public static void testUpdateProf(){
            System.out.println("update Etudiant");
            Utilisateur utilisateur = null;
            UtilisateurImplDao instance = new UtilisateurImplDao();
            Scanner lectureClavier = new Scanner(System.in);
            System.out.println("Entrez l'id de l'utilisateur à mettre à jour : ");
            int id = lectureClavier.nextInt();
            utilisateur = instance.findById(id);

            if(utilisateur == null) {
                System.out.println("Le professeur n'existe pas !");
                return;
            }

            System.out.println("Entrez le nom du prof");
            String nom = lectureClavier.next();
            utilisateur.setNom(nom);
            System.out.println("Entrez le prénom ");
            String prenom = lectureClavier.next();
            utilisateur.setPrenom(prenom);
            System.out.println("Entrez le mot de passe");
            String password = lectureClavier.next();
            utilisateur.setPassword(password);

            boolean result = instance.updateProfesseur(utilisateur);
            if (result) {
                System.out.println("Le prof est mis à jour ");
            } else {
                System.out.println("Echec de mise à jour ");
            }
        }
     
    public static void testDelete() {
        System.out.println("delete");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        
            System.out.println("Entrez l'id de l'utilisateur : ");
            id = lectureClavier.nextInt();

        boolean result = instance.delete(id);
        if (result) {
            System.out.println("L'utilisateur dont l'id est " + id + " a été supprimé de la base de données.");
        } else {
            System.out.println("L'utilisateur dont l'id est " + id + " n'existe pas dans la base de données.");
        }
    }

    
     
     
     
     
     
     

    public static void testFindById() {
        System.out.println("findById");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez l'ide l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Utilisateur result = instance.findById(id);
        System.out.println(result.toString());

    }

    /**
     * Test of findByName method, of class UtilisateurImplDao.
     */
    public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Utilisateur result = instance.findByName(nom);
        System.out.println(result.toString());

    }

    public static void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        Utilisateur result = instance.findByEmail(email);
        System.out.println(result.toString());
    }

    /**
     * Test of existsByEmailAndPassword method, of class UtilisateurImplDao.
     */
    public static void testExistsByEmailAndPassword() {
        System.out.println("existsByEmailAndPassword");
        String email = "";
        String motDePasse = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez l'email de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        System.out.println("Entrez le mot depase de l'utilisateur : ");

        motDePasse = lectureClavier.next();
        Utilisateur result = instance.existsByEmailAndPassword(email, motDePasse);
        System.out.println(result.toString());

    }


    public static void testCreate() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;

        System.out.println("Entrez le nom de l'utilisateur");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
     
        boolean result = instance.create(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }

    }

    
    public static void testUpdate() {
        System.out.println("update");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'ide l'utilisateur à mettre à jour : ");
        int id = lectureClavier.nextInt();
        utilisateur = instance.findById(id);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        utilisateur.setEmail(email);
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;
        utilisateur.setTuteur(active);

        System.out.println("Entrez password");
        String password = lectureClavier.next();
        utilisateur.setPassword(password);
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        utilisateur.setPhoto(photo);

        boolean result = instance.update(utilisateur);
        if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }

    }
    

    public static void testCreate_Utilisateur_Role() {
        System.out.println("create role");
        Utilisateur utilisateur = null;
      //  Role role = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        
         Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;

        System.out.println("Entrez le nom de l'utilisateur");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
         //ajouter du role
        System.out.println("Quel est le role de " + nom + " " + prenom + " ? ");
        //   System.out.println("Entrez l'ide l'utilisateur : ");
     
      //  int id = lectureClavier.nextInt();
        System.out.println("Choisir entre admin, vendeur, editeur, expediteur et assistant");
        String roleUtilisateur = lectureClavier.next();
        String userRole = roleUtilisateur.toLowerCase();
   
        boolean result = instance.create(utilisateur, userRole);
          if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }
        
       
    }
    
     public static void testFindAllRole() {
        System.out.println("findAllRole");
        UtilisateurImplDao instance = new UtilisateurImplDao();
    
        List<Role> result = instance.findAllRole();
         System.out.println(result.get(1).afficherTitreDesColonnes());
         for (Role role : result) {
                 System.out.println(role.toString());
         }
     
    }
     
       public static void testFindAllByNameRole() {
        System.out.println("findAllByNameRole");
        String nomRole = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
         Scanner lectureClavier = new Scanner(System.in);
            System.out.println("Entrez le nom du role ");
       nomRole = lectureClavier.next();
        List<Utilisateur> result = instance.findAllByNameRole(nomRole);
        System.out.println(result.get(0).afficherTitreDesColonnes());
         for (Utilisateur utilisateur : result) {
                 System.out.println(utilisateur.toString());
         }
     
    }
       
       public static void testFindByNameRole() {
        System.out.println("findByIdRole");
         String nomRole = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
         Scanner lectureClavier = new Scanner(System.in);
            System.out.println("Entrez le nom du role ");
       nomRole = lectureClavier.next();
        Utilisateur result = instance.findByNameRole(nomRole);
          System.out.println(result.afficherTitreDesColonnes());
           System.out.println(result.toString());
      
    }
}
