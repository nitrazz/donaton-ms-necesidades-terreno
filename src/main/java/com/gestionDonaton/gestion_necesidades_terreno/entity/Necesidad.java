package com.gestionDonaton.gestion_necesidades_terreno.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "necesidades")
public class Necesidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recurso_necesitado", nullable = false)
    private String recursoNecesitado;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "ubicacion_geografica", nullable = false)
    private String ubicacionGeografica;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_reporte", updatable = false)
    private LocalDateTime fechaReporte;

    // Constructor por defecto exigido por JPA
    public Necesidad() {}

    // Constructor personalizado para instanciación limpia
    public Necesidad(String recursoNecesitado, Integer cantidad, String ubicacionGeografica) {
        this.recursoNecesitado = recursoNecesitado;
        this.cantidad = cantidad;
        this.ubicacionGeografica = ubicacionGeografica;
    }

    @PrePersist
    protected void onCreate() {
        this.fechaReporte = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE";
        }
    }

    // Getters y Setters explícitos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecursoNecesitado() {
        return recursoNecesitado;
    }

    public void setRecursoNecesitado(String recursoNecesitado) {
        this.recursoNecesitado = recursoNecesitado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
}