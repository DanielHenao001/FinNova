USE finnova;

INSERT INTO cuentas (
    id,
    numero_cuenta,
    tipo_cuenta,
    saldo,
    estado,
    fecha_creacion,
    usuario_id
)
VALUES
(
    UUID(),
    '100000000001',
    'AHORROS',
    5000000.00,
    'ACTIVA',
    NOW(),
    '64a7c454-6a05-11f1-a690-0a0027000003'
),
(
    UUID(),
    '100000000002',
    'CORRIENTE',
    2500000.00,
    'ACTIVA',
    NOW(),
    '64a7e3bf-6a05-11f1-a690-0a0027000003'
);