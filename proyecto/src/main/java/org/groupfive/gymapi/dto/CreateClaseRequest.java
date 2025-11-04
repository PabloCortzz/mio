package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateClaseRequest {
    @NotBlank private String nombre;
    @NotNull @Min(1) private Integer cupoMax;
    @NotBlank private String horario;
    @NotNull private Long entrenadorId;
}
