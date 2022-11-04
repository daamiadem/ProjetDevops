package com.esprit.examen;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.FactureServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DevopsProjectApplicationTests {

//	@Autowired
//	private FactureServiceImpl factureService;
//
//	@MockBean
//	private FactureRepository factureRepository;
//
//	@MockBean
//	private DetailFactureRepository detailFactureRepository;
//
//	@MockBean
//	private FournisseurRepository fournisseurRepository;
//
//
//	@Test
//	public void getFacturesTest() {
//		when(factureRepository.findAll()).thenReturn(Stream
//				.of(new Facture(1L, 10,1000,new Date(),null,null, null, null, null), new Facture(2L, 10,1000,new Date(),null,null, null, null, null))
//				.collect(Collectors.toList())
//		);
//		assertEquals(2, factureService.retrieveAllFactures().size());
//	}
//
//	@Test
//	public void addFactureTest() {
//		//mock detail facture
//		DetailFacture detailFacture = new DetailFacture(77835L,65018,1650,33,15,null, null);
//		//mock Fourrnisseur
//
//
//		Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
//		when(factureRepository.save(facture)).thenReturn(facture);
//		assertEquals(facture, factureService.addFacture(facture));
//	}
//
//	@Test
//	public void cancelFactureTest() {
//		Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
//		factureService.cancelFacture(facture.getIdFacture());
//		assertEquals(facture.getIdFacture(), facture.getIdFacture());
//	}


}
