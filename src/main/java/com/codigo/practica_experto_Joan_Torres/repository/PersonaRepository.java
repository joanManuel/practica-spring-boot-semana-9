package com.codigo.practica_experto_Joan_Torres.repository;

import com.codigo.practica_experto_Joan_Torres.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
