/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.ralphchg.portaildepartementinformatique.model.dao.UtilisateurImplDao;
import com.ralphchg.portaildepartementinformatique.model.entities.Role;
import com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author Vince
 */
public class UtilisateurService {

 private List<Utilisateur> listeUtilisateurs;
     Utilisateur utilisateur = null;
     boolean retour =false;
     UtilisateurImplDao dao = new UtilisateurImplDao();
   List<Role> listRoles=null;

   
   public boolean modifierUnEtudiant(Utilisateur utilisateur){
          if ( dao.updateEtudiant(utilisateur)) {
             retour = true;
        }
       return retour;

   }
   public boolean modifierUnProf(Utilisateur utilisateur){
       if ( dao.updateProfesseur(utilisateur)) {
             retour = true;
        }
       return retour;
   }

   
    public boolean supprimerUnUtilisateur(int id){
           if(dao.delete(id)){
            retour = true;
          }
    return retour;
}
   
   
   public boolean ajouterUnEtudiant(Utilisateur utilisateur){
       if ( dao.ajouterEtudiant(utilisateur)) {
             retour = true;
        }
    
       return retour;
   }
   
   
   public boolean ajouterUnProf(Utilisateur utilisateur){
       if ( dao.ajouterProfesseur(utilisateur)) {
             retour = true;
        }
    
       return retour;
   }
   
    public List<Utilisateur> afficherLesUtilisateurs() {
        listeUtilisateurs = dao.findAll();
        return listeUtilisateurs;
    }
    public List<Role> afficherTypesComptes() {
         listRoles = dao.findAllComptes();
        return listRoles;
    }
   
   
   
       public Utilisateur chercherUtilisateurParNom(String nom) {
       utilisateur = dao.findByName(nom);
        return utilisateur;
    }
   
   
   public Utilisateur chercherUtilisateurParID(int id) {
       utilisateur = dao.findById(id);
        return utilisateur;
    }
   
   
   
   
   
   
   
   
   
   
   




    public Utilisateur chercherUtilisateurParNomRole(String nomRole) {
        utilisateur  = dao.findByNameRole(nomRole);
        return utilisateur;
    }

    public List<Utilisateur> trierUtilisateursParRole(String nomRole) {
         listeUtilisateurs = dao.findAllByNameRole(nomRole);
        return listeUtilisateurs;
    }
    public Utilisateur verifierEmailMotDePasse(String email, String motDePasse) {
          utilisateur = dao.existsByEmailAndPassword(email, motDePasse);
        return utilisateur;
    }


    public boolean ajouterUnUtilisateurUnRole(Utilisateur utilisateur, String nomRole) {
        
    
        if ( dao.create(utilisateur, nomRole)) {
             retour = true;
        }
    
       return retour;
    }

public boolean modifierUnUtilisateur( Utilisateur utilisateur){
   if ( dao.update(utilisateur)) {
             retour = true;
        }
    
       return retour;
}
}
