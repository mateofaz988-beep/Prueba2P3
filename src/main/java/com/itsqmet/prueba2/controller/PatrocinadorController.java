package com.itsqmet.prueba2.controller;

import com.itsqmet.prueba2.model.Patrocinador;
import com.itsqmet.prueba2.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patrocinadores")
@CrossOrigin(origins = "*")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorRepository repository;

    @GetMapping
    public List<Patrocinador> listarTodos() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Patrocinador obtenerPorId(@PathVariable Long id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    public Patrocinador crear(@RequestBody Patrocinador patrocinador) { return repository.save(patrocinador); }

    @PutMapping("/{id}")
    public Patrocinador actualizar(@PathVariable Long id, @RequestBody Patrocinador patrocinador) {
        patrocinador.setId(id);
        return repository.save(patrocinador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repository.deleteById(id); }

    // Consulta requerida 4
    @GetMapping("/rango")
    public List<Patrocinador> porRangoAporte(@RequestParam Double min, @RequestParam Double max) {
        return repository.findByMontoAporteBetweenOrderByMontoAporteDesc(min, max);
    }
}