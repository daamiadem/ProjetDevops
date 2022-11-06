package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ReglementServiceImplTest {

    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementService;

    @Test
    void retrieveAllReglements() throws ParseException{
        when(reglementRepository.findAll()).thenReturn(Stream.of(new Reglement(1L, 155, 55, true,null, null), new Reglement(2L, 100, 25, true,null, null)).collect(Collectors.toList()));
        assertEquals(2, reglementService.retrieveAllReglements().size());
    }

//
//    @Autowired
//    IReglementService reglementService;
//
//    @Autowired
//    FactureServiceImpl factureService;
//
//    @Test
//    void retrieveAllReglements() throws ParseException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse("2020-12-12");
//        Reglement reglement = new Reglement(1L, 155, 55, true,date, null);
//        reglementService.addReglement(reglement);
//        List<Reglement> reglements = reglementService.retrieveAllReglements();
//        int size = reglements.size();
//        assertEquals(2, size);
//    }
//
//    @Test
//    void addReglement() throws ParseException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse("2020-12-12");
//        Reglement reglement = new Reglement(1L, 155, 55, true,date, null);
//        reglementService.addReglement(reglement);
//        assertNotNull(reglementService.retrieveReglement(reglement.getIdReglement()));
//    }
//
//    @Test
//    void retrieveReglement() {
//        Reglement reglement = new Reglement(1L, 155, 55, true, null, null);
//        reglementService.addReglement(reglement);
//        assertNotNull(reglementService.retrieveReglement(reglement.getIdReglement()));
//    }


}