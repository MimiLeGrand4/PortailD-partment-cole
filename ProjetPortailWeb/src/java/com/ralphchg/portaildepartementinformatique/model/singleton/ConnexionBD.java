/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.singleton;

import com.ralphchg.portaildepartementinformatique.model.config.ConfigBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ralph
 */
public class ConnexionBD {
        private static Connection conn=null;
    public static Connection getConnection() throws SQLException{
        try {
            // Le chargerment du driver, librairie
            Class.forName(ConfigBD.DRIVER);
                conn =  DriverManager.getConnection(ConfigBD.URL, ConfigBD.USER, ConfigBD.PASSWORD);
                 //   conn.setAutoCommit(false); // désactive l'auto-commit pour permettre les rollbacks

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         //DriverManger est responsable de la selection de la BD et la création de la connexion
         return conn;
    }
    
    public static void closeConnection(){
    
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
