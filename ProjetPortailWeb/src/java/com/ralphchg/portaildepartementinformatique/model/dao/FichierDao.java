/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ralphchg.portaildepartementinformatique.model.dao;

import com.ralphchg.portaildepartementinformatique.model.entities.Fichier;
import java.util.List;


public interface FichierDao {


         Fichier findFichierById(int id);
         List<Fichier> findAllFichiers();
         boolean ajouterNotesDeCours(Fichier ficher);
         boolean updateNotesDeCours(Fichier fichier);
         boolean deleteNotesDeCours(int fichier_id);
}
