package com.esprit.examen.services;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Operateur;
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

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

    @InjectMocks
    @Autowired
    FactureServiceImpl factureService;

    @Mock
    OperateurRepository operateurRepository;

    //mock test facture
    Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);


    @Test
    @Order(1)
    void retrieveAllFactures() {
        List<Facture> factures = factureService.retrieveAllFactures();
        Assertions.assertEquals(0, factures.size());
    }

    @Test
    void addFacture() {
    }

    @Test
    void cancelFacture() {
    }

    @Test
    void retrieveFacture() {
    }

    @Test
    void getFacturesByFournisseur() {
    }

    @Test
    void assignOperateurToFacture() {

    }

    @Test
    void pourcentageRecouvrement() {
    }
}