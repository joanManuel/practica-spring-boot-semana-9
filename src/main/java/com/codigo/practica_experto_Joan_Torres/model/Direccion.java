package com.codigo.practica_experto_Joan_Torres.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Long id;
    private String calle;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
