package com.finnova.backend.dto;

public class UsuarioDto {

    private Long id;
    private String nombre;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}