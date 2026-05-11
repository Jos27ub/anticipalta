package com.anticipalta.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "resultado_real")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ResultadoReal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado")
    private Long idResultado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prediccion", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Prediccion prediccion;

    @Column(name = "produccion_real")
    private Double produccionReal;

    @Column(name = "margen_error")
    private Double margenError;

    @Column(name = "porcentaje_error")
    private Double porcentajeError;

    public ResultadoReal() {}

    public Long getIdResultado() { return idResultado; }
    public void setIdResultado(Long idResultado) { this.idResultado = idResultado; }
    public Prediccion getPrediccion() { return prediccion; }
    public void setPrediccion(Prediccion prediccion) { this.prediccion = prediccion; }
    public Double getProduccionReal() { return produccionReal; }
    public void setProduccionReal(Double produccionReal) { this.produccionReal = produccionReal; }
    public Double getMargenError() { return margenError; }
    public void setMargenError(Double margenError) { this.margenError = margenError; }
    public Double getPorcentajeError() { return porcentajeError; }
    public void setPorcentajeError(Double porcentajeError) { this.porcentajeError = porcentajeError; }
}