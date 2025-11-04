package org.groupfive.gymapi.service;

import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.MemberEnrollmentResponse;
import org.groupfive.gymapi.model.Inscripcion;
import org.groupfive.gymapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MiembroService {

    private final MiembroRepository miembroRepo;
    private final InscripcionRepository inscripcionRepo;
    private final AsistenciaRepository asistenciaRepo;

    @Transactional(readOnly = true)
    public List<MemberEnrollmentResponse> verInscripcionesYAsistencias(Long miembroId) {
        miembroRepo.findById(miembroId).orElseThrow(() -> new NotFoundException("Miembro no encontrado"));
        List<Inscripcion> ins = inscripcionRepo.findByMiembro_Id(miembroId);

        return ins.stream().map(i -> {
            var asist = asistenciaRepo.findByInscripcion_Id(i.getId()).stream()
                    .map(a -> new MemberEnrollmentResponse.AsistenciaDTO(a.getId(), a.getFecha(), a.isPresente()))
                    .collect(Collectors.toList());

            return MemberEnrollmentResponse.builder()
                    .idClase(i.getClase().getId())
                    .clase(i.getClase().getNombre())
                    .horario(i.getClase().getHorario())
                    .totalAsistencias(asist.size())
                    .asistencias(asist)
                    .build();
        }).toList();
    }
}
