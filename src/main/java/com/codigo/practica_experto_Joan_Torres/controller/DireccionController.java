package com.codigo.practica_experto_Joan_Torres.controller;

import com.codigo.practica_experto_Joan_Torres.model.Direccion;
import com.codigo.practica_experto_Joan_Torres.service.DireccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping
    public List<Direccion> listarDirecciones() {
        return direccionService.obtenerTodosDirecciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerDireccionPorId(@PathVariable Long id) {
        Direccion direccion = direccionService.obtenerDireccionXid(id);
        return ResponseEntity.ok(direccion);
    }

    @PostMapping
    public ResponseEntity<Direccion> crearDireccion(@RequestBody Direccion direccion) {
        Direccion nuevoDireccion = direccionService.crearDireccion(direccion);
        return new ResponseEntity<>(nuevoDireccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable long id, @RequestBody Direccion direccionActualizado){
        Direccion direccion = direccionService.actualizarDireccion(id, direccionActualizado);
        return ResponseEntity.ok(direccion);
    }
}
