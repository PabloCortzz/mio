package org.groupfive.gymapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clase")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Clase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "cupo_max", nullable = false)
    private Integer cupoMax;

    @Column(name = "horario", nullable = false)
    private String horario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_entrenador")
    private Entrenador entrenador;

    @Column(name = "especialidad", nullable = true)
    private String especialidad;
}
