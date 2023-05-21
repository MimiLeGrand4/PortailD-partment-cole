package org.web2proj.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_acces")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer user_id;

    @Column(length = 40, nullable = false, unique = true)

    private String nom;
    @Column(length = 150, nullable = false)

    private String description;

    public Role() {
    }

    public Role(Integer id) {
        this.user_id = id;
    }

    public Integer getId() {
        return user_id;
    }

    public Role(String nom) {
        this.nom = nom;
    }

    public Role(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    public Role(int user_id, String nom, String description) {
        this.user_id = user_id;
        this.nom = nom;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        // return "Role{" + "nom=" + nom + '}';
        return this.nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.user_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }
}
