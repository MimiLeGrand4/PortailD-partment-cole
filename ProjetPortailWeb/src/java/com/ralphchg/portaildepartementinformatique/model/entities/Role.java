/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.entities;

import java.io.Serializable;

/**
 *
 * @author ralph
 */
public class Role implements Serializable {
     private int id;
    private String nom;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(String nom) {
        this.nom = nom;
    }

    public Role(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
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


         public String afficherTitreDesColonnes() {
         String message = "";
       message = String.format(" %-10s  %20s","Id","Nom"); 
       message+="\n --------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message += String.format(" %-5d  %15s",this.id,this.nom); 
       return message;
    }
}
