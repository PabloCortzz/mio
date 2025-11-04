package org.groupfive.gymapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrenador")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Entrenador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especialidad;
}
