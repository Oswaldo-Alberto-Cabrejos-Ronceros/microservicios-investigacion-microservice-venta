package com.herramientas.microserviceventa.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    private Long id;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    private String direccion;

    private String dni;

    private LocalDate fechaNacimiento;
}
