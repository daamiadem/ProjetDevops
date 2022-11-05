package com.esprit.examen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class ProduitServiceProduitTest {
	@Autowired
	IProduitService produitService;
	
	//testing Add method
	@Test
	public void testAddProduit(){
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
	
	//Testing retrieveProduit
	@Test
	public void testRetrieveProduits() {
		Produit p = new Produit();
		p.setCodeProduit("AAA");
		p.setLibelleProduit("C");
		p.setPrix(120);
		p.setDateCreation(new Date());
		p.setDateDerniereModification(new Date());
		Produit savedProduit= produitService.addProduit(p);
		Produit getProduit= produitService.retrieveProduit(savedProduit.getIdProduit());
		assertNotNull(savedProduit.getCodeProduit());
		assertNotNull(savedProduit.getLibelleProduit());
		assertEquals(savedProduit.getIdProduit(),getProduit.getIdProduit());
		
		produitService.deleteProduit(savedProduit.getIdProduit());
		}
	
	
	//Testing updateProduit
	@Test
	public void testUpdateProduit() {
		Produit p = new Produit();
		p.setCodeProduit("AAA");
		p.setLibelleProduit("C");
		p.setPrix(120);
		p.setDateCreation(new Date());
		p.setDateDerniereModification(new Date());
		Produit savedProduit= produitService.addProduit(p);
		savedProduit.setCodeProduit("EEE");
		produitService.updateProduit(savedProduit);
		assertEquals(p.getCodeProduit(),savedProduit.getCodeProduit());
		produitService.deleteProduit(savedProduit.getIdProduit());
		}
	
	//Testing deleteProduit
	@Test
	public void testDeleteProduit() {
		Produit p = new Produit();
		p.setCodeProduit("AAA");
		p.setLibelleProduit("C");
		p.setPrix(120);
		p.setDateCreation(new Date());
		p.setDateDerniereModification(new Date());
		Produit savedProduit= produitService.addProduit(p);
		produitService.deleteProduit(savedProduit.getIdProduit());
		assertNotNull(savedProduit.getIdProduit());
		
	}
}
