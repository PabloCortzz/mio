package org.groupfive.gymapi.repository;

import org.groupfive.gymapi.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    long countByEntrenador_Id(Long entrenadorId);
}
