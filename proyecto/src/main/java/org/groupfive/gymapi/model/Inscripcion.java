package org.groupfive.gymapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "inscripcion",
        uniqueConstraints = @UniqueConstraint(name="uk_miembro_clase", columnNames = {"id_miembro","id_clase"}))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Inscripcion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "id_miembro")
    private Miembro miembro;

    @ManyToOne(optional = false) @JoinColumn(name = "id_clase")
    private Clase clase;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "especialidad", nullable = true)
    private String especialidad;
}
