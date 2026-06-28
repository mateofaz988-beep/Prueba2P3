package com.itsqmet.prueba2.repository;

import com.itsqmet.prueba2.model.Ponente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PonenteRepository extends JpaRepository<Ponente, Long> {
    // Consulta 2
    List<Ponente> findByEspecialidadContainingIgnoreCase(String keyword);
}