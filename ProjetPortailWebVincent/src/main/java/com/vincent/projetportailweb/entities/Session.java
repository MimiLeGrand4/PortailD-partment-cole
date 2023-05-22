package com.vincent.projetportailweb.entities;

import javax.persistence.*;

@Entity
@Table(name="tbl_session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String nom;

    public Session(){
    }

    public Session(String nom){
        this.nom=nom;
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
}
