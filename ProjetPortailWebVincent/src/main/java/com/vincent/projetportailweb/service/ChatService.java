package com.vincent.projetportailweb.service;

import com.vincent.projetportailweb.entities.Message;
import com.vincent.projetportailweb.entities.Utilisateur;
import com.vincent.projetportailweb.repos.UtilisateurRepository;
import com.vincent.projetportailweb.repos.MessageRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Message> getMessagesWithUser() {
        List<Message> messages = messageRepository.findAll(); // Récupérer tous les messages depuis la base de données

        // Associer chaque message à l'utilisateur correspondant
        for (Message message : messages) {
            if (message.getUtilisateur() == null) {
                // Si l'utilisateur est null, associez le message à l'utilisateur avec l'ID 2
                Utilisateur utilisateur = utilisateurRepository.findById(2).orElse(null);
                message.setUtilisateur(utilisateur);
                messageRepository.save(message); // Sauvegarder le message avec le nouvel utilisateur
            } else {
                Utilisateur utilisateur = utilisateurRepository.findById(message.getUtilisateur().getId()).orElse(null);
                message.setUtilisateur(utilisateur);
            }
        }

        return messages;
    }

    public void envoyerMessage(Utilisateur utilisateur, String contenu) {
        // Vérifier si l'utilisateur existe en base de données
        if (utilisateur == null ) {
            // Si l'utilisateur est null ou s'il n'a pas d'ID, cela signifie qu'il n'est pas enregistré en base de données
            // Enregistrez d'abord l'utilisateur en base de données
            utilisateur = utilisateurRepository.save(utilisateur);
        }

        // Créer un nouveau message avec l'utilisateur associé
        Message message = new Message(contenu);
        message.setUtilisateur(utilisateur);

        // Enregistrer le message dans la base de données
        messageRepository.save(message);
    }




    // Autres méthodes du service...
}

