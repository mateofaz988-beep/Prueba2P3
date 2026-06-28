package com.itsqmet.prueba2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PerfilPonente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 500)
    private String biografia;

    @Size(max = 255)
    private String linkedin;

    @Size(max = 255)
    private String paginaWeb;

    @OneToOne
    @JoinColumn(name = "ponente_id")
    private Ponente ponente;
}