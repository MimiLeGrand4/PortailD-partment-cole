package com.vincent.projetportailweb.entities;

import javax.persistence.*;

@Entity
@Table(name="tbl_evaluation")

public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private Utilisateur user_id;
    @ManyToOne
    @JoinColumn(name ="projet_id")
    private Projet projet_id;
    private int note;
    private String commentaire;

    public Evaluation() {
    }

    public Evaluation(int id, Utilisateur user_id, Projet projet_id, int note, String commentaire) {
        this.id = id;
        this.user_id = user_id;
        this.projet_id = projet_id;
        this.note = note;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(Utilisateur user_id) {
        this.user_id = user_id;
    }

    public Projet getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(Projet projet_id) {
        this.projet_id = projet_id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
