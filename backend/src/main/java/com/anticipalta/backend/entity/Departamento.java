package com.anticipalta.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nombre_depa", nullable = false, length = 100)
    private String nombreDepa;

    public Departamento() {}

    public Long getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Long idDepartamento) { this.idDepartamento = idDepartamento; }
    public String getNombreDepa() { return nombreDepa; }
    public void setNombreDepa(String nombreDepa) { this.nombreDepa = nombreDepa; }
}