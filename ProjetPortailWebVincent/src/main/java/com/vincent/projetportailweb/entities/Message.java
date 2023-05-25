package com.vincent.projetportailweb.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;



    public Message() {
        // Constructeur par défaut
    }
    public Message(String contenu) {
        this.contenu = contenu;
        this.dateCreation = LocalDateTime.now();
    }


    public Message(String contenu, LocalDateTime dateCreation) {
        this.contenu = contenu;
        this.dateCreation = dateCreation;
    }

    public Message(String contenu, LocalDateTime dateCreation, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Autres méthodes ou attributs si nécessaires
}
