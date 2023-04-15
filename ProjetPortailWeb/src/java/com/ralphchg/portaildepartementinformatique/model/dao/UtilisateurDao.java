/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import com.ralphchg.portaildepartementinformatique.model.entities.Role;
import com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur;
import java.util.List;


public interface UtilisateurDao {


    Utilisateur findByName(String nom);

    Utilisateur findByEmail(String email);

    Utilisateur findByNameRole(String nomRole);

    List<Role> findAllRole();

    List<Utilisateur> findAllByNameRole(String nomRole);

    Utilisateur existsByEmailAndPassword(String email, String motDePasse);
    boolean create(Utilisateur utilisateur);

    boolean create(Utilisateur utilisateur, String nomRol);

    boolean update(Utilisateur utilisateur);
    
    //Adapter ou Creer Par Vincent
    
    List<Fichier> findAllFichiers();
    List<Utilisateur> findAll();

    Utilisateur findById(int id);
    
    boolean ajouterEtudiant(Utilisateur utilisateur);
    boolean ajouterProfesseur(Utilisateur utilisateur);
    boolean ajouterNotesDeCours(Fichier ficher);
    boolean updateEtudiant(Utilisateur utilisateur);
    boolean updateProfesseur(Utilisateur utilisateur);
    boolean delete(int id);
    
    
   
}
