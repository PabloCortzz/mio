package org.groupfive.gymapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
public class CreateClaseRequest {
    @NotNull
    private Long entrenadorId;
    @NotNull
    private String nombre;
    @NotNull
    private String horario;
    @NotNull
    @Min(1)
    private Integer cupoMax;
}
