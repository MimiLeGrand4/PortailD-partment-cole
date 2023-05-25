package com.vincent.projetportailweb.entities;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Nom de la colonne correspondant au champ user_id
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "tuteur")
    private boolean tuteur;

    @Column(length = 99,name = "passwd")
    private String passwd;

    @ManyToOne
    @JoinColumn(name ="accounttype_id")
    private AccountType accountType;


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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTuteur() {
        return tuteur;
    }

    public void setTuteur(boolean tuteur) {
        this.tuteur = tuteur;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tuteur=" + tuteur +
                ", passwd='" + passwd + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
