package com.finnova.backend.controller;

import com.finnova.backend.dto.RolDto;
import com.finnova.backend.service.RolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/roles")
    public List<RolDto> obtenerRoles() {
        return rolService.obtenerRoles();
    }
}