package com.anticipalta.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Modelo_ML")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ModeloML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Long idModelo;

    @Column(name = "nombre_modelo", nullable = false, length = 100)
    private String nombreModelo;

    @Column(name = "fecha_entrenamiento")
    private LocalDate fechaEntrenamiento;

    @Column(name = "archivo_pkl", length = 255)
    private String archivoPkl;

    @Column(name = "precision")
    private Double precision;

    public ModeloML() {}

    public Long getIdModelo() { return idModelo; }
    public void setIdModelo(Long idModelo) { this.idModelo = idModelo; }
    public String getNombreModelo() { return nombreModelo; }
    public void setNombreModelo(String nombreModelo) { this.nombreModelo = nombreModelo; }
    public LocalDate getFechaEntrenamiento() { return fechaEntrenamiento; }
    public void setFechaEntrenamiento(LocalDate fechaEntrenamiento) { this.fechaEntrenamiento = fechaEntrenamiento; }
    public String getArchivoPkl() { return archivoPkl; }
    public void setArchivoPkl(String archivoPkl) { this.archivoPkl = archivoPkl; }
    public Double getPrecision() { return precision; }
    public void setPrecision(Double precision) { this.precision = precision; }
}