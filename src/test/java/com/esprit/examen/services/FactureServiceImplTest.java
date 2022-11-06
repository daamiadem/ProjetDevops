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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {
    @Mock
    FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;

    Facture facture = new Facture(1L,10,100,null,null, false,null,null,null);
    List<Facture> factures = new ArrayList<Facture>(){
        {
            add(new Facture(2L,20,100,null,null, false,null,null,null));
            add(new Facture(3L,30,150,null,null, false,null,null,null));
            add(new Facture(4L,40,250,null,null, false,null,null,null));
        }
    };

    @Test
    void retieveAllFactures(){
        Mockito.doReturn(factures).when(factureRepository).findAll();
        List<Facture> factures = factureService.retrieveAllFactures();
        Assertions.assertNotNull(factures);

    }

    @Test
    void addFacture(){
        Facture facture = new Facture(1L,10,100,null,null, false,null,null,null);
        Mockito.doReturn(facture).when(factureRepository).save(facture);
        Facture facture1 = factureService.addFacture(facture);
        Assertions.assertNotNull(facture1);
    }



}