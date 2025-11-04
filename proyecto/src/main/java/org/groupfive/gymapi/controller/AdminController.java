package org.groupfive.gymapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.groupfive.gymapi.dto.*;
import org.groupfive.gymapi.model.*;
import org.groupfive.gymapi.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService admin;

    // Miembro
    @PostMapping("/miembros")
    public ResponseEntity<Miembro> crearMiembro(@Valid @RequestBody CreateMiembroRequest r){
        return ResponseEntity.ok(admin.crearMiembro(r));
    }
    @PutMapping("/miembros/{id}")
    public ResponseEntity<Miembro> editarMiembro(@PathVariable Long id, @Valid @RequestBody UpdateMiembroRequest r){
        return ResponseEntity.ok(admin.editarMiembro(id,r));
    }
    @DeleteMapping("/miembros/{id}")
    public ResponseEntity<?> eliminarMiembro(@PathVariable Long id){
        admin.eliminarMiembro(id);
        return ResponseEntity.ok(java.util.Map.of("message","Miembro eliminado"));
    }

    // Entrenador
    @PostMapping("/entrenadores")
    public ResponseEntity<Entrenador> crearEntrenador(@Valid @RequestBody CreateEntrenadorRequest r){
        return ResponseEntity.ok(admin.crearEntrenador(r));
    }
    @PutMapping("/entrenadores/{id}")
    public ResponseEntity<Entrenador> editarEntrenador(@PathVariable Long id, @Valid @RequestBody UpdateEntrenadorRequest r){
        return ResponseEntity.ok(admin.editarEntrenador(id,r));
    }
    @DeleteMapping("/entrenadores/{id}")
    public ResponseEntity<?> eliminarEntrenador(@PathVariable Long id){
        admin.eliminarEntrenador(id);
        return ResponseEntity.ok(java.util.Map.of("message","Entrenador eliminado"));
    }

    // Clase (el id del entrenador ahora viene en el body)
    @PostMapping("/clases")
    public ResponseEntity<Clase> crearClase(@Valid @RequestBody CreateClaseRequest r){
        return ResponseEntity.ok(admin.crearClaseAdmin(r));
    }
    @PutMapping("/clases/{id}")
    public ResponseEntity<Clase> editarClase(@PathVariable Long id, @Valid @RequestBody UpdateClaseRequest r){
        return ResponseEntity.ok(admin.editarClase(id, r));
    }
    @DeleteMapping("/clases/{id}")
    public ResponseEntity<?> eliminarClase(@PathVariable Long id){
        admin.eliminarClase(id);
        return ResponseEntity.ok(java.util.Map.of("message","Clase eliminada"));
    }
}
