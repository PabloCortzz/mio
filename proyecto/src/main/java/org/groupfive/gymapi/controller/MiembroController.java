package org.groupfive.gymapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.*;
import org.groupfive.gymapi.service.InscripcionService;
import org.groupfive.gymapi.service.MiembroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
@RequiredArgsConstructor
public class MiembroController {

    private final InscripcionService inscripcionService;
    private final MiembroService miembroService;

    @PostMapping("/inscribirse")
    public ResponseEntity<?> inscribir(@Valid @RequestBody InscripcionRequest req) {
        inscripcionService.inscribir(req.getMiembroId(), req.getClaseId());
        return ResponseEntity.ok(java.util.Map.of("message","Inscripción realizada"));
    }

    @PostMapping("/inscripciones")
    public ResponseEntity<List<MemberEnrollmentResponse>> verInscripciones(@Valid @RequestBody MiembroIdRequest req) {
        return ResponseEntity.ok(miembroService.verInscripcionesYAsistencias(req.getMiembroId()));
    }
}
