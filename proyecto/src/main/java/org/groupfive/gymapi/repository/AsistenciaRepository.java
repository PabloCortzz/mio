package org.groupfive.gymapi.repository;

import org.groupfive.gymapi.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByInscripcion_Id(Long inscripcionId);
}
