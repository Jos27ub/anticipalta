package com.anticipalta.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_suelo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoSuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_suelo")
    private Long idTipoSuelo;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    public TipoSuelo() {}

    public Long getIdTipoSuelo() { return idTipoSuelo; }
    public void setIdTipoSuelo(Long idTipoSuelo) { this.idTipoSuelo = idTipoSuelo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}