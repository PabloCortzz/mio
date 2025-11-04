package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MiembroIdRequest {
    @NotNull private Long miembroId;
}
