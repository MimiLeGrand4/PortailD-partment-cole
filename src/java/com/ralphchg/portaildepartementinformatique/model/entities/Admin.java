/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ralphchg.portaildepartementinformatique.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jerem
 */
public class Admin implements Serializable{
    
    private int id;
    private String nom;
    private String prenom;
    private int role;
    private String password;
    private boolean tuteur;
    
    List<Projet> projets;
    
    public Admin() {
        projets = new ArrayList();

    }
    public Admin(String nom, String prenom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        projets = new ArrayList();
    }
    
    public Admin(String nom, String prenom, String password, int role) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.role=role;
        projets = new ArrayList();
    }

    public Admin(int id,boolean tuteur, String nom, String prenom, String password,int role) {
        this.id = id;
        this.tuteur=tuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.role=role;
        projets = new ArrayList();
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public boolean getTuteur() {
        return tuteur;
    }

    public void setTuteur(boolean tuteur) {
        this.tuteur = tuteur;
    }
    
    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjet(List<Projet> projets) {
        this.projets = projets;
    }

    //ajouter les roles
    public void ajouter(Projet projets) {
        this.projets.add(projets);
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %35s %20s %20s %20s %20s", "Id", "Role", "Tuteur", "Nom", "Prenom",
                "Password");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10s  %35s %20s %20s %20s %20s",this.id,this.role, this.tuteur,this.nom,this.prenom,
                    this.password); 
       return message;
    }
}
