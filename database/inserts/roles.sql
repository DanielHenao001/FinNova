USE finnova;

INSERT INTO roles (
    id,
    nombre,
    descripcion
)
VALUES
(
    UUID(),
    'ADMIN',
    'Administrador del sistema'
),
(
    UUID(),
    'CLIENTE',
    'Cliente de la plataforma'
);