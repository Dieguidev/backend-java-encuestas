package com.encuesta.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "opciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opcion_id")
    private Long id;

    private String value;
}
