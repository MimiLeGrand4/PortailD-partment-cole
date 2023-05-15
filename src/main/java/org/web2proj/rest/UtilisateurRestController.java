package org.web2proj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web2proj.service.UtilisateurService;

@RestController
public class UtilisateurRestController {
    @Autowired
    UtilisateurService service;

    @PostMapping("/utilisateurs/check_utilisateur")
    public String verifierDoublonEmail( @Param("prenom") String prenom,@Param("id") Integer id) {

        return service.isPrenomUnique(prenom,id) ? "OK" : "Doublon";
    }
}
