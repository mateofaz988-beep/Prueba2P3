package com.itsqmet.prueba2.controller;

import com.itsqmet.prueba2.model.Ponente;
import com.itsqmet.prueba2.repository.PonenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ponentes")
@CrossOrigin(origins = "*")
public class PonenteController {

    @Autowired
    private PonenteRepository repository;

    @GetMapping
    public List<Ponente> listarTodos() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Ponente obtenerPorId(@PathVariable Long id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    public Ponente crear(@RequestBody Ponente ponente) { return repository.save(ponente); }

    @PutMapping("/{id}")
    public Ponente actualizar(@PathVariable Long id, @RequestBody Ponente ponente) {
        ponente.setId(id);
        return repository.save(ponente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repository.deleteById(id); }

    // Consulta requerida 2
    @GetMapping("/especialidad/{keyword}")
    public List<Ponente> porEspecialidad(@PathVariable String keyword) {
        return repository.findByEspecialidadContainingIgnoreCase(keyword);
    }
}