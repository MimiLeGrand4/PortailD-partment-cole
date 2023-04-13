/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.entities;

import java.io.Serializable;

/**
 *
 * @author ralph
 */
public class Projet implements Serializable {
     private int id;
    private String nom;
    private String profil;
    private String anneeSession;
    private String description;
    private String urlVideoPresentation;

    

    

    public Projet() {
    }

    public Projet(int id) {
        this.id = id;
    }

    public Projet(String nom, String profil) {
        this.nom = nom;
        this.profil = profil;
    }

    public Projet(int id, String nom, String profil,String anneeSession,String description,String urlVideoPresentation) {
        this.id = id;
        this.nom = nom;
        this.profil = profil;
        this.anneeSession = anneeSession;
        this.description = description;
        this.urlVideoPresentation = urlVideoPresentation;
        
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

    public String getProfil() {
        return profil;
    }
    public String getanneeSession(){
        return anneeSession;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setanneeSession(String anneeSession) {
        this.anneeSession = anneeSession;
    }
    public String getUrlVideoPresentation() {
        return urlVideoPresentation;
    }

    public void setUrlVideoPresentation(String urlVideoPresentation) {
        this.urlVideoPresentation = urlVideoPresentation;
    }

         public String afficherTitreDesColonnes() {
         String message = "";
       message = String.format(" %-10s  %10s  %10s %20s %20s","Id","Nom","profil","anneeSession","UrlVideoPresentation"); 
       message+="\n --------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message += String.format(" %-5d  %15s %30s %15s %30s %15s ",this.id,this.nom, this.profil,this.anneeSession,this.description,this.urlVideoPresentation); 
       return message;
    }
}
