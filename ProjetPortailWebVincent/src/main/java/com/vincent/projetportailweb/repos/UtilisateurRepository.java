package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

/*
    @Query("DELETE FROM tbl_invite WHERE user_id = :userId")
    public void deleteInviteByUserId(@Param("userId") Integer userId);

    @Query("DELETE FROM tbl_evaluation WHERE user_id = :userId")
    public void deleteEvaluationByUserId(@Param("userId") Integer userId);

    @Query("DELETE FROM tbl_fichierPost WHERE post_id IN (SELECT post_id FROM tbl_post WHERE user_id = :userId)")
    public void deleteFichierPostByUserId(@Param("userId") Integer userId);

    @Query("DELETE FROM tbl_post WHERE id = :userId")
    public void deletePostByUserId(@Param("userId") Integer userId);
*/
    @Query("DELETE FROM Projet WHERE id = :userId")
    public void deleteProjetByUserId(@Param("userId") Integer userId);

    @Query("DELETE FROM Utilisateur WHERE id = :userId")
    public void deleteUserById(@Param("userId") Integer userId);

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Utilisateur getUtilisateurByEmail(@Param("email") String email);



    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email and u.password=:password")
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
    public org.web2proj.entities.Utilisateur getUtilisateurByPrenom(@Param("prenom") String prenom);


}
