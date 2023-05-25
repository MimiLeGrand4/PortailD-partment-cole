package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Message;
import com.vincent.projetportailweb.entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur, Long> {


}
