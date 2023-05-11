package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.Categorie;
import com.vincent.projetportailweb.entities.Produit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProduitRepositoryTest {

    @Autowired
    private ProduitRepository repo;
    @Autowired
    private CategorieRepository repoCategorie;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateProduit(){
        Date derniereMaj = new Date();
        Categorie categorieFromage = entityManager.find(Categorie.class, 1);
        Categorie categorieLegumes = entityManager.find(Categorie.class, 2);
        Categorie categoriePains = entityManager.find(Categorie.class, 3);
        Categorie categorieViandes = entityManager.find(Categorie.class, 4);
        Produit fromage1 = new Produit("Fromage1", 1.50 , "yummy", "fromage1.png", derniereMaj);
        Produit legumes1 = new Produit("Legumes1", 6.50 , "OK", "legumes1.png", derniereMaj);
        Produit pains1 = new Produit("Pains1", 9.00 , "NO", "pains1.png", derniereMaj);
        Produit viandes1 = new Produit("viandes1", 15.25 , "BET", "viandes1.png", derniereMaj);

        fromage1.setCategories(categorieFromage);
        legumes1.setCategories(categorieLegumes);
        pains1.setCategories(categoriePains);
        viandes1.setCategories(categorieViandes);

        Produit savedFromage = repo.save(fromage1);
        Produit savedLegume= repo.save(legumes1);
        Produit savedPain = repo.save(pains1);
        Produit savedViande = repo.save(viandes1);


        assertThat(savedFromage.getId()).isGreaterThan(0);
        assertThat(savedLegume.getId()).isGreaterThan(0);
        assertThat(savedPain.getId()).isGreaterThan(0);
        assertThat(savedViande.getId()).isGreaterThan(0);


    }


}