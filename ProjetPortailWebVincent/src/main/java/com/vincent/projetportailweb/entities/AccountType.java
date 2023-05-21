package com.vincent.projetportailweb.entities;

import javax.persistence.*;
@Entity
    @Table(name = "tbl_accounttype")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "accountType_id")
    private int accountType_id;

    @Column(name = "nom")
    private String nom;

    public int getAccountType_id() {
        return accountType_id;
    }

    public void setAccountType_id(int accountType_id) {
        this.accountType_id = accountType_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}