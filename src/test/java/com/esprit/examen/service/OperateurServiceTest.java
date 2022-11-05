package com.esprit.examen.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.IOperateurService;

@SpringBootTest
public class OperateurServiceTest {
		
		@Autowired
		IOperateurService operateurService;
		
		//testing Add method
		@Test
		public void testAddOperateur(){
			List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
			int expected = operateurs.size();
			Operateur o = new Operateur();
			o.setNom("Daami");
			o.setPrenom("Adem");
			o.setPassword("passwd");
			Operateur savedOperateur= operateurService.addOperateur(o);
			assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
			assertNotNull(savedOperateur.getNom());
			operateurService.deleteOperateur(savedOperateur.getIdOperateur());
			
		}
		
		//Testing retrieveOperateur
		@Test
		public void testRetrieveOperateurs() {
			Operateur o = new Operateur();
			o.setNom("ad");
			o.setPrenom("da");
			o.setPassword("pass");
			Operateur savedOperateur= operateurService.addOperateur(o);
			Operateur getOperateur= operateurService.retrieveOperateur(savedOperateur.getIdOperateur());
			assertNotNull(savedOperateur.getNom());
			assertNotNull(savedOperateur.getPrenom());
			assertEquals(savedOperateur.getIdOperateur(),getOperateur.getIdOperateur());
			
			operateurService.deleteOperateur(savedOperateur.getIdOperateur());
			}
		
		
		//Testing updateOperateur
		@Test
		public void testUpdateOperateur() {
			Operateur o = new Operateur();
			o.setNom("me");
			o.setPrenom("med");
			o.setPassword("pass");
			Operateur savedOperateur= operateurService.addOperateur(o);
			savedOperateur.setNom("daam");
			operateurService.updateOperateur(savedOperateur);
			assertEquals(o.getNom(),savedOperateur.getNom());
			operateurService.deleteOperateur(savedOperateur.getIdOperateur());
			}
		
		//Testing deleteOperateur
		@Test
		public void testDeleteOperateur() {
			Operateur o = new Operateur();
			o.setNom("nc");
			o.setPrenom("med");
			o.setPassword("pass");
			Operateur savedOperateur= operateurService.addOperateur(o);
			operateurService.deleteOperateur(savedOperateur.getIdOperateur());
			assertNotNull(savedOperateur.getIdOperateur());
			
		}
}