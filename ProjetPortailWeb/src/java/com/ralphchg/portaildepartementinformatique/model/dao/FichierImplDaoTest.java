/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vince
 */
public class FichierImplDaoTest {
        public static void main(String[] args){
   //testFindAllFichiers();
 
     //testAjouterNotesDeCours();
     //testUpdateNotesDeCours();
    // testDeleteNotesDeCours();
    
        }
    
         
      public static void testFindAllFichiers() {
        System.out.println("findAllFichiers");
        FichierImplDao instance = new FichierImplDao();
        List<Fichier> result = instance.findAllFichiers();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Fichier fichier : result) {
            System.out.println(fichier.toString());
        }
    }
    
    
         
         public static void testAjouterNotesDeCours(){
        System.out.println("ajouter Fichier/Notes de cours");
        Fichier fichier = null;
        FichierImplDao instance = new FichierImplDao();
        Scanner lectureClavier = new Scanner(System.in);


        
        System.out.println("Entrez le nom du fichier");
        String nom = lectureClavier.next();
        System.out.println("Entrez le contenu ");
        String contenu = lectureClavier.next();


        fichier = new Fichier( nom, contenu );
     
        boolean result = instance.ajouterNotesDeCours(fichier);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
        
        
   
     }
           public static void testUpdateNotesDeCours(){
            System.out.println("update Notes de Cours");
            Fichier fichier= null;
            FichierImplDao instance = new FichierImplDao();
            Scanner lectureClavier = new Scanner(System.in);
            System.out.println("Entrez l'id de la note de cours que vous voulez modifier : ");
            int id = lectureClavier.nextInt();
            fichier = instance.findFichierById(id);

            if(fichier == null) {
                System.out.println("Le fichier n'existe pas !");
                return;
            }

            System.out.println("Entrez le nouveau nom du fichier");
            String nom = lectureClavier.next();
            fichier.setNom(nom);
            System.out.println("Entrez le nouveau contenu ");
            String prenom = lectureClavier.next();
            fichier.setContenu(prenom);

            boolean result = instance.updateNotesDeCours(fichier);
            if (result) {
                System.out.println("Le fichier est mis à jour ");
            } else {
                System.out.println("Échec de mise à jour ");
            }
        }
           
           
           public static void testDeleteNotesDeCours(){
                       System.out.println("delete notes de cours");
        int id = 0;
        FichierImplDao instance = new FichierImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        
            System.out.println("Entrez l'id du fichier de notes de cours : ");
            id = lectureClavier.nextInt();

        boolean result = instance.deleteNotesDeCours(id);
        if (result) {
            System.out.println("Le fichier dont l'id est " + id + " a été supprimé de la base de données.");
        } else {
            System.out.println("Le fichier dont l'id est " + id + " n'existe pas dans la base de données.");
        }
           }
        
     
}
