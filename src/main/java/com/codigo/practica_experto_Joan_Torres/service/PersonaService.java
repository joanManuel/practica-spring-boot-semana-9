package com.codigo.practica_experto_Joan_Torres.service;

import com.codigo.practica_experto_Joan_Torres.model.Persona;
import com.codigo.practica_experto_Joan_Torres.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> obtenerTodosPersonas() {
        return personaRepository.findAll();
    }

    public Persona obtenerPersonaXid(Long id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if(persona.isPresent()) {
            return persona.get();
        } else {
            throw new RuntimeException("Persona no encontrado");
        }
    }

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Long id, Persona personaActualizar) {

        Persona personaExistente = obtenerPersonaXid(id);

        personaExistente.setNombre(personaActualizar.getNombre());

        return personaRepository.save(personaExistente);
    }
}
