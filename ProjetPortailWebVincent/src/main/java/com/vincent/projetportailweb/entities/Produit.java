package com.vincent.projetportailweb.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;

    @Column(length = 45, nullable = false, unique = true)
    private String nom ;
    //  private BigDecimal  prix;
    private double prix;


    @Column(length = 255)
    private String description ;
    @Column(length = 64)
    private String url_photo;

    private Date derniere_maj ;


    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable=false)
    private Categorie categorie;

//private Categorie categorie when it is a manytoOne relationship otherwise use hashset for manytomany

    public Produit() {
    }

    public Produit(Long id) {
        this.id = id;
    }

    public Produit(String nom, double prix, String description, String urlPhoto, Date derniere_maj) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.url_photo = urlPhoto;
        this.derniere_maj = derniere_maj;

        // listeproduitCommande = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public Date getDerniere_maj() {
        return derniere_maj;
    }

    public void setDerniere_maj(Date derniere_maj) {
        this.derniere_maj = derniere_maj;
    }

    public Categorie getCategories() {
        return categorie;
    }

    public void setCategories(Categorie categories) {
        this.categorie = categories;
    }


    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s", "Id", "Derniere_maj", "Description", "Nom", "Prix",
                "URL_Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15b %15s %15s %15s  ",this.id,this.derniere_maj, this.description,this.nom,this.prix,
                this.url_photo);
        return message;
    }

}
