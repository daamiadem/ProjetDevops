package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ReglementServiceImplTest {

    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementService;

    Reglement reglement = new Reglement(1L,155, 55, true,null, null);
    List<Reglement> reglements = new ArrayList<Reglement>(){
        {
            add(new Reglement(2L,550, 0, true,null, null));
            add(new Reglement(3L,200, 15, true,null, null));
            add(new Reglement(4L,100, 0, true,null, null));
        }
    };



    @Test
    void retrieveAllReglements() throws ParseException{
        Mockito.doReturn(reglements).when(reglementRepository).findAll();
        List<Reglement> reglements = reglementService.retrieveAllReglements();
        Assertions.assertNotNull(reglements);
    }



    @Test
    void addReglement() throws ParseException {
        Reglement reglement = new Reglement(1L,155, 55, true,null, null);
        Mockito.when(reglementRepository.save(Mockito.any(Reglement.class))).thenReturn(reglement);
        Reglement reglement1 = reglementService.addReglement(reglement);
        Assertions.assertNotNull(reglement1);
    }

    @Test
    void retrieveReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        Reglement reglement1 = reglementService.retrieveReglement(1L);
        Assertions.assertNotNull(reglement1);
    }


}