/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.config;

/**
 *
 * @author ralph
 */
public interface ConfigBD {
    //  Définir l’url de connexion avec le nom de la base donnée
	public final static String URL = "jdbc:mysql://127.0.0.1:3306/bdname?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        //utilisateur de la bd
        public final static String USER ="root";
        //mot de passe de la bd
        public final static String PASSWORD ="root";
         // le driver mysql
        public final static String DRIVER="com.mysql.cj.jdbc.Driver";
}
