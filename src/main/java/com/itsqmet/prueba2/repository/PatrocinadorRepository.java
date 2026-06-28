package com.itsqmet.prueba2.repository;

import com.itsqmet.prueba2.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
    // Consulta 4
    List<Patrocinador> findByMontoAporteBetweenOrderByMontoAporteDesc(Double min, Double max);
}