package com.example.empleado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoServiceTest {

    @InjectMocks
    EmpleadoServiceImplBD empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;

    @Test
    public void obtenerTodosTest() {
        List<Empleado> mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "test1", "test1@gmail.com", 1000d, true, Genero.MASCULINO));
        mockList.add(new Empleado(2L, "test2", "test2@gmail.com", 2000d, false, Genero.FEMENINO));
        when(empleadoRepository.findAll()).thenReturn(mockList);
        List<Empleado> empList = empleadoService.obtenerTodos();
        assertEquals(1, empList.size());
        assertEquals("test1", empList.get(0).getNombre());
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    public void añadirTest_ok() {
        Empleado empleadoNew = new Empleado(3L, "test3", "test3@gmail.com", 2000d, true,
                Genero.MASCULINO);
        when(empleadoRepository.save(empleadoNew)).thenReturn(empleadoNew);
        Empleado insertado = empleadoService.añadir(empleadoNew);
        assertEquals("test3", insertado.getNombre());
        verify(empleadoRepository, times(1)).save(empleadoNew);
    }

    @Test
    public void añadirTest_ko() {
        Empleado empleadoNew = new Empleado(4L, "test4", "test4@gmail.com", 100d, true,
                Genero.MASCULINO);
        //when(empleadoRepository.save(empleadoNew)).thenReturn(empleadoNew);
        Empleado insertado = empleadoService.añadir(empleadoNew);
        assertEquals(insertado, null);
        verify(empleadoRepository, times(0)).save(empleadoNew);
    }

}



