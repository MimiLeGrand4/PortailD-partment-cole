package org.web2proj.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(length = 64, nullable = false)
    private String nom;
    @Column(length = 64, nullable = false)
    private String prenom;

    @Column(length = 64, nullable = false)
    private String accountType_id;
    @Column(length = 64, nullable = false)
    private String passwd;
    @Column(length = 128, nullable = false, unique = true)
    private String tuteur;

    @ManyToMany
    @JoinTable(
            name = "utilisateurs_notes",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )


    private Set<Fichier> fichiers = new HashSet();


    @ManyToMany
    @JoinTable(
            name = "utilisateurs_roles",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet();

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String accountType_id, String passwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.accountType_id = accountType_id;
        this.passwd = passwd;
    }
    public Utilisateur(int user_id, String nom, String prenom, String accountType_id, String passwd, String tuteur) {
        this.user_id = user_id;
        this.nom = nom;
        this.prenom = prenom;
        this.accountType_id = accountType_id;
        this.passwd = passwd;
        this.tuteur = tuteur;
        roles = new HashSet();
        fichiers = new HashSet();
    }

    public Integer getId() {
        return user_id;
    }

    public void setId(Integer id) {
        this.user_id = id;
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

    public String getAccountType_id() {
        return accountType_id;
    }

    public void setAccountType_id(String accountType_id) {
        this.accountType_id = accountType_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void ajouter(Role role){
        this.roles.add(role);
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s", "Id", "Email", "Active", "Nom", "Prenom",
                "Password", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.user_id,this.nom, this.prenom,this.accountType_id,this.passwd,
                this.tuteur);
        return message;
    }
}
