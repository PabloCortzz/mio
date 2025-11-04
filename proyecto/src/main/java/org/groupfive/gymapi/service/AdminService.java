package org.groupfive.gymapi.service;

import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.*;
import org.groupfive.gymapi.model.*;
import org.groupfive.gymapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class AdminService {

    private final MiembroRepository miembroRepo;
    private final EntrenadorRepository entrenadorRepo;
    private final ClaseRepository claseRepo;
    private final InscripcionRepository inscripcionRepo;

    // Miembro
    @Transactional
    public Miembro crearMiembro(CreateMiembroRequest r) {
        return miembroRepo.save(Miembro.builder().nombre(r.getNombre()).edad(r.getEdad()).build());
    }

    @Transactional
    public Miembro editarMiembro(Long id, UpdateMiembroRequest r) {
        var m = miembroRepo.findById(id).orElseThrow(() -> new NotFoundException("Miembro no encontrado"));
        m.setNombre(r.getNombre()); m.setEdad(r.getEdad());
        return miembroRepo.save(m);
    }

    @Transactional public void eliminarMiembro(Long id) {
        var m = miembroRepo.findById(id).orElseThrow(() -> new NotFoundException("Miembro no encontrado"));
        miembroRepo.delete(m);
    }

    // Entrenador
    @Transactional
    public Entrenador crearEntrenador(CreateEntrenadorRequest r) {
        return entrenadorRepo.save(Entrenador.builder().nombre(r.getNombre()).especialidad(r.getEspecialidad()).build());
    }

    @Transactional
    public Entrenador editarEntrenador(Long id, UpdateEntrenadorRequest r) {
        var e = entrenadorRepo.findById(id).orElseThrow(() -> new NotFoundException("Entrenador no encontrado"));
        e.setNombre(r.getNombre()); e.setEspecialidad(r.getEspecialidad());
        return entrenadorRepo.save(e);
    }

    @Transactional
    public void eliminarEntrenador(Long id) {
        var e = entrenadorRepo.findById(id).orElseThrow(() -> new NotFoundException("Entrenador no encontrado"));
        long clases = claseRepo.countByEntrenador_Id(id);
        if (clases > 0) throw new BusinessException("El entrenador tiene clases asignadas; reasigna antes de eliminar.");
        entrenadorRepo.delete(e);
    }

    // Clase
    public Clase crearClaseAdmin(CreateClaseRequest r) {
        var e = entrenadorRepo.findById(r.getEntrenadorId())
                .orElseThrow(() -> new NotFoundException("Entrenador no encontrado"));
        var c = Clase.builder()
                .nombre(r.getNombre())
                .cupoMax(r.getCupoMax())
                .horario(r.getHorario())
                .entrenador(e)
                .especialidad(e.getEspecialidad())
                .build();
        return claseRepo.save(c);
    }

    @Transactional
    public Clase editarClase(Long id, UpdateClaseRequest r) {
        var c = claseRepo.findById(id).orElseThrow(() -> new NotFoundException("Clase no encontrada"));
        var e = entrenadorRepo.findById(r.getEntrenadorId()).orElseThrow(() -> new NotFoundException("Entrenador no encontrado"));
        c.setNombre(r.getNombre()); c.setCupoMax(r.getCupoMax()); c.setHorario(r.getHorario()); c.setEntrenador(e);
        c.setEspecialidad(e.getEspecialidad());
        return claseRepo.save(c);
    }

    @Transactional public void eliminarClase(Long id) {
        var c = claseRepo.findById(id).orElseThrow(() -> new NotFoundException("Clase no encontrada"));
        claseRepo.delete(c);
    }
}
