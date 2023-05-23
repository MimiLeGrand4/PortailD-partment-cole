package com.vincent.projetportailweb.service;


import com.vincent.projetportailweb.entities.AccountType;
import com.vincent.projetportailweb.entities.Fichier;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.FichierRepository;
import com.vincent.projetportailweb.repos.RoleRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
public class UtilisateurService {

    public List<Utilisateur> afficherUtilisateurs(){
        return ( List<Utilisateur>)  repo.findAll();
    }

    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private RoleRepository roleRepos;

    private FichierRepository noteRepos;


    public List<AccountType> afficherRoles(){

        return ( List<AccountType>)  roleRepos.findAll();
    }
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepos = roleRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(UtilisateurService.class);
    public void enregistrerUtilisateur(Utilisateur utilisateur) {
        logger.info("Enregistrement de l'utilisateur : {}", utilisateur);

        // Récupérer le type de compte à partir de l'ID sélectionné dans le formulaire
        AccountType accountType = roleRepos.findById(utilisateur.getAccountType().getId()).orElse(null);
        utilisateur.setAccountType(accountType);

        // Ajoutez ici la logique pour enregistrer l'utilisateur dans la base de données
        repo.save(utilisateur);

        logger.info("Utilisateur enregistré avec succès");
    }

    public Utilisateur validateUser(String email, String password) {
        Utilisateur user = repo.findByEmail(email);
        if (user != null && password.equals(user.getPasswd())) {
            return user;
        }
        return null;
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
        return true;
    }
    public Utilisateur get(Integer id) throws UtilisateurNotFoundException  {
        try{
            return  repo.findById(id).get();
        }catch (NoSuchElementException exception){
            throw  new UtilisateurNotFoundException("On ne peut pas trouver un utilisateur avec l'id" + id);
        }

    }

}
