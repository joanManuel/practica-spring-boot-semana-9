package com.codigo.practica_experto_Joan_Torres.services;

import com.codigo.practica_experto_Joan_Torres.model.Libro;
import com.codigo.practica_experto_Joan_Torres.repository.LibroRepository;
import com.codigo.practica_experto_Joan_Torres.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LibroServiceTest {
    @InjectMocks
    private LibroService libroService;

    @Mock
    private LibroRepository libroRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerTodosLibros() {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro(1L, "Libro 1", new HashSet<>()));
        libros.add(new Libro(2L, "Libro 2", new HashSet<>()));

        when(libroRepository.findAll()).thenReturn(libros);

        List<Libro> resultado = libroService.obtenerTodosLibros();

        assertEquals(2, resultado.size());
    }

    @Test
    public void testObtenerLibroXid() {
        Long id = 1L;
        Libro libro = new Libro(id, "Libro 1", new HashSet<>());

        when(libroRepository.findById(id)).thenReturn(Optional.of(libro));

        Libro resultado = libroService.obtenerLibroXid(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Libro 1", resultado.getTitulo());
    }

    @Test
    public void testObtenerLibroXid_LibroNoEncontrado() {
        Long id = 1L;

        when(libroRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException excepcionLanzada = assertThrows(
                RuntimeException.class,
                () -> libroService.obtenerLibroXid(id)
        );

        assertEquals("Libro no encontrado", excepcionLanzada.getMessage());
    }


    @Test
    public void testCrearLibro() {
        Libro nuevoLibro = new Libro(null, "Nuevo Libro", new HashSet<>());

        when(libroRepository.save(nuevoLibro)).thenReturn(nuevoLibro);

        Libro resultado = libroService.crearLibro(nuevoLibro);

        assertNotNull(resultado);
        assertEquals("Nuevo Libro", resultado.getTitulo());
    }

    @Test
    public void testActualizarLibro() {
        Long id = 1L;
        Libro libroExistente = new Libro(id, "Libro Existente", new HashSet<>());
        Libro libroActualizar = new Libro(id, "Libro Actualizado", new HashSet<>());

        when(libroRepository.findById(id)).thenReturn(Optional.of(libroExistente));
        when(libroRepository.save(libroExistente)).thenReturn(libroExistente);

        Libro resultado = libroService.actualizarLibro(id, libroActualizar);

        assertNotNull(resultado);
        assertEquals("Libro Actualizado", resultado.getTitulo());
    }

}
