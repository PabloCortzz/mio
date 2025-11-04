package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.*; import lombok.Data;

@Data
public class CreateMiembroRequest {
    @NotBlank private String nombre;
    @NotBlank private String edad;
}