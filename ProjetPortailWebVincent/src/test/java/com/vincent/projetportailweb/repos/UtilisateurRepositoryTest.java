package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Role;
import com.vincent.projetportailweb.entities.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUtilisateur(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        Utilisateur userKarim = new Utilisateur("Alain", "Karim", "karim@gmail.com", "karim123");
        userKarim.ajouter(roleAdmin);

        Utilisateur savedUser = repo.save(userKarim);

        assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    public void testCreateNewUtilisateurAvecDeuxRoles() {
        Utilisateur userRavi = new Utilisateur("Pierre", "Jean", "jean@gmail.com", "Jean123");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(4);

        userRavi.ajouter(roleEditor);
        userRavi.ajouter(roleAssistant);

        Utilisateur savedUser = repo.save(userRavi);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListTousUtilisateur() {
        Iterable<Utilisateur> listUsers = repo.findAll();
        listUsers.forEach(utilisateur -> System.out.println(utilisateur));
        /*
        for(Utilisateur utilisateur :listUsers){

            System.out.println(utilisateur);
        }
        */

    }
    @Test
    public void testGetUtilisateurById() {
        Utilisateur utilisateur = repo.findById(1).get();
        System.out.println(utilisateur);
        assertThat(utilisateur).isNotNull();
    }

    @Test
    public void testUpdateUtilisateurDetails() {
        Utilisateur utilisateur = repo.findById(1).get();
        utilisateur.setActive(true);
        utilisateur.setEmail("alain@gmail.com");
        utilisateur.setPhoto("photo1.jpg");

        repo.save(utilisateur);
    }

    @Test
    public void testUpdateUtilisateurRoles() {
        Utilisateur userRavi = repo.findById(3).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userRavi.getRoles().remove(roleEditor);
        userRavi.ajouter(roleSalesperson);

        repo.save(userRavi);
    }

    @Test
    public void testDeleteUtilisateur() {
        Integer userId = 3;
        repo.deleteById(userId);

    }

    @Test
    public void testGetUserByEmail() {
        //On passe en paramètre un email existant
        String email = "alain@gmail.com";
        //On retourne l'utilisateur avec qui a l'email
        Utilisateur user = repo.getUtilisateurByEmail(email);
        System.out.println(user);
        //On vérifie si c'est différent de null
        assertThat(user).isNotNull();
    }

    @Test
    public void testGetUserByEmailAndPassword() {
        //On passe en paramètre un email existant
        String email = "alain@gmail.com";
        String password = "karim123";
        //On retourne l'utilisateur avec qui a l'email et le paasword
        Utilisateur user = repo.getUtilisateurByEmailAndPassword(email,password);
        System.out.println(user.toString());
        //On vérifie si c'est différent de null
        assertThat(user).isNotNull();
    }

    @Test
    public void testCountById() {
        Integer id = 1;
        Long countById = repo.countById(id);
        System.out.println(countById);

        assertThat(countById).isNotNull().isGreaterThan(0);
    }

    @Test
    public void testDisableUser() {
        Integer id = 1;
        repo.updateActiveStatus(id, false);

    }

    @Test
    public void testEnableUser() {
        Integer id = 1;
        repo.updateActiveStatus(id, true);

    }

    @Test
    public void testListTousUtilisateurParRole() {
        String admin = "Admin";
        Iterable<Utilisateur> listUsers = repo.findAllByNameRole(admin);
        listUsers.forEach(utilisateur -> System.out.println(utilisateur));
    }

}