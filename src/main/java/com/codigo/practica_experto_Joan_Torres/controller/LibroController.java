package com.codigo.practica_experto_Joan_Torres.controller;

import com.codigo.practica_experto_Joan_Torres.model.Libro;
import com.codigo.practica_experto_Joan_Torres.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listarLibroes() {
        return libroService.obtenerTodosLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        Libro libro = libroService.obtenerLibroXid(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable long id, @RequestBody Libro libroActualizado){
        Libro libro = libroService.actualizarLibro(id, libroActualizado);
        return ResponseEntity.ok(libro);
    }
}
