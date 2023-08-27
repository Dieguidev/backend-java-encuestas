package com.encuesta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "encuestas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encuesta_id")
    private Long id;

    private String pregunta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "encuesta_id")
    @OrderBy
    private Set<Opcion> opciones;
}
