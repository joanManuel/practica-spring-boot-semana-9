package com.codigo.practica_experto_Joan_Torres.services;

import com.codigo.practica_experto_Joan_Torres.model.Persona;
import com.codigo.practica_experto_Joan_Torres.repository.PersonaRepository;
import com.codigo.practica_experto_Joan_Torres.service.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PersonaServiceTest {
    @InjectMocks
    private PersonaService personaService;

    @Mock
    private PersonaRepository personaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerTodosPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1L, "Persona 1"));
        personas.add(new Persona(2L, "Persona 2"));

        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> resultado = personaService.obtenerTodosPersonas();

        assertEquals(2, resultado.size());
    }

    @Test
    public void testObtenerPersonaXid() {
        Long id = 1L;
        Persona persona = new Persona(1L, "Persona 1");

        when(personaRepository.findById(id)).thenReturn(Optional.of(persona));

        Persona resultado = personaService.obtenerPersonaXid(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Persona 1", resultado.getNombre());
    }

    @Test
    public void testObtenerPersonaXid_PersonaNoEncontrado() {
        Long id = 1L;
        when(personaRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException excepcionLanzada = assertThrows(
                RuntimeException.class,
                () -> personaService.obtenerPersonaXid(id)
        );

        assertEquals("Persona no encontrado", excepcionLanzada.getMessage());
    }

    @Test
    public void testCrearPersona() {
        Persona nuevaPersona = new Persona(null, "Nueva Persona");

        when(personaRepository.save(nuevaPersona)).thenReturn(nuevaPersona);

        Persona resultado = personaService.crearPersona(nuevaPersona);

        assertNotNull(resultado);
        assertEquals("Nueva Persona", resultado.getNombre());
    }

    @Test
    public void testActualizarPersona() {
        Long id = 1L;
        Persona personaExistente = new Persona(id, "Persona Existente");
        Persona personaActualizar = new Persona(id, "Persona Actualizada");

        when(personaRepository.findById(id)).thenReturn(Optional.of(personaExistente));
        when(personaRepository.save(personaExistente)).thenReturn(personaExistente);

        Persona resultado = personaService.actualizarPersona(id, personaActualizar);

        assertNotNull(resultado);
        assertEquals("Persona Actualizada", resultado.getNombre());
    }
}
