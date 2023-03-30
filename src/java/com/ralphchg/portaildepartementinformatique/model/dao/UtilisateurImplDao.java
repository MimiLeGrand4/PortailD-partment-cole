/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Projet;
import com.ralphchg.portaildepartementinformatique.model.entities.Role;
import com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur;
import com.ralphchg.portaildepartementinformatique.model.singleton.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ralph
 */
public class UtilisateurImplDao implements UtilisateurDao {
    private static final String SQL_SELECT_UTILISATEURS="select * from utilisateurs";
    private static final String SQL_SELECT_PAR_ID = "select * from utilisateurs where id = ?";
    private static final String SQL_SELECT_PAR_NOM = "select * from utilisateurs where nom = ?";
    private static final String SQL_SELECT_PAR_EMAIL = "select * from utilisateurs where email = ?";
    private static final String SQL_SELECT_ROLE = "select * from roles ";
    private static final String SQL_SELECT_Project = "select * from projets";
    private static final String SQL_SELECT_ROLE_PAR_NOM_ROLE = "select * from roles where nom = ? ";
    private static final String SQL_SELECT_UTILSATEURS_PAR_NOM_ROLE = "select * from roles, utilisateurs where roles.nom = ?";
    private static final String SQL_SELECT_UTILISATEUR_PAR_NOM_ROLE = "select * from roles,utilisateurs where roles.nom = ?";
    private static final String SQL_INSERT_UTILISATEUR = "insert into utilisateurs(email,active,nom,prenom,password, photo) value(?,?,?,?,?,?)";
    private static final String SQL_INSERT_ROLE = "insert into roles(nom, description) value(?,?)";
    private static final String SQL_INSERT_UTILISATEUR_ROLE = "insert into utilisateurs_roles(utilisateur_id,role_id) value(?,?)";
    private static final String SQL_UPDATE = "update utilisateurs set email =?, active =?,password = ? where id = ?";

    //"DELETE FROM intermediary_table WHERE parent_id = ?");
    private static final String SQL_DELETE_UTILISATEUR_ROLE_ID = "delete from utilisateurs_roles where utilisateur_id = ?";
    //"DELETE FROM child_table1 WHERE id IN (SELECT child_id FROM intermediary_table WHERE parent_id = ?)");
    private static final String SQL_DELETE_ROLE_ID = "delete from roles where id IN(select role_id from utilisateurs_roles where utilisateur_id = ?)";
    //"DELETE FROM child_table2 WHERE id IN (SELECT child_id FROM intermediary_table WHERE parent_id = ?)");
    private static final String SQL_DELETE_UTILISATEUR_ID = "delete from utilisateurs where id IN(select utilisateur_id from utilisateurs_roles where role_id = ?)";
    // "DELETE FROM parent_table WHERE id = ?");
    private static final String SQL_DELETE = "delete from utilisateurs where id = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nom, prenom from utilisateurs where email=? and password=?";
    private static final String SQL_DESACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 0";
    private static final String SQL_ACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 1";
    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> listeUtilisateur = null;
        try {
            
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEURS);
            ResultSet result = ps.executeQuery();
            listeUtilisateur = new ArrayList();
            while(result.next()){
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));
                listeUtilisateur.add(utilisateur);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeUtilisateur;
    }

    @Override
    public Utilisateur findById(int id) {
        Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public Utilisateur findByName(String nom) {
         Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_EMAIL);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public Utilisateur findByNameRole(String nomRole) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Role> findAllRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Utilisateur> findAllByNameRole(String nomRole) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Utilisateur existsByEmailAndPassword(String email, String motDePasse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
       boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps;

        try {
            ps1 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_UTILISATEUR_ROLE_ID);
            ps2 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_ROLE_ID);
            ps3 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_UTILISATEUR_ID);

            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);

            // Supprimer les lignes dans la table intermédiaire qui dépendent de la ligne parente
            ps1.setInt(1, id);
            ps1.executeUpdate();
            // Supprimer les lignes enfants dans les deux tables qui dépendent de la ligne parente
            ps2.setInt(1, id);
            ps2.executeUpdate();
            ps3.setInt(1, id);
            ps3.executeUpdate();

            // Supprimer la ligne parente
            ps.setInt(1, id);
            ps.executeUpdate();
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
    public boolean create(Utilisateur utilisateur) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_UTILISATEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getPrenom());

            ps.setString(5, utilisateur.getPassword());
            ps.setString(6, utilisateur.getPhoto());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean create(Utilisateur utilisateur, String nomRol) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        PreparedStatement ps1;
        PreparedStatement ps2;
        Connection conn = null;
        Role role = null;
        Projet projets = null;
        int generatedId =0;
        try {

            // obtenir la connexion à la bd
            conn = ConnexionBD.getConnection();
            ps1 = conn.prepareStatement(SQL_SELECT_ROLE_PAR_NOM_ROLE);
            ps1.setString(1, nomRol);
            ResultSet result = ps1.executeQuery();
       
            while (result.next()) {
                role = new Role();
                role.setId(result.getInt("id"));
                role.setNom(result.getString("nom"));
                utilisateur.ajouter(projets);
                utilisateur.ajouterRole(role);
            }
         
         
            ps = conn.prepareStatement(SQL_INSERT_UTILISATEUR);
            ps2 = conn.prepareStatement(SQL_INSERT_UTILISATEUR_ROLE);
            // désactive l'auto-commit pour permettre les rollbacks
            conn.setAutoCommit(false);

            //   Insérer les données dans la table parente, utilisateurs
         
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getPrenom());

            ps.setString(5, utilisateur.getPassword());
            ps.setString(6, utilisateur.getPhoto());
            nbLigne = ps.executeUpdate();
          
         
         // MySQL, permet d'utiliser la fonction LAST_INSERT_ID() pour récupérer la valeur
         //de la clé primaire générée par la dernière instruction INSERT.
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 generatedId = rs.getInt(1);
                // utilisez generatedId pour insérer dans la table enfant
              }

               System.out.println(" role.getNom() : " + role.getNom());
            System.out.println("role.getId() : " + role.getId());
            System.out.println(" utilisateur.getId() : " + utilisateur.getId());
            System.out.println(" utilisateur.getNom() : " + utilisateur.getNom());
              System.out.println("generatedId : " + generatedId);
            // Insérer les données dans la table intermédiaire utilisateurs_roles
            ps2.setInt(1, generatedId);
            ps2.setInt(2, role.getId());
            nbLigne = ps2.executeUpdate();

              // enregistre les changements en base de données
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // Si une erreur se produit, annuler les changements en effectuant un rollback
            if (conn != null) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true); // réactive l'auto-commit
                    conn.close();

                } catch (SQLException ex) {
                    // Traiter l'exception ici
                    System.out.println("Erreur dans la transaction ");
                }
            }

            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Utilisateur utilisateur) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());

            ps.setString(3, utilisateur.getPassword());

            ps.setInt(4, utilisateur.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    
}
