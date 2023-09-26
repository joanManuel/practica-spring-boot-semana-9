package com.codigo.practica_experto_Joan_Torres.service;

import com.codigo.practica_experto_Joan_Torres.model.Libro;
import com.codigo.practica_experto_Joan_Torres.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodosLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroXid(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isPresent()) {
            return libro.get();
        } else {
            throw new RuntimeException("Libro no encontrado");
        }
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizar) {

        Libro libroExistente = obtenerLibroXid(id);

        libroExistente.setTitulo(libroActualizar.getTitulo());
        libroExistente.setAutor(libroActualizar.getAutor());
        /* Pendiente validar */
        return libroRepository.save(libroExistente);
    }
}
