USE finnova;

INSERT INTO transacciones (
    id,
    tipo,
    monto,
    descripcion,
    fecha,
    cuenta_id
)
VALUES

(
    UUID(),
    'DEPOSITO',
    2000000.00,
    'Deposito inicial',
    NOW(),
    '2a94558a-6a06-11f1-a690-0a0027000003'
),

(
    UUID(),
    'RETIRO',
    500000.00,
    'Retiro cajero automatico',
    NOW(),
    '2a94558a-6a06-11f1-a690-0a0027000003'
),

(
    UUID(),
    'DEPOSITO',
    1000000.00,
    'Pago de nomina',
    NOW(),
    '2a94721e-6a06-11f1-a690-0a0027000003'
),

(
    UUID(),
    'TRANSFERENCIA',
    300000.00,
    'Transferencia entre cuentas',
    NOW(),
    '2a94721e-6a06-11f1-a690-0a0027000003'
);