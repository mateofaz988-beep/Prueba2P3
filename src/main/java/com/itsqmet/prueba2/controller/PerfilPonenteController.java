package com.itsqmet.prueba2.controller;

import com.itsqmet.prueba2.model.PerfilPonente;
import com.itsqmet.prueba2.repository.PerfilPonenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "*")
public class PerfilPonenteController {

    @Autowired
    private PerfilPonenteRepository repository;

    @GetMapping
    public List<PerfilPonente> listarTodos() { return repository.findAll(); }

    @GetMapping("/{id}")
    public PerfilPonente obtenerPorId(@PathVariable Long id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    public PerfilPonente crear(@RequestBody PerfilPonente perfil) { return repository.save(perfil); }

    @PutMapping("/{id}")
    public PerfilPonente actualizar(@PathVariable Long id, @RequestBody PerfilPonente perfil) {
        perfil.setId(id);
        return repository.save(perfil);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repository.deleteById(id); }
}