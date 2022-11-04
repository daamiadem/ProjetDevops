package com.esprit.examen;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.ICategorieProduitService;
import com.esprit.examen.services.IProduitService;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProduitServiceImplTest {
	public static final Logger l =LogManager.getLogger(ProduitControllerTest.class);
	@Autowired
	IProduitService produitService;
	@Test
	public void testAddProduit() {
		List<Produit> produits = produitService.retrieveAllProduits();
		int expected = produits.size();
		Produit p = new Produit();
		p.setIdProduit((long)1);
		p.setCodeProduit("AAA");
		p.setLibelleProduit("C");
		p.setPrix(120);
		p.setDateCreation(new Date());
		p.setDateDerniereModification(new Date());
		Produit savedProduit= produitService.addProduit(p);
		assertEquals(expected+1, produitService.retrieveAllProduits().size());
		assertNotNull(savedProduit.getIdProduit());
		produitService.deleteProduit(savedProduit.getIdProduit());
		} 

}
