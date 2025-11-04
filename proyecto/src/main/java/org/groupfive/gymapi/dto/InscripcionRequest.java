package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscripcionRequest {
    @NotNull private Long miembroId;
    @NotNull private Long claseId;
}
