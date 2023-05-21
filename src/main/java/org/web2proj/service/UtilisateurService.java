package org.web2proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web2proj.entities.Fichier;
import org.web2proj.entities.Utilisateur;
import org.web2proj.repos.FichierRepository;
import org.web2proj.repos.RoleRepository;
import org.web2proj.repos.UtilisateurRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service

@Transactional
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private RoleRepository roleRepos;
    @Autowired
    private FichierRepository noteRepos;

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        return  repo.save(utilisateur);
    }


    public List<Fichier> afficherNoteDeCours(){

        return ( List<Fichier>)  noteRepos.findAll();
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
