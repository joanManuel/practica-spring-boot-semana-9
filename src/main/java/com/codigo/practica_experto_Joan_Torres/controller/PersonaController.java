package com.codigo.practica_experto_Joan_Torres.controller;

import com.codigo.practica_experto_Joan_Torres.model.Persona;
import com.codigo.practica_experto_Joan_Torres.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> listarPersonaes() {
        return personaService.obtenerTodosPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaXid(id);
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nuevoPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable long id, @RequestBody Persona personaActualizado){
        Persona persona = personaService.actualizarPersona(id, personaActualizado);
        return ResponseEntity.ok(persona);
    }
}
