package com.vincent.projetportailweb.service;

import com.vincent.projetportailweb.entities.Projet;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.ProjetRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
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

    private final ResourceLoader resourceLoader;


    @Autowired
    public ProjetService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }




    public Resource load(String filename) {
        try {
            Resource resource = resourceLoader.getResource("classpath:/projets/" + filename);

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Projet uploadImage(MultipartFile file) throws IOException {
        Projet fichier = new Projet();
        fichier.setNom(file.getOriginalFilename());
        fichier.setData(file.getBytes());
        return repo.save(fichier);
    }

}

