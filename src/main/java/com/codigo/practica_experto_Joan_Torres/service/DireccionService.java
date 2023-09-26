package com.codigo.practica_experto_Joan_Torres.service;

import com.codigo.practica_experto_Joan_Torres.model.Direccion;
import com.codigo.practica_experto_Joan_Torres.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {
    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<Direccion> obtenerTodosDirecciones() {
        return direccionRepository.findAll();
    }

    public Direccion obtenerDireccionXid(Long id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        if(direccion.isPresent()) {
            return direccion.get();
        } else {
            throw new RuntimeException("Direccion no encontrado");
        }
    }

    public Direccion crearDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion actualizarDireccion(Long id, Direccion direccionActualizar) {

        Direccion direccionExistente = obtenerDireccionXid(id);

        direccionExistente.setCalle(direccionActualizar.getCalle());
        direccionExistente.setPersona(direccionActualizar.getPersona());
        /* Pendiente validar */
        return direccionRepository.save(direccionExistente);
    }
}
