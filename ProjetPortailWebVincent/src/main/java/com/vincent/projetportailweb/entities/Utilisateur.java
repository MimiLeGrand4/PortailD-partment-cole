package com.vincent.projetportailweb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255)
    private String email;

    private boolean tuteur;

    @Column(length = 35)
    private String nom;

    @Column(length = 35)
    private String prenom;

    @Column(length = 99)
    private String passwd;
    @ManyToOne
    @JoinColumn(name ="accounttype_id")
    private AccountType accountType;



    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public Utilisateur() {
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getpasswd() {
        return passwd;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isTuteur() {
        return tuteur;
    }



    public void setTuteur(boolean tuteur) {
        this.tuteur = tuteur;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Utilisateur(String nom, String prenom, String email, String passwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
    }

    public Utilisateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(String email, boolean active, String nom, String prenom, String passwd) {
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.passwd = passwd;

    }

    public Utilisateur(int id, String email, boolean active, String nom, String prenom, String passwd) {
        this.id = id;
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.passwd = passwd;

    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s", "Id", "Email", "Active", "Nom", "Prenom",
                "passwd", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.nom, this.prenom,this.accountType,this.passwd,
                this.tuteur);
        return message;
    }
}
