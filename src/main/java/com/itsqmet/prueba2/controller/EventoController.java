package com.itsqmet.prueba2.controller;

import com.itsqmet.prueba2.model.Evento;
import com.itsqmet.prueba2.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping
    public List<Evento> listarTodos() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Evento obtenerPorId(@PathVariable Long id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    public Evento crear(@RequestBody Evento evento) { return repository.save(evento); }

    @PutMapping("/{id}")
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return repository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repository.deleteById(id); }

    // Consultas requeridas 1, 3 y 5
    @GetMapping("/tipo/{tipo}")
    public List<Evento> porTipo(@PathVariable String tipo) {
        return repository.findByTipoOrderByNombreAsc(tipo);
    }

    @GetMapping("/filtrar")
    public List<Evento> porCapacidadYPonente(@RequestParam Integer capacidad, @RequestParam Long ponenteId) {
        return repository.findByCapacidadGreaterThanEqualAndPonenteId(capacidad, ponenteId);
    }

    @GetMapping("/ponente/{ponenteId}")
    public List<Evento> porPonenteFechas(@PathVariable Long ponenteId) {
        return repository.findByPonenteIdOrderByFechaDesc(ponenteId);
    }
}