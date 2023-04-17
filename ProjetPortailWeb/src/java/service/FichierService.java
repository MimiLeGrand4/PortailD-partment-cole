/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.ralphchg.portaildepartementinformatique.model.dao.FichierImplDao;
import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import java.util.List;

/**
 *
 * @author Vince
 */
public class FichierService {
     private List<Fichier> listeFichiers;
     Fichier fichier = null;
     boolean retour =false;
     FichierImplDao dao = new FichierImplDao();
    
    
     public List<Fichier> afficherFichiers() {
        listeFichiers = dao.findAllFichiers();
        return listeFichiers;
    }
    
     public boolean supprimerNotesDeCours(int id){
           if(dao.deleteNotesDeCours(id)){
            retour = true;
          }
    return retour;
}
    
        public boolean ajouterNotesDeCours(Fichier fichier) {
        
    
        if ( dao.ajouterNotesDeCours(fichier)) {
             retour = true;
        }
    
       return retour;
    }

    public boolean modifierUnUtilisateur( Fichier fichier){
       if ( dao.updateNotesDeCours(fichier)) {
                 retour = true;
            }

           return retour;
    }


    public Fichier chercherFichierParId(int id) {
           fichier = dao.findFichierById(id);
            return fichier;
        }
    }
