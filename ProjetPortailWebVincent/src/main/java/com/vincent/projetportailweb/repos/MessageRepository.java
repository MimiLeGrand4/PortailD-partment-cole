package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Définissez ici des méthodes spécifiques si nécessaire
}

