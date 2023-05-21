package com.vincent.projetportailweb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "tbl_projet")
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Projet(int id, String nom, String profil, String anneeSession, String description, String urlVideoPresentation) {
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

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getAnneeSession() {
        return anneeSession;
    }

    public void setAnneeSession(String anneeSession) {
        this.anneeSession = anneeSession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlVideoPresentation() {
        return urlVideoPresentation;
    }

    public void setUrlVideoPresentation(String urlVideoPresentation) {
        this.urlVideoPresentation = urlVideoPresentation;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %10s  %10s %20s %20s", "Id", "Nom", "profil", "anneeSession", "UrlVideoPresentation");
        message += "\n --------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message += String.format(" %-5d  %15s %30s %15s %30s %15s ", this.id, this.nom, this.profil, this.anneeSession, this.description, this.urlVideoPresentation);
        return message;
    }
}
