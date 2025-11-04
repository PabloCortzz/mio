package org.groupfive.gymapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AttendanceRequest {
    @NotNull private Long claseId;
    @NotNull private Long miembroId;
}
