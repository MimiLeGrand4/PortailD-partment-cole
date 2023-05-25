package com.vincent.projetportailweb.service;

import com.vincent.projetportailweb.entities.AccountType;
import com.vincent.projetportailweb.entities.Tuteur;
import com.vincent.projetportailweb.repos.TuteurRepository;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoratService {

    @Autowired
    private TuteurRepository repo;

    @Autowired
    public TutoratService(TuteurRepository tuteurRepository) {
        this.repo = tuteurRepository;
    }

    public boolean demanderAide(Tuteur demandeAide) {
        try {
            repo.save(demandeAide);
            return true;
        } catch (Exception e) {
            // log the error
            return false;
        }
    }
    public List<Tuteur> getTuteursDisponibles() {
        return ( List<Tuteur>)  repo.findAll(); // Modifiez cette ligne si vous avez une logique spécifique pour déterminer la disponibilité
    }
}
