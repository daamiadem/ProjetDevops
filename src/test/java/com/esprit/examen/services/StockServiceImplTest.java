package com.esprit.examen.services;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    Stock stock = new Stock(1L,"test",10,10,null);

    List<Stock> stocks = new ArrayList<Stock>(){
        {
            add(new Stock(2L,"test2",10,10,null));
            add(new Stock(3L,"test3",10,10,null));
            add(new Stock(4L,"test4",10,10,null));
        }
    };

    @Test
    void retrieveAllStocks() {
        Mockito.doReturn(stocks).when(stockRepository).findAll();
        List<Stock> stocks = stockService.retrieveAllStocks();
        assertNotNull(stocks);
    }

    @Test
    void addStock() {
        Stock stock = new Stock(1L,"test",10,10,null);
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        Stock stock1 = stockService.addStock(stock);
        assertNotNull(stock1);
    }

    @Test
    void deleteStock() {
        Mockito.doNothing().when(stockRepository).deleteById(Mockito.anyLong());
        stockService.deleteStock(1L);
    }
}