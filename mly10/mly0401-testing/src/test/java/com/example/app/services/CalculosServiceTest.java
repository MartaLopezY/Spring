package com.example.app.services;

import com.example.app.service.CalculosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculosServiceTest {
    @Autowired
    CalculosService calculosService;
    @Test
    public void esPrimoTest_ok(){
      assertEquals(calculosService.esPrimo(8),false)  ;
        assertEquals(calculosService.esPrimo(7),true)  ;
    }
    @Test
    public void esPrimoTest_fail(){
        assertThrows(RuntimeException.class,()->calculosService.esPrimo(-2)) ;
    }

}
