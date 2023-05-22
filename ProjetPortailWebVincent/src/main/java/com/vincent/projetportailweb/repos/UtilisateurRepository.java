package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Vous pouvez ajouter des méthodes supplémentaires spécifiques à votre cas d'utilisation
    // Si nécessaire, utilisez les annotations de requête comme @Query pour les requêtes personnalisées
    Utilisateur findByEmail(String email);
}
