package com.itsqmet.prueba2.repository;

import com.itsqmet.prueba2.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Consulta 1
    List<Evento> findByTipoOrderByNombreAsc(String tipo);

    // Consulta 3
    List<Evento> findByCapacidadGreaterThanEqualAndPonenteId(Integer capacidad, Long ponenteId);

    // Consulta 5
    List<Evento> findByPonenteIdOrderByFechaDesc(Long ponenteId);
}