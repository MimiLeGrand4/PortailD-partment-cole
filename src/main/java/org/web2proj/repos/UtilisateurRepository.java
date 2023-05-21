package org.web2proj.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.web2proj.entities.Utilisateur;

import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

    @Query("SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    public Utilisateur getUtilisateurByPrenom(@Param("prenom") String prenom);

    @Query("SELECT u FROM Utilisateur u JOIN u.roles r WHERE r.nom = ?1")
    List<Utilisateur> findAll(String keyword);
}
