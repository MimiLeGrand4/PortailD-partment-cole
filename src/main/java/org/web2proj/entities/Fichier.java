package org.web2proj.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_fichier")
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fichier_id;

    @Column(length = 40, nullable = false, unique = true)

    private String fichier_nom;
    @Column(length = 150, nullable = false)

    private String contenu;

    public Fichier() {
    }

    public Fichier(String fichier_nom, String contenu) {
        this.fichier_nom = fichier_nom;
        this.contenu = contenu;
    }

    public Fichier(Integer fichier_id, String fichier_nom, String contenu) {
        this.fichier_id = fichier_id;
        this.fichier_nom = fichier_nom;
        this.contenu = contenu;
    }

    public Integer getFichier_id() {
        return fichier_id;
    }

    public void setFichier_id(Integer fichier_id) {
        this.fichier_id = fichier_id;
    }

    public String getFichier_nom() {
        return fichier_nom;
    }

    public void setFichier_nom(String fichier_nom) {
        this.fichier_nom = fichier_nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fichier fichier = (Fichier) o;
        return Objects.equals(fichier_id, fichier.fichier_id) && Objects.equals(fichier_nom, fichier.fichier_nom) && Objects.equals(contenu, fichier.contenu);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.fichier_id);
        return hash;
    }

    @Override
    public String toString() {
        return "Fichier{" +
                "fichier_id=" + fichier_id +
                ", nom='" + fichier_nom + '\'' +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}

