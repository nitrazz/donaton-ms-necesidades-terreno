package com.gestionDonaton.gestion_necesidades_terreno.service;

import com.gestionDonaton.gestion_necesidades_terreno.dto.NecesidadRequestDTO;
import com.gestionDonaton.gestion_necesidades_terreno.dto.NecesidadResponseDTO;
import com.gestionDonaton.gestion_necesidades_terreno.entity.Necesidad;
import com.gestionDonaton.gestion_necesidades_terreno.repository.NecesidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.gestionDonaton.gestion_necesidades_terreno.dto.NecesidadRequestDTO;
import com.gestionDonaton.gestion_necesidades_terreno.dto.NecesidadResponseDTO;
import com.gestionDonaton.gestion_necesidades_terreno.entity.Necesidad;
import com.gestionDonaton.gestion_necesidades_terreno.repository.NecesidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NecesidadService {

    private final NecesidadRepository necesidadRepository;

    // Constructor explícito para inyección de Spring (Reemplaza a @RequiredArgsConstructor)
    @Autowired
    public NecesidadService(NecesidadRepository necesidadRepository) {
        this.necesidadRepository = necesidadRepository;
    }

    public NecesidadResponseDTO reportarNecesidad(NecesidadRequestDTO request) {
        // Instanciación nativa sin usar .builder()
        Necesidad nuevaNecesidad = new Necesidad(
                request.getRecursoNecesitado(),
                request.getCantidad(),
                request.getUbicacionGeografica()
        );

        Necesidad necesidadGuardada = necesidadRepository.save(nuevaNecesidad);
        return mapToResponseDTO(necesidadGuardada);
    }

    public List<NecesidadResponseDTO> listarTodas() {
        return necesidadRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public NecesidadResponseDTO atenderNecesidad(Long id) {
        Necesidad necesidad = necesidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la necesidad con ID: " + id));

        necesidad.setEstado("ATENDIDA");
        Necesidad actualizada = necesidadRepository.save(necesidad);
        return mapToResponseDTO(actualizada);
    }

    // Método auxiliar con constructor nativo sin usar .builder()
    private NecesidadResponseDTO mapToResponseDTO(Necesidad necesidad) {
        return new NecesidadResponseDTO(
                necesidad.getId(),
                necesidad.getRecursoNecesitado(),
                necesidad.getCantidad(),
                necesidad.getUbicacionGeografica(),
                necesidad.getEstado(),
                necesidad.getFechaReporte()
        );
    }
}