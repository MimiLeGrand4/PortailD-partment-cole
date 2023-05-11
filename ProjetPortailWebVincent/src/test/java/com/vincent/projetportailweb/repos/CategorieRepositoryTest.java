package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Categorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategorieRepositoryTest {
    @Autowired
    private CategorieRepository repo;
    @Test
    public void testCreateFirstRole() {
        Categorie categorieFromages = new Categorie( "FROMAGES");
        Categorie savedCategorie = repo.save(categorieFromages);
        //pour verifier si l'objet role est bien sauve dans la database
        assertThat(savedCategorie.getId()).isGreaterThan(0);

    }

    @Test
    public void testCreateRestRoles() {
        Categorie categoriePains = new Categorie( "PAINS");
        Categorie categorieLegumes= new Categorie( "LEGUMES");
        Categorie categorieViandes = new Categorie( "VIANDES");
        List<Categorie> listCategories = new ArrayList();
        listCategories.add(categorieViandes);
        listCategories.add(categorieLegumes);
        listCategories.add(categoriePains);
        repo.saveAll(listCategories);

    }
}