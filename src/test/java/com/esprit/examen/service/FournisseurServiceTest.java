package com.esprit.examen.service;


import java.util.List;
import org.springframework.util.Assert;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.IFournisseurService;

import org.junit.Test;
	import org.apache.log4j.LogManager;
	import org.apache.log4j.Logger;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class FournisseurServiceTest {
	private static final Logger l =LogManager.getLogger(DepartementServiceImplTest.class);

	@Autowired
	IFournisseurService fournisseurService ; 
	
	@Autowired
	FournisseurRepository fournisseurRepository ; 
	
	
	@Test
	public void testGetAllDepartements()  {

		List <Fournisseur> listFournisseur = fournisseurService.retrieveAllFournisseurs(); 
		for(int i=0 ; i<listFournisseur.size(); i++){
			l.info(listFournisseur);
		}
		Assert.notNull(listFournisseur,"List n'existe pas");

	}
	

}
