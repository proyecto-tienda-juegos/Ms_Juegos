package com.tienda.juegos.service;

import com.tienda.juegos.model.Juego;
import com.tienda.juegos.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;

    @Autowired
    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    public List<Juego> listarTodos() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> buscarPorId(Long id) {
        return juegoRepository.findById(id);
    }

    public Juego crear(Juego juego) {
        return juegoRepository.save(juego);
    }

    public Optional<Juego> actualizar(Long id, Juego datosNuevos) {
        return juegoRepository.findById(id).map(juegoExistente -> {
            juegoExistente.setTitulo(datosNuevos.getTitulo());
            juegoExistente.setGenero(datosNuevos.getGenero());
            juegoExistente.setPrecio(datosNuevos.getPrecio());
            juegoExistente.setDescripcion(datosNuevos.getDescripcion());
            return juegoRepository.save(juegoExistente);
        });
    }

    public boolean eliminar(Long id) {
        if (juegoRepository.existsById(id)) {
            juegoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
