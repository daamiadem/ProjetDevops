package com.esprit.examen;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest
 class CategorieProduitControllerTest {
	private static final Logger l =LogManager.getLogger(CategorieProduitControllerTest.class);
	@Autowired
	ICategorieProduitService categoryService;
	@Test
	void contextLoads() {
	}
	//testing Add method
	@Test
	 void testAddCategory() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		l.info("Je vais tester l'ajout d'une categorie Produit");
		CategorieProduit categ = new CategorieProduit((long) 5,"testcode","test category",null);
		CategorieProduit savedCategory= categoryService.addCategorieProduit(categ);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedCategory.getIdCategorieProduit());
		categoryService.deleteCategorieProduit(savedCategory.getIdCategorieProduit());
		l.info(" categorie Produit ajouté");
		
	} 
	//Testing retrieveCategory
			@Test
			public void testRetrieveCategories() {
				CategorieProduit categ = new CategorieProduit();
				//categ.setIdCategorieProduit((long)6);
				categ.setCodeCategorie("code test");
				categ.setLibelleCategorie("libelle test");
				
				CategorieProduit savedCategory= categoryService.addCategorieProduit(categ);
				CategorieProduit getCategory =categoryService.retrieveCategorieProduit(savedCategory.getIdCategorieProduit());
				assertNotNull(savedCategory.getCodeCategorie());
				assertNotNull(savedCategory.getLibelleCategorie());
				assertEquals(savedCategory.getIdCategorieProduit(),getCategory.getIdCategorieProduit());
				
				categoryService.deleteCategorieProduit(savedCategory.getIdCategorieProduit());
				}
			//Testing updateCategory
			@Test
			public void testUpdateCategory() {
				CategorieProduit categ = new CategorieProduit();
			
				categ.setCodeCategorie("code test");
				categ.setLibelleCategorie("libelle test");
				CategorieProduit savedCategory= categoryService.addCategorieProduit(categ);
				savedCategory.setCodeCategorie("code test");
				categoryService.updateCategorieProduit(savedCategory);
				assertEquals(categ.getCodeCategorie(),savedCategory.getCodeCategorie());
				categoryService.deleteCategorieProduit(savedCategory.getIdCategorieProduit());
				}
			
			//Testing deleteCategory
			@Test
			public void testDeleteCategory() {
				CategorieProduit categ = new CategorieProduit();
				categ.setCodeCategorie("code test");
				categ.setLibelleCategorie("libelle test");
				CategorieProduit savedCategory= categoryService.addCategorieProduit(categ);
				categoryService.deleteCategorieProduit(savedCategory.getIdCategorieProduit());
				assertNotNull(savedCategory.getCodeCategorie());				
			}

}
