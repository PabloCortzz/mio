package org.groupfive.gymapi.service;

import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.CreateClaseRequest;
import org.groupfive.gymapi.model.*;
import org.groupfive.gymapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service @RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepo;
    private final ClaseRepository claseRepo;
    private final MiembroRepository miembroRepo;
    private final InscripcionRepository inscripcionRepo;
    private final AsistenciaRepository asistenciaRepo;

    @Transactional
    public Clase crearClase(CreateClaseRequest req) {
        Entrenador e = entrenadorRepo.findById(req.getEntrenadorId())
                .orElseThrow(() -> new NotFoundException("Entrenador no encontrado"));

        Clase c = Clase.builder()
                .nombre(req.getNombre())
                .cupoMax(req.getCupoMax())
                .horario(req.getHorario())
                .entrenador(e)
                .especialidad(e.getEspecialidad())
                .build();

        return claseRepo.save(c);
    }


    @Transactional
    public void registrarAsistencia(Long claseId, Long miembroId) {
        Clase clase = claseRepo.findById(claseId)
                .orElseThrow(() -> new NotFoundException("Clase no encontrada"));
        Miembro miembro = miembroRepo.findById(miembroId)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado"));

        Inscripcion ins = inscripcionRepo.findByMiembro_IdAndClase_Id(miembro.getId(), clase.getId());
        if (ins == null) throw new BusinessException("El miembro no está inscrito en la clase");

        Asistencia a = Asistencia.builder()
                .inscripcion(ins)
                .fecha(Instant.now())
                .presente(true)
                .nombre(miembro.getNombre())
                .especialidad(clase.getEspecialidad())
                .build();

        asistenciaRepo.save(a);
    }
}
