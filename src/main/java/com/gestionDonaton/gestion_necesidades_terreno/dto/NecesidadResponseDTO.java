package com.gestionDonaton.gestion_necesidades_terreno.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class NecesidadResponseDTO {
    private Long id;
    private String recursoNecesitado;
    private Integer cantidad;
    private String ubicacionGeografica;
    private String estado;
    private LocalDateTime fechaReporte;

    public NecesidadResponseDTO() {}

    public NecesidadResponseDTO(Long id, String recursoNecesitado, Integer cantidad, String ubicacionGeografica, String estado, LocalDateTime fechaReporte) {
        this.id = id;
        this.recursoNecesitado = recursoNecesitado;
        this.cantidad = cantidad;
        this.ubicacionGeografica = ubicacionGeografica;
        this.estado = estado;
        this.fechaReporte = fechaReporte;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRecursoNecesitado() { return recursoNecesitado; }
    public void setRecursoNecesitado(String recursoNecesitado) { this.recursoNecesitado = recursoNecesitado; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getUbicacionGeografica() { return ubicacionGeografica; }
    public void setUbicacionGeografica(String ubicacionGeografica) { this.ubicacionGeografica = ubicacionGeografica; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaReporte() { return fechaReporte; }
    public void setFechaReporte(LocalDateTime fechaReporte) { this.fechaReporte = fechaReporte; }
}