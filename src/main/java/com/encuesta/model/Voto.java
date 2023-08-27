package com.encuesta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "votos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voto_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "opcion_id")
    private Opcion opcion;

}
