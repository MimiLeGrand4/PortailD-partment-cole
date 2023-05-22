package com.vincent.projetportailweb.service;


import com.vincent.projetportailweb.entities.Fichier;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.FichierRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

=======
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UtilisateurService {

    public List<Utilisateur> afficherUtilisateurs(){
        return ( List<Utilisateur>)  repo.findAll();
    }

    @Autowired
    private UtilisateurRepository repo;
    @Autowired
<<<<<<< HEAD
    private RoleRepository roleRepos;
=======
    private FichierRepository noteRepos;
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541


    public List<Role> afficherRoles(){

        return ( List<Role>)  roleRepos.findAll();
    }
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepos = roleRepository;
    }
<<<<<<< HEAD
    public void enregistrerUtilisateur(Utilisateur utilisateur) {
        // Ajoutez ici la logique pour enregistrer l'utilisateur dans la base de données
        repo.save(utilisateur);
    }
    public Utilisateur validateUser(String email, String password) {
        Utilisateur user = repo.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
=======



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
>>>>>>> 3eeb8c379ec6cb05b9a9d0e3ae4ec175c46b1541
        }
        return null;
    }
}
