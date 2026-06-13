package com.finnova.backend.controller;

import com.finnova.backend.dto.UsuarioDto;
import com.finnova.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<UsuarioDto> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }
    @GetMapping("/usuarios/{id}")
    public UsuarioDto obtenerUsuarioPorId(@PathVariable Long id) {

        return usuarioService.obtenerUsuarioPorId(id);
    }
    @PostMapping("/usuarios")
    public UsuarioDto crearUsuario(
            @RequestBody UsuarioDto usuarioDto) {

        return usuarioService.crearUsuario(usuarioDto);
    }
}