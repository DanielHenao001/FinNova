package com.finnova.backend.service;

import com.finnova.backend.dto.RolDto;
import com.finnova.backend.entity.RolEntity;
import com.finnova.backend.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolDto> obtenerRoles() {

        return rolRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    private RolDto convertirADto(RolEntity rol) {

        RolDto dto = new RolDto();

        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());

        return dto;
    }
}