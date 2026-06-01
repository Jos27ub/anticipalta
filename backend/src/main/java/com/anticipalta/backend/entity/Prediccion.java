package com.anticipalta.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediccion")
public class Prediccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prediccion")
    private Long idPrediccion;

    @Column(name = "fecha_ejecucion")
    private LocalDateTime fechaEjecucion;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "lote", length = 50)
    private String lote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fundo", nullable = false)
    private Fundo fundo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private ModeloML modelo;

    @Column(name = "area_ha")
    private Double areaHa;

    @Column(name = "edad_anios")
    private Integer edadAnios;

    @Column(name = "temp_c")
    private Double tempC;

    @Column(name = "prec_mm")
    private Double precMm;

    @Column(name = "rad_solar")
    private Double radSolar;

    @Column(name = "hum_rel")
    private Double humRel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_suelo", nullable = false)
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
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
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
    public Double getTempC() { return tempC; }
    public void setTempC(Double tempC) { this.tempC = tempC; }
    public Double getPrecMm() { return precMm; }
    public void setPrecMm(Double precMm) { this.precMm = precMm; }
    public Double getRadSolar() { return radSolar; }
    public void setRadSolar(Double radSolar) { this.radSolar = radSolar; }
    public Double getHumRel() { return humRel; }
    public void setHumRel(Double humRel) { this.humRel = humRel; }
    public TipoSuelo getTipoSuelo() { return tipoSuelo; }
    public void setTipoSuelo(TipoSuelo tipoSuelo) { this.tipoSuelo = tipoSuelo; }
    public Double getPhSuelo() { return phSuelo; }
    public void setPhSuelo(Double phSuelo) { this.phSuelo = phSuelo; }
    public Double getRendimientoEstimado() { return rendimientoEstimado; }
    public void setRendimientoEstimado(Double rendimientoEstimado) { this.rendimientoEstimado = rendimientoEstimado; }
}