package com.crud.crudProyecto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_Task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private Long id_task;
    private String nombre_tarea;
    private String estado;
    private String encargado;
    private String prioridad;
    private String resumen;

}
