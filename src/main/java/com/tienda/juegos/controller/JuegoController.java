package com.tienda.juegos.controller;

import com.tienda.juegos.model.Juego;
import com.tienda.juegos.service.JuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    @Autowired
    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    // GET http://localhost:8082/api/juegos
    @GetMapping
    public ResponseEntity<List<Juego>> listarTodos() {
        return ResponseEntity.ok(juegoService.listarTodos());
    }

    // GET http://localhost:8082/api/juegos/1
    @GetMapping("/{id}")
    public ResponseEntity<Juego> buscarPorId(@PathVariable Long id) {
        return juegoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST http://localhost:8082/api/juegos
    // Body (JSON): { "titulo": "Elden Ring", "genero": "RPG", "precio": 39990, "descripcion": "..." }
    @PostMapping
    public ResponseEntity<Juego> crear(@Valid @RequestBody Juego juego) {
        Juego creado = juegoService.crear(juego);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT http://localhost:8082/api/juegos/1
    @PutMapping("/{id}")
    public ResponseEntity<Juego> actualizar(@PathVariable Long id, @Valid @RequestBody Juego juego) {
        return juegoService.actualizar(id, juego)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE http://localhost:8082/api/juegos/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = juegoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
