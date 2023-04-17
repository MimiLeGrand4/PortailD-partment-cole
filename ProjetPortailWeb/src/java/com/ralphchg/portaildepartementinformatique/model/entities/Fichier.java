/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.entities;

/**
 *
 * @author Vince
 */
public class Fichier {
    private int id;
    private String nom;
    private String contenu;
    


    public Fichier() {
    }

    public Fichier(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getContenu() {
        return contenu;
    }
    
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
             public String afficherTitreDesColonnes() {
         String message = "";
       message = String.format(" %-10s  %-10s  %-30s","Id","Nom","Contenu"); 
       message+="\n --------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message += String.format(" %-5d  %10s %25s ",this.id,this.nom, this.contenu); 
       return message;
    }
}


