package com.codigo.practica_experto_Joan_Torres.repository;

import com.codigo.practica_experto_Joan_Torres.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
