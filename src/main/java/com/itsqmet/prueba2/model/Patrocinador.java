package com.itsqmet.prueba2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String empresa;

    @NotBlank
    private String sector;

    @NotNull
    @Min(1)
    private Double montoAporte;

    @ManyToMany
    @JoinTable(
            name = "patrocinador_evento",
            joinColumns = @JoinColumn(name = "patrocinador_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;
}