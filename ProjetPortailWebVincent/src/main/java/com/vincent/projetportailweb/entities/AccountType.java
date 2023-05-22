package com.vincent.projetportailweb.entities;

import javax.persistence.*;
@Entity
@Table(name = "tbl_accounttype")
public class AccountType {

    @Id
    private int id;

    @Column(length = 30)
    private String nom;

    public int getAccountType_id() {
        return id;
    }

    public void setAccountType_id(int accountType_id) {
        this.id = accountType_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}