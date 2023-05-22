package com.vincent.projetportailweb.service;

import com.vincent.projetportailweb.entities.Role;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.RoleRepository;
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

    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private RoleRepository roleRepos;


    public List<Role> afficherRoles(){

        return ( List<Role>)  roleRepos.findAll();
    }
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepos = roleRepository;
    }
    public void enregistrerUtilisateur(Utilisateur utilisateur) {
        // Ajoutez ici la logique pour enregistrer l'utilisateur dans la base de données
        repo.save(utilisateur);
    }
    public Utilisateur validateUser(String email, String password) {
        Utilisateur user = repo.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
