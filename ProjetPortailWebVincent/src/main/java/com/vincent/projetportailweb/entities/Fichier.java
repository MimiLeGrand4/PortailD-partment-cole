package com.vincent.projetportailweb.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_fichier")
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nom;
    @Column(length = 100)
    private String contenu;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Utilisateur user_id;

    public Fichier() {
    }

    public Fichier(String nom, String contenu,Utilisateur user_id) {
        this.nom = nom;
        this.contenu = contenu;
        this.user_id = user_id;
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

    public Utilisateur getUser() {
        return user_id;
    }

    public void setUser_id(Utilisateur user_id) {
        this.user_id = user_id;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %-10s  %-30s  %-30s","Id","Nom","Contenu","Utilisateur");
        message+="\n --------------------------------------------------------------------------------";
        return message;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fichier fichier = (Fichier) o;
        return Objects.equals(id, fichier.id) && Objects.equals(nom, fichier.nom) && Objects.equals(contenu, fichier.contenu)&& Objects.equals(user_id, fichier.user_id);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    @Override
    public String toString() {
        return "Fichier{" +
                "fichier_id=" + id +
                ", nom='" + nom + '\'' +
                ", contenu='" + contenu + '\'' +
                ", utilisateur='" + user_id + '\'' +
                '}';
    }

}