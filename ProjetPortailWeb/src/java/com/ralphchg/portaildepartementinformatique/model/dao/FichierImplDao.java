/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import com.ralphchg.portaildepartementinformatique.model.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vince
 */
public class FichierImplDao implements FichierDao{
      private static final String SQL_Ajouter_Notes_de_Cours="INSERT INTO tbl_fichier (fichier_nom, contenu) VALUES (? ,?)";
    private static final String SQL_Update_Notes_de_Cours="UPDATE tbl_fichier SET fichier_nom=?, contenu=? WHERE fichier_id=?";
    private static final String SQL_Delete_Notes_de_Cours="DELETE FROM tbl_fichier WHERE fichier_id = ?";
    private static final String SQL_SELECT_FICHIER_PAR_ID = "select * from tbl_fichier where fichier_id = ?";
    private static final String SQL_SELECT_FICHIERS="select * from tbl_fichier";
    
    
    
        @Override
    public Fichier findFichierById(int id) {
         Fichier fichier= null;
        try {

 
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_FICHIER_PAR_ID);

            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                fichier = new Fichier();
                fichier.setId(result.getInt("fichier_id"));
                fichier.setNom(result.getString("fichier_nom"));
                fichier.setContenu("contenu");

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return fichier;
        
    }
      @Override
    public boolean deleteNotesDeCours(int fichier_id) {
         boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_Delete_Notes_de_Cours);

            ps.setInt(1, fichier_id);
           nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    


        @Override
    public List<Fichier> findAllFichiers() {
        List<Fichier> listeFichier = null;
        try {
            
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_FICHIERS);
            ResultSet result = ps.executeQuery();
            listeFichier = new ArrayList();
            while(result.next()){
                 Fichier fichier = new Fichier();
                 fichier.setId(result.getInt("fichier_id"));
                 fichier.setNom(result.getString("fichier_nom"));
                 fichier.setContenu(result.getString("contenu"));
                 listeFichier.add(fichier);

               
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeFichier;
    }
    
    
        @Override
    public boolean ajouterNotesDeCours(Fichier fichier){
             boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_Ajouter_Notes_de_Cours);
          ps.setString(1, fichier.getNom());
            ps.setString(2, fichier.getContenu());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
         
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        
        return retour;
}
    
    @Override
    public boolean updateNotesDeCours(Fichier fichier) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_Update_Notes_de_Cours);
                 ps.setString(1, fichier.getNom());
                  ps.setString(2, fichier.getContenu());
                  ps.setInt(3, fichier.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {

            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }


        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }


}
