package com.anticipalta.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediccion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prediccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prediccion")
    private Long idPrediccion;

    @Column(name = "fecha_ejecucion")
    private LocalDateTime fechaEjecucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fundo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fundo fundo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ModeloML modelo;

    @Column(name = "area_ha")
    private Double areaHa;

    @Column(name = "edad_anios")
    private Integer edadAnios;

    @Column(name = "temp_prom")
    private Double tempProm;

    @Column(name = "precip_mm")
    private Double precipMm;

    @Column(name = "rad_solar")
    private Double radSolar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_suelo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoSuelo tipoSuelo;

    @Column(name = "ph_suelo")
    private Double phSuelo;

    @Column(name = "rendimiento_estimado")
    private Double rendimientoEstimado;

    public Prediccion() {}

    public Long getIdPrediccion() { return idPrediccion; }
    public void setIdPrediccion(Long idPrediccion) { this.idPrediccion = idPrediccion; }
    public LocalDateTime getFechaEjecucion() { return fechaEjecucion; }
    public void setFechaEjecucion(LocalDateTime fechaEjecucion) { this.fechaEjecucion = fechaEjecucion; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Fundo getFundo() { return fundo; }
    public void setFundo(Fundo fundo) { this.fundo = fundo; }
    public ModeloML getModelo() { return modelo; }
    public void setModelo(ModeloML modelo) { this.modelo = modelo; }
    public Double getAreaHa() { return areaHa; }
    public void setAreaHa(Double areaHa) { this.areaHa = areaHa; }
    public Integer getEdadAnios() { return edadAnios; }
    public void setEdadAnios(Integer edadAnios) { this.edadAnios = edadAnios; }
    public Double getTempProm() { return tempProm; }
    public void setTempProm(Double tempProm) { this.tempProm = tempProm; }
    public Double getPrecipMm() { return precipMm; }
    public void setPrecipMm(Double precipMm) { this.precipMm = precipMm; }
    public Double getRadSolar() { return radSolar; }
    public void setRadSolar(Double radSolar) { this.radSolar = radSolar; }
    public TipoSuelo getTipoSuelo() { return tipoSuelo; }
    public void setTipoSuelo(TipoSuelo tipoSuelo) { this.tipoSuelo = tipoSuelo; }
    public Double getPhSuelo() { return phSuelo; }
    public void setPhSuelo(Double phSuelo) { this.phSuelo = phSuelo; }
    public Double getRendimientoEstimado() { return rendimientoEstimado; }
    public void setRendimientoEstimado(Double rendimientoEstimado) { this.rendimientoEstimado = rendimientoEstimado; }
}