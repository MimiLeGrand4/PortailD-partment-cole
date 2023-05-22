package com.vincent.projetportailweb.service;


import com.vincent.projetportailweb.entities.Fichier;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.FichierRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UtilisateurService {

    public List<Utilisateur> afficherUtilisateurs(){
        return ( List<Utilisateur>)  repo.findAll();
    }
/*
    public List<Role> afficherRoles(){
        return ( List<Role>)  roleRepos.findAll();
    }

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        return  repo.save(utilisateur);
    }

    public boolean isEmailUnique(String email) {
        //On cherche un utilisateur à partir de son email
        Utilisateur userByEmail = repo.getUtilisateurByEmail(email);
        //On vérifie l'unicité de l'email
        // quand on crée un nouveau utilisateur
        // S'il l'utilisateur n'existe pas déjà dans la bd avec l'email passé en paramètre
        // cela suppose que l'email n'existe pas
        // Autrement dit la méthode retourne true alors, l'email est unique parce que
        // l'utilisateur est null
        if (userByEmail == null) return true;


        //dans tous les cas on peut creer, editer
        return false;

    }
    */
    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private FichierRepository noteRepos;

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        return repo.save(utilisateur);
    }


    public List<Fichier> afficherNoteDeCours(){

        return ( List<Fichier>)  noteRepos.findAll();
    }



    @Transactional
    public void delete(Integer id) throws UtilisateurNotFoundException {
        Utilisateur utilisateur = repo.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur non trouvé " + id));

        repo.deleteEvaluationByUserId(utilisateur);
        repo.deleteFichierByUserId(utilisateur);
        repo.deleteProjetByUserId(utilisateur);
        repo.delete(utilisateur);
    }

    public boolean isPrenomUnique(String prenom,Integer id) {

        Utilisateur userByPrenom = repo.getUtilisateurByPrenom(prenom);

        if (userByPrenom == null) return true;


        boolean isCreatingNewUser = false;
        if (id == null){
            isCreatingNewUser=true;
        }

        if(isCreatingNewUser){

            if (userByPrenom != null) return false;
        }else{

            if (userByPrenom.getId() != id) {
                return false;
            }
        }

        return true;

    }
}
