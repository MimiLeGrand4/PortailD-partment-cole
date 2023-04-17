/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
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


public class UtilisateurImplDao implements UtilisateurDao {

    private static final String SQL_SELECT_ROLE = "select * from roles ";
    private static final String SQL_SELECT_Project = "select * from projets";
    private static final String SQL_SELECT_ROLE_PAR_NOM_ROLE = "select * from roles where nom = ? ";
    private static final String SQL_SELECT_UTILSATEURS_PAR_NOM_ROLE = "select * from roles, utilisateurs where roles.nom = ?";
    private static final String SQL_SELECT_UTILISATEUR_PAR_NOM_ROLE = "select * from roles,utilisateurs where roles.nom = ?";
    private static final String SQL_INSERT_UTILISATEUR = "insert into utilisateurs(email,active,nom,prenom,password, photo) value(?,?,?,?,?,?)";
    private static final String SQL_INSERT_ROLE = "insert into roles(nom, description) value(?,?)";
    private static final String SQL_INSERT_UTILISATEUR_ROLE = "insert into utilisateurs_roles(utilisateur_id,role_id) value(?,?)";
    private static final String SQL_UPDATE = "update utilisateurs set email =?, active =?,password = ? where id = ?";


    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nom, prenom from utilisateurs where email=? and password=?";
    private static final String SQL_DESACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 0";
    private static final String SQL_ACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 1";
   
    //Adaptation des sqls avec notre BD
    private static final String SQL_SELECT_PAR_ID = "select * from tbl_user where user_id = ?";
    private static final String SQL_SELECT_UTILISATEURS="select * from tbl_user";
    private static final String SQL_SELECT_PAR_NOM = "SELECT * FROM tbl_user WHERE nom = ?";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM tbl_user WHERE email = ?";
   //Admin privileges
    
    private static final String SQL_AJOUTER = "INSERT INTO tbl_user (tuteur, nom, prenom, passwd, accountType_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_ETUDIANT="UPDATE tbl_user SET nom = ? , prenom=?, passwd=? WHERE user_id=? AND accountType_id=2";
    private static final String SQL_UPDATE_PROF="UPDATE tbl_user SET nom=?, prenom=?, passwd=? WHERE user_id=? AND accountType_id=3";

    
    //Delete un utilisateur au complet
    private static final String SQL_Delete1 = "DELETE FROM tbl_invite WHERE user_id = ?";
    private static final String SQL_Delete2 = "DELETE FROM tbl_evaluation WHERE user_id = ?";
    private static final String SQL_Delete3 = "DELETE FROM tbl_fichierPost WHERE post_id IN (SELECT post_id FROM tbl_post WHERE user_id = ?)";
    private static final String SQL_Delete4 = "DELETE FROM tbl_post WHERE user_id = ?";
    private static final String SQL_Delete5 = "DELETE FROM tbl_projet WHERE user_id = ?";
    private static final String SQL_Delete6 = "DELETE FROM tbl_user WHERE user_id = ?";



    @Override
    public boolean ajouterEtudiant(Utilisateur utilisateur){
          boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_AJOUTER);

            //ps.setString(1, utilisateur.getEmail());
                  ps.setBoolean(1,false);
                  ps.setString(2, utilisateur.getNom());
                  ps.setString(3, utilisateur.getPrenom());
                 ps.setString(4, utilisateur.getPassword());
                 ps.setInt(5, 2); //accounType_id = 2 pour etudiant

            //ps.setString(6, utilisateur.getPhoto());
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
    public boolean updateEtudiant(Utilisateur utilisateur) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_ETUDIANT);
                 ps.setString(1, utilisateur.getNom());
                  ps.setString(2, utilisateur.getPrenom());
                  ps.setString(3, utilisateur.getPassword());
                     ps.setInt(4, utilisateur.getId());

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
        public boolean delete(int id) {
            boolean retour = false;
            int nbLigne = 0;

            try {
                Connection conn = ConnexionBD.getConnection();

                PreparedStatement ps1 = conn.prepareStatement(SQL_Delete1);
                PreparedStatement ps2 = conn.prepareStatement(SQL_Delete2);
                PreparedStatement ps3 = conn.prepareStatement(SQL_Delete3);
                PreparedStatement ps4 = conn.prepareStatement(SQL_Delete4);
                PreparedStatement ps5 = conn.prepareStatement(SQL_Delete5);
                PreparedStatement ps6 = conn.prepareStatement(SQL_Delete6);

                ps1.setInt(1, id);
                ps2.setInt(1, id);
                ps3.setInt(1, id);
                ps4.setInt(1, id);
                ps5.setInt(1, id);
                ps6.setInt(1, id);

                nbLigne += ps1.executeUpdate();
                nbLigne += ps2.executeUpdate();
                nbLigne += ps3.executeUpdate();
                nbLigne += ps4.executeUpdate();
                nbLigne += ps5.executeUpdate();
                nbLigne += ps6.executeUpdate();

                retour = nbLigne > 0;

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnexionBD.closeConnection();
            }

            return retour;
        }


    @Override
    public boolean ajouterProfesseur(Utilisateur utilisateur){
           boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_AJOUTER);

            //ps.setString(1, utilisateur.getEmail());
                  ps.setBoolean(1,false);
                  ps.setString(2, utilisateur.getNom());
                  ps.setString(3, utilisateur.getPrenom());
                 ps.setString(4, utilisateur.getPassword());
                 ps.setInt(5, 3); //accountType_id = 3 pour prof

            //ps.setString(6, utilisateur.getPhoto());
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
    public boolean updateProfesseur(Utilisateur utilisateur) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PROF);
                 ps.setString(1, utilisateur.getNom());
                  ps.setString(2, utilisateur.getPrenom());
                  ps.setString(3, utilisateur.getPassword());
                     ps.setInt(4, utilisateur.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
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
    public List<Utilisateur> findAll() {
        List<Utilisateur> listeUtilisateur = null;
        try {
            
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEURS);
            ResultSet result = ps.executeQuery();
            listeUtilisateur = new ArrayList();
            while(result.next()){
                Utilisateur utilisateur = new Utilisateur();
                 utilisateur.setId(result.getInt("user_id"));
                 utilisateur.setTuteur(result.getBoolean("tuteur"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPassword(result.getString("passwd"));
                utilisateur.setAccountType_id(result.getInt("accountType_id"));
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

 
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);

            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                utilisateur = new Utilisateur();
                  utilisateur.setId(result.getInt("user_id"));
                 utilisateur.setTuteur(result.getBoolean("tuteur"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPassword(result.getString("passwd"));
                utilisateur.setAccountType_id(result.getInt("accountType_id"));

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
                utilisateur.setTuteur(result.getBoolean("active"));
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
                utilisateur.setTuteur(result.getBoolean("active"));
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
    public boolean create(Utilisateur utilisateur) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_UTILISATEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isTuteur());
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
            ps.setBoolean(2, utilisateur.isTuteur());
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
            ps.setBoolean(2, utilisateur.isTuteur());

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
