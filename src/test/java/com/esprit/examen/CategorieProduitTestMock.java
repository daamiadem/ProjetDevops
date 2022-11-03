package com.esprit.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.services.ICategorieProduitService;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@ExtendWith(MockitoExtension.class)
public class CategorieProduitTestMock {
	@Mock
	CategorieProduitRepository categoryRepository;
	
	@InjectMocks
	ICategorieProduitService categoryService;
	
	@Test
	public void retrieveAllCategoriesTest() {
		when(categoryRepository.findAll()).thenReturn(Stream.of(new CategorieProduit((long)1,"testcode1","testlib1", null), new CategorieProduit((long)2,"testcode2","testlib2", null), 
				new CategorieProduit((long)3,"testcode3","testlib3", null)).collect(Collectors.toList()));
		assertEquals(3,categoryService.retrieveAllCategorieProduits().size());
		
	}
	@Test
	public void addCategoryTest() {
		CategorieProduit categ = new CategorieProduit((long) 5,"testcode","test category",null);
		when(categoryRepository.save(categ)).thenReturn(categ);
		assertEquals(categ,categoryService.addCategorieProduit(categ));
	}
	@Test
	public void retreiveCategoryTest() {
		CategorieProduit categ = new CategorieProduit((long) 5,"testcode","test category",null);
		when(categoryRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categ));
		CategorieProduit categ1= categoryService.retrieveCategorieProduit((long)5);
		Assertions.assertNotNull(categ1);
		
	}
	@Test
	public void deleteCategoryTest() {
		CategorieProduit categ = new CategorieProduit((long) 5,"testcode","test category",null);
		categoryService.deleteCategorieProduit((long)5);
		verify(categoryRepository).deleteById((long)5);
		
	}
	@Test
	public void updatetCategoryTest() {
		CategorieProduit categ = new CategorieProduit((long) 5,"testcode","test category",null);
		Mockito.when(categoryRepository.save(Mockito.any(CategorieProduit.class))).thenReturn(categ);
		categ.setLibelleCategorie("rima");;
		CategorieProduit exisitingCategory= categoryService.updateCategorieProduit(categ) ;
		
		assertNotNull(exisitingCategory);
		assertEquals("rima", categ.getLibelleCategorie());
	}


}
