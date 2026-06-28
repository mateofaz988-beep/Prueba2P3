package com.itsqmet.prueba2.controller;

import com.itsqmet.prueba2.model.Evento;
import com.itsqmet.prueba2.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public List<Evento> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Evento obtenerPorId(@PathVariable Long id) { return service.obtenerPorId(id); }

    @PostMapping
    public Evento crear(@RequestBody Evento evento) { return service.crear(evento); }

    @PutMapping("/{id}")
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        return service.actualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }

    @GetMapping("/tipo/{tipo}")
    public List<Evento> porTipo(@PathVariable String tipo) { return service.porTipo(tipo); }

    @GetMapping("/filtrar")
    public List<Evento> porCapacidadYPonente(@RequestParam Integer capacidad, @RequestParam Long ponenteId) {
        return service.porCapacidadYPonente(capacidad, ponenteId);
    }

    @GetMapping("/ponente/{ponenteId}")
    public List<Evento> porPonenteFechas(@PathVariable Long ponenteId) { return service.porPonenteFechas(ponenteId); }

    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity<byte[]> descargarPdf() throws Exception {
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=eventos.pdf")
                .body(service.generarPdf());
    }
}