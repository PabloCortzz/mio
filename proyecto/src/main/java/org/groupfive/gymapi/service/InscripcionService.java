package org.groupfive.gymapi.service;

import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.model.*;
import org.groupfive.gymapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service @RequiredArgsConstructor
public class InscripcionService {

    private final MiembroRepository miembroRepo;
    private final ClaseRepository claseRepo;
    private final InscripcionRepository inscripcionRepo;

    @Transactional
    public void inscribir(Long miembroId, Long claseId) {
        Miembro m = miembroRepo.findById(miembroId)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado"));
        Clase c = claseRepo.findById(claseId)
                .orElseThrow(() -> new NotFoundException("Clase no encontrada"));

        if (inscripcionRepo.existsByMiembro_IdAndClase_Id(miembroId, claseId))
            throw new BusinessException("El miembro ya está inscrito");

        long inscritos = inscripcionRepo.countByClase_Id(claseId);
        if (inscritos >= c.getCupoMax())
            throw new BusinessException("La clase está llena");

        Inscripcion ins = Inscripcion.builder()
                .miembro(m).clase(c).fecha(Instant.now())
                .nombre(m.getNombre())                // opcional
                .especialidad(c.getEspecialidad())    // opcional
                .build();

        inscripcionRepo.save(ins);
    }
}
