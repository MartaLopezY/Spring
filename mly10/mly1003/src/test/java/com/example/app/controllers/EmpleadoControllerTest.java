package com.example.app.controllers;

import com.example.app.controllers.EmpleadoController;
import com.example.app.entity.Empleado;
import com.example.app.entity.Genero;
import com.example.app.service.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*; //hasSize, instanceOf, put...
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; //get, post, put...
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class EmpleadoControllerTest {
    @InjectMocks
    EmpleadoController empleadoController;
    @MockBean
    EmpleadoService empleadoService;
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getOneElementTest() throws Exception {
        Empleado empleado=new Empleado(0L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO);
        when(empleadoService.obtenerPorId(2)).thenReturn(empleado);
        mockMvc.perform(get("/empleado/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("pepe@gmail.com")));

    }

}
