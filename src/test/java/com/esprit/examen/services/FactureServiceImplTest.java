package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

//
//    @Autowired
//    FactureServiceImpl factureService;
//    @MockBean
//	private FactureRepository factureRepository;
//
//    @MockBean
//    OperateurRepository operateurRepository;
//
//    //mock test facture
//    Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, this.fournisseur, null);
//
//    //mock test detail facture
//    DetailFacture detailFacture = new DetailFacture(77835L,65018,1650,33,15,null, null);
//
//    //mock test Fournisseur
//    Fournisseur fournisseur = new Fournisseur(1L, "961298921", "Adelia", null , null, null, null);
//
//    @Test
//    @Order(1)
//    void retrieveAllFactures() {
//        when(factureRepository.findAll()).thenReturn(Stream
//				.of(new Facture(1L, 10,1000,new Date(),null,null, null, null, null), new Facture(2L, 10,1000,new Date(),null,null, null, null, null))
//				.collect(Collectors.toList())
//		);
//		assertEquals(2, factureService.retrieveAllFactures().size());
//    }
//
//    @Test
//    @Order(2)
//    void addFacture() {
//        //mock detail facture
//		DetailFacture detailFacture = new DetailFacture(77835L,65018,1650,33,15,null, null);
//		//mock Fourrnisseur
//
//
//		Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
//		when(factureRepository.save(facture)).thenReturn(facture);
//		assertEquals(facture, factureService.addFacture(facture));
//    }
//
//    @Test
//    @Order(3)
//    void cancelFacture() {
//        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(facture));
//        factureService.cancelFacture(1L);
//        assertEquals(facture.getArchivee(), true);
//    }
//
//    @Test
//    @Order(4)
//    void retrieveFacture() {
//        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(facture));
//        assertEquals(facture, factureService.retrieveFacture(1L));
//    }

}