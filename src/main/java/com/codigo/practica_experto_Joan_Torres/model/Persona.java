package com.codigo.practica_experto_Joan_Torres.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long id;
    private String nombre;
    public Persona(){}
    public Persona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
