package com.finnova.backend.service;

import com.finnova.backend.dto.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    public List<UsuarioDto> obtenerUsuarios() {

        return List.of(
                new UsuarioDto(1L, "Daniel Henao" ),
                new UsuarioDto(2L, "Carlos Lopez")
        );
    }
    public UsuarioDto obtenerUsuarioPorId(Long id) {

        return new UsuarioDto(id, "Usuario " + id);
    }
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {

        return usuarioDto;
    }
}