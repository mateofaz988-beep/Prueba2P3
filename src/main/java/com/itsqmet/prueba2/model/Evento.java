package com.itsqmet.prueba2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 150)
    private String nombre;

    @NotBlank
    private String tipo;

    @NotBlank
    private String fecha;

    @NotNull
    @Min(1)
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "ponente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ponente ponente;
}