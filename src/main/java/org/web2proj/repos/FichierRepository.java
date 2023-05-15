package org.web2proj.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.web2proj.entities.Fichier;


import java.util.List;

@Repository
public interface FichierRepository extends CrudRepository<Fichier, Integer> {

}



