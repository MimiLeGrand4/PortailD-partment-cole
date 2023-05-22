package com.vincent.projetportailweb.entities;

import com.vincent.projetportailweb.entities.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer id;

    /*  //@NotNull et nullable = false
     *ils sont utilisés sur l'entité JPA, les deux empêchent essentiellement
     * de stocker des valeurs nulles dans la base de données sous-jacente,
     * il existe des différences significatives entre ces deux approches
     */
    @Column(length = 128, nullable = false, unique = true)
    private String email;
    @Column(length = 64, nullable = false)
    private String password;
    @Column(length = 64, nullable = false)
    private String nom;

    @Column(length = 64, nullable = false)
=======
    private int id;

    @Column(length = 255)
    private String email;

    private boolean tuteur;

    @Column(length = 35)
    private String nom;

    @Column(length = 35)
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
    private String prenom;
    @Column(length = 64)

<<<<<<< HEAD
    private String photo;
    private boolean active;

    /*
    HashSet est une collection non ordonnée et ne maintient aucun ordre.
    D'autre part, les éléments en double ne sont pas autorisés dans Hashset.
    Elle s'utilise de la même facon que List et ArrayList
     */
    @ManyToMany
    @JoinTable(
            name = "utilisateurs_roles",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet();

=======
    @Column(length = 99)
    private String passwd;
    @ManyToOne
    @JoinColumn(name ="accounttype_id")
    private AccountType accountType;



    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
    public Utilisateur() {
    }

    public Utilisateur( String nom, String prenom,String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
    public Utilisateur(int id, String email, boolean active, String nom, String prenom, String password, String photo) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.photo = photo;
        roles = new HashSet();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpasswd() {
        return passwd;
    }

    public void setPassword(String password) {
        this.password = password;
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

<<<<<<< HEAD
    public String getPhoto() {
        return photo;
=======
    public void setpasswd(String passwd) {
        this.passwd = passwd;
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

<<<<<<< HEAD
    public boolean isActive() {
        return active;
=======
    public Utilisateur(String nom, String prenom, String email, String passwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
    }

    public void setActive(boolean active) {
        this.active = active;
    }

<<<<<<< HEAD
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void ajouter(Role role){
        this.roles.add(role);
=======
    public Utilisateur(String email, boolean active, String nom, String prenom, String passwd) {
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.passwd = passwd;

    }

    public Utilisateur(int id, String email, boolean active, String nom, String prenom, String passwd) {
        this.id = id;
        this.email = email;
        this.tuteur = active;
        this.nom = nom;
        this.prenom = prenom;
        this.passwd = passwd;

>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s", "Id", "Email", "Active", "Nom", "Prenom",
                "passwd", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
<<<<<<< HEAD
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.email, this.active,this.nom,this.prenom,
                this.password, this.photo);
=======
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.nom, this.prenom,this.accountType,this.passwd,
                this.tuteur);
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
        return message;
    }
}