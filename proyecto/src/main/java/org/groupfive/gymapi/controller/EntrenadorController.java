package org.groupfive.gymapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.AttendanceRequest;
import org.groupfive.gymapi.dto.CreateClaseRequest;
import org.groupfive.gymapi.model.Clase;
import org.groupfive.gymapi.service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    // Crear clase: todo en el body (incluye entrenadorId)
    @PostMapping("/clases")
    public ResponseEntity<Clase> crearClase(@Valid @RequestBody CreateClaseRequest req) {
        return ResponseEntity.ok(entrenadorService.crearClase(req));
    }

    // Registrar asistencia: todo en el body (claseId y miembroId)
    @PostMapping("/asistencias")
    public ResponseEntity<?> registrarAsistencia(@Valid @RequestBody AttendanceRequest req) {
        entrenadorService.registrarAsistencia(req.getClaseId(), req.getMiembroId());
        return ResponseEntity.ok(java.util.Map.of("message","Asistencia registrada"));
    }
}
