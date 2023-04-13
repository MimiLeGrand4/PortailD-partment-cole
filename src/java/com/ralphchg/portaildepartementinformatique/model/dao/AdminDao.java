/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Role;
import com.ralphchg.portaildepartementinformatique.model.entities.Admin;
import java.util.List;
/**
 *
 * @author jerem
 */
public interface AdminDao {
    List<Admin> findAll();
    
    Admin findById(int id);
    Admin findByNom(String nom);
    Admin findByPrenom(String prenom);
    Admin findByNameRole(int role);
    Admin findByTuteur(boolean tuteur);
    
    boolean delete(int id);

    boolean create(Admin admin);

    boolean update(Admin admin);
}
