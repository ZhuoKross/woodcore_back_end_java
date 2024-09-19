package com.crud.crudProyecto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@Table(name = "tbl_proyecto")
public class Crudproyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proyecto", nullable = false)
    private Long id_proyecto;

    private String nombre_proyecto;
    private String prioridad;
    private LocalDate sprint;
    private String encargado_proyecto;
    private String miembros_proyecto;
    private String roles_proyecto;



}
