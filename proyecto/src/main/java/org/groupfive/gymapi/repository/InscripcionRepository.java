package org.groupfive.gymapi.repository;

import org.groupfive.gymapi.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    boolean existsByMiembro_IdAndClase_Id(Long miembroId, Long claseId);
    long countByClase_Id(Long claseId);
    List<Inscripcion> findByMiembro_Id(Long miembroId);
    Inscripcion findByMiembro_IdAndClase_Id(Long miembroId, Long claseId);
}
