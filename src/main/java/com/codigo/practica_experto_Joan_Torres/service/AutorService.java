package com.codigo.practica_experto_Joan_Torres.service;

import com.codigo.practica_experto_Joan_Torres.model.Autor;
import com.codigo.practica_experto_Joan_Torres.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodosAutores() {
        return autorRepository.findAll();
    }

    public Autor obtenerAutorXid(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()) {
            return autor.get();
        } else {
            throw new RuntimeException("Autor no encontrado");
        }
    }

    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor actualizarAutor(Long id, Autor autorActualizar) {

        Autor autorExistente = obtenerAutorXid(id);

        autorExistente.setNombre(autorActualizar.getNombre());
        autorExistente.setNombre(autorActualizar.getNombre());
        /* Pendiente validar */
        return autorRepository.save(autorExistente);
    }
}
