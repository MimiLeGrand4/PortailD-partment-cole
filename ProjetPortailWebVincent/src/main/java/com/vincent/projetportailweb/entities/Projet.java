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
    @Column(length = 50)
    private String nom;
    @ManyToOne
    @JoinColumn(name ="profil_id")
    private Profil profil_id;
    @ManyToOne
    @JoinColumn(name ="session_id")
    private Session session_id;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private Utilisateur user_id;

    private Boolean statut;
    private String description;
    @Column(length = 100)
    private String urlVideoPresentation;

    @Column(length = 255)
    private String urlProjetGit;

    public Projet() {
    }

    public Projet(String nom, Profil profil, Session session,Utilisateur user, String description, String urlVideoPresentation, Boolean statut, String urlProjetGit) {
        this.nom = nom;
        this.profil_id = profil;
        this.session_id = session;
        this.user_id=user;
        this.description = description;
        this.urlVideoPresentation = urlVideoPresentation;
        this.statut=statut;
        this.urlProjetGit=urlProjetGit;
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

    public Profil getProfil_id() {
        return profil_id;
    }

    public void setProfil_id(Profil profil_id) {
        this.profil_id = profil_id;
    }

    public Session getSession_id() {
        return session_id;
    }

    public void setSession_id(Session session_id) {
        this.session_id = session_id;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(Utilisateur user_id) {
        this.user_id = user_id;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
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

    public String getUrlProjetGit() {
        return urlProjetGit;
    }

    public void setUrlProjetGit(String urlProjetGit) {
        this.urlProjetGit = urlProjetGit;
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
        message += String.format(" %-5d  %15s %30s %15s %30s %15s ", this.id, this.nom, this.profil_id, this.session_id, this.description, this.urlVideoPresentation);
        return message;
    }
}
