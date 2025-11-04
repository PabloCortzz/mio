package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.*; import lombok.Data;

@Data
public class CreateEntrenadorRequest {
    @NotBlank private String nombre;
    @NotBlank private String especialidad;
}
