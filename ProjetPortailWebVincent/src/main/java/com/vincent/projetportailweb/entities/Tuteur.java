package com.vincent.projetportailweb.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_tuteur")
public class Tuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Nom de la colonne correspondant au champ user_id
    private int id;

    @Column(name = "cours")
    private String cours;
    @Column(name = "description")
    private String description;
    @Column(name = "type_rencontre")
    private String typeRencontre;
    @Column(name = "disponibilites")
    private String disponibilites;
    @Column(name = "nomTuteur")
    private String tuteur;
    // Constructeur
    public Tuteur(String cours, String description, String typeRencontre, String disponibilites, String tuteur) {
        this.cours = cours;
        this.description = description;
        this.typeRencontre = typeRencontre;
        this.disponibilites = disponibilites;
        this.tuteur = tuteur;
    }

    public Tuteur() {

    }

    // Getters
    public String getCours() {
        return this.cours;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTypeRencontre() {
        return this.typeRencontre;
    }

    public String getDisponibilites() {
        return this.disponibilites;
    }

    public String getTuteur() {
        return this.tuteur;
    }

    // Setters
    public void setCours(String cours) {
        this.cours = cours;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeRencontre(String typeRencontre) {
        this.typeRencontre = typeRencontre;
    }

    public void setDisponibilites(String disponibilites) {
        this.disponibilites = disponibilites;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
