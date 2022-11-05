package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ReglementServiceImplTest {

    @Autowired
    IReglementService reglementService;

    @Autowired
    FactureServiceImpl factureService;

    @Test
    void retrieveAllReglements() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-12-12");
        Reglement reglement = new Reglement(1L, 155, 55, true,date, null);
        reglementService.addReglement(reglement);
        List<Reglement> reglements = reglementService.retrieveAllReglements();
        int size = reglements.size();
        assertEquals(2, size);
    }

    @Test
    void addReglement() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-12-12");
        Reglement reglement = new Reglement(1L, 155, 55, true,date, null);
        reglementService.addReglement(reglement);
        assertNotNull(reglementService.retrieveReglement(reglement.getIdReglement()));
    }

    @Test
    void retrieveReglement() {
        Reglement reglement = new Reglement(1L, 155, 55, true, null, null);
        reglementService.addReglement(reglement);
        assertNotNull(reglementService.retrieveReglement(reglement.getIdReglement()));
    }


}