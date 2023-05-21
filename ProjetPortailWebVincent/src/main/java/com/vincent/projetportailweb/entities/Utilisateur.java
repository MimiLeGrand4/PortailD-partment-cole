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

    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "tuteur")
    private boolean tuteur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "passwd")
    private String password;


    @ManyToOne
    @JoinColumn(name = "accountType_id", referencedColumnName = "accountType_id")
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(String email, boolean active, String nom, String prenom, String password) {
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;

    }

    public Utilisateur(int id, String email, boolean active, String nom, String prenom, String password) {
        this.id = id;
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;

    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", tuteur=" + tuteur + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password  + ", accountType_id="  + '}';
    }
}
