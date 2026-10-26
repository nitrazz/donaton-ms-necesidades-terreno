package com.gestionDonaton.gestion_necesidades_terreno.consumer;

import com.gestionDonaton.gestion_necesidades_terreno.dto.DonacionEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NecesidadesConsumer {

    /**
     * Escucha eventos asíncronos en AWS RabbitMQ (cola.notificaciones).
     */
    @RabbitListener(queues = "${app.rabbitmq.queues.notificaciones}")
    public void procesarNotificacionTerreno(DonacionEvent evento) {
        System.out.println("🚨 [MS-Necesidades / JDK 21] Alerta recibida desde AWS RabbitMQ:");
        System.out.println("   ID Donación: " + evento.idDonacion());
        System.out.println("   Donante: " + evento.donante());
        System.out.println("   Monto / Detalle: " + evento.monto());
        System.out.println("   Estado: " + evento.estado());

        // Aquí se puede vincular con NecesidadService para actualizar las necesidades en BD
        System.out.println("✅ Notificación procesada correctamente en terreno.");
    }
}