package com.esprit.examen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CategorieProduitControllerTest {
	@Autowired
	ICategorieProduitService categoryService;
	
	@Test
	public void testAddCategory() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		//CategorieProduit categ = new CategorieProduit("code123","test category");
		//CategorieProduit savedStock= categoryService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		//assertNotNull(savedStock.getLibelleStock());
		//stockService.deleteStock(savedStock.getIdStock());
		
	} 

}
