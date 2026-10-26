package com.gestionDonaton.gestion_necesidades_terreno.dto;

import java.io.Serializable;

/**
 * Evento de donación recibido desde la cola de RabbitMQ (cola.notificaciones).
 * Implementado como Record nativo de Java 21 para inmutabilidad y deserialización directa.
 */
public record DonacionEvent(
        Long idDonacion,
        String donante,
        Double monto,
        String estado
) implements Serializable {}