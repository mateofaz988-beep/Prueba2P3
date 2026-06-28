package com.itsqmet.prueba2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String nombre;

    @NotBlank
    private String especialidad;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Min(0)
    private Integer anosExperiencia;
}