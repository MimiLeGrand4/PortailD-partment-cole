package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

<<<<<<< HEAD
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Vous pouvez ajouter des méthodes supplémentaires spécifiques à votre cas d'utilisation
    // Si nécessaire, utilisez les annotations de requête comme @Query pour les requêtes personnalisées
    Utilisateur findByEmail(String email);
=======
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

    @Modifying
    @Query("DELETE FROM Evaluation WHERE user_id = :user_id")
    public void deleteEvaluationByUserId(@Param("user_id") Utilisateur utilisateur);

    @Modifying
    @Query("DELETE FROM Fichier WHERE user_id = :user_id")
    public void deleteFichierByUserId(@Param("user_id") Utilisateur utilisateur);

    @Modifying
    @Query("DELETE FROM Projet WHERE user_id = :user_id")
    public void deleteProjetByUserId(@Param("user_id") Utilisateur utilisateur);

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Utilisateur getUtilisateurByEmail(@Param("email") String email);



    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email and u.passwd=:password")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Utilisateur getUtilisateurByEmailAndPassword(@Param("email") String email,@Param("password") String password);

    //Cette méthode suit la convention spécifié par Spring Data JPA
    public Long countById(Integer id);
    // 2 pour le 2 eme parametre active et 1 pour le 1er param`tre id


    //Le 1 est l'argument pour premier paramètre qui est le mot clé
    @Query("SELECT u FROM Utilisateur u WHERE u.nom  LIKE %?1% OR u.prenom  LIKE %?1%")
    public List<Utilisateur> findAll(String keyword);


    @Query("SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    public Utilisateur findUtilisateurByNom(@Param("nom") String nom);
    @Query("SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    public Utilisateur getUtilisateurByPrenom(@Param("prenom") String prenom);


>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
}
