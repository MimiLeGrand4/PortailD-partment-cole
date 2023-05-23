package com.vincent.projetportailweb.service;

import com.vincent.projetportailweb.entities.Projet;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.ProjetRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProjetService {
    @Autowired
    private ProjetRepository repo;
    @Autowired
    private UtilisateurRepository repoUser;

    public List<Projet> afficherProjet(){return (List<Projet>) repo.findAll();}

    public List<Projet> afficherProjet(String keyword){
        if (keyword != null) {
        return repo.findAll(keyword);
    }

        return  null;
    }

    public List<Utilisateur> afficherUtilisateurs(){
        return ( List<Utilisateur>)  repoUser.findAll();
    }


    public List<Projet> afficherMesProjet(int keyword){
        return repo.findProjetById(keyword);
    }
}

