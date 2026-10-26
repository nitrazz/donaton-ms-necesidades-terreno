package com.gestionDonaton.gestion_necesidades_terreno.dto;



public class NecesidadRequestDTO {
    private String recursoNecesitado;
    private Integer cantidad;
    private String ubicacionGeografica;

    public NecesidadRequestDTO() {}

    public NecesidadRequestDTO(String recursoNecesitado, Integer cantidad, String ubicacionGeografica) {
        this.recursoNecesitado = recursoNecesitado;
        this.cantidad = cantidad;
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getRecursoNecesitado() { return recursoNecesitado; }
    public void setRecursoNecesitado(String recursoNecesitado) { this.recursoNecesitado = recursoNecesitado; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getUbicacionGeografica() { return ubicacionGeografica; }
    public void setUbicacionGeografica(String ubicacionGeografica) { this.ubicacionGeografica = ubicacionGeografica; }
}