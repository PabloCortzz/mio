package org.groupfive.gymapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "asistencia")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Asistencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "id_inscripcion")
    private Inscripcion inscripcion;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "presente", nullable = false)
    private boolean presente;

    // Opcionales (aparecen en el diagrama de clases)
    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "especialidad", nullable = true)
    private String especialidad;
}
