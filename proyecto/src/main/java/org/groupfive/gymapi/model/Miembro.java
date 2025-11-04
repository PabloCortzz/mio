package org.groupfive.gymapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "miembro")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Miembro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_miembro")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private String edad;
}
