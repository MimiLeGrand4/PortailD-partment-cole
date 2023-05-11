package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository repo;
    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "Peut tout faire");
        Role savedRole = repo.save(roleAdmin);
        //pour verifier si l'objet role est bien sauve dans la database
        assertThat(savedRole.getId()).isGreaterThan(0);
    }
    @Test
    public void testCreateRestRoles() {
        Role roleSalesperson = new Role("Vendeur", "Gère les prix des produits "
                + "les clients, expédition, commandes et rapport de ventes");

        Role roleEditor = new Role("Editeur", "Gère les categories, les produits ");

        Role roleShipper = new Role("Expéditeur", "Peut voir les products,peut voir les commandes "
                + "et mettre le status de la commande");

        Role roleAssistant = new Role("Assistant", " Gère les questions et Commentaires");
        List<Role> listRoles = new ArrayList();
        listRoles.add(roleSalesperson);
        listRoles.add(roleEditor);
        listRoles.add(roleShipper);
        listRoles.add(roleShipper);
        listRoles.add(roleAssistant);
        repo.saveAll(listRoles);

    }
}