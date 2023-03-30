/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ralph
 */
public class Utilisateur implements Serializable {
    private int id;
    private String email;
    private boolean active;
    private String nom;
    private String prenom;
    private String password;
    private String photo;

    List<Projet> projets;
    List<Role> roles;

    

    public Utilisateur() {
        projets = new ArrayList();
        roles = new ArrayList();
    }

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        projets = new ArrayList();
        roles = new ArrayList();
    }

    public Utilisateur(String email, boolean active, String nom, String prenom, String password, String photo) {

        this.email = email;
        this.active = active;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.photo = photo;
        projets = new ArrayList();
        roles = new ArrayList();
    }

    public Utilisateur(int id, String email, boolean active, String nom, String prenom, String password, String photo) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.photo = photo;
        projets = new ArrayList();
        roles = new ArrayList();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjet(List<Projet> projets) {
        this.projets = projets;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    //ajouter les roles
    public void ajouter(Projet projets) {
        this.projets.add(projets);
    }
    public void ajouterRole(Role role) {
        this.roles.add(role);
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s", "Id", "Email", "Active", "Nom", "Prenom",
                "Password", "Photo");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.email, this.active,this.nom,this.prenom,
                    this.password, this.photo); 
       return message;
    }
}