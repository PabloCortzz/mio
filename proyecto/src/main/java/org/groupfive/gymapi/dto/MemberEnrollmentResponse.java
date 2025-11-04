package org.groupfive.gymapi.dto;

import lombok.*;
import java.time.Instant;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MemberEnrollmentResponse {
    private Long idClase;
    private String clase;
    private String horario;
    private int totalAsistencias;
    private List<AsistenciaDTO> asistencias;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class AsistenciaDTO {
        private Long idAsistencia;
        private Instant fecha;
        private boolean presente;
    }
}
