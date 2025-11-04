package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateEntrenadorRequest {
    @NotBlank
    private String nombre;
    @NotBlank private String especialidad;
}