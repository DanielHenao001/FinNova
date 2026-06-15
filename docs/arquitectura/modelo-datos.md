# Modelo de Datos - FinNova

## Objetivo

FinNova es una plataforma de banca digital desarrollada con Java Spring Boot, React y MySQL.

El objetivo de este documento es definir las entidades, relaciones, convenciones y reglas de negocio que servirán como base para el diseño de la base de datos y la implementación del backend.

---

# Convenciones Generales

## Base de Datos

### Nombres de tablas

Todas las tablas deben utilizar:

* snake_case
* minúsculas
* nombres en plural

Ejemplos:

```sql
usuarios
roles
cuentas
transacciones
prestamos
```

### Nombres de columnas

Todas las columnas deben utilizar:

* snake_case
* minúsculas

Ejemplos:

```sql
fecha_creacion
numero_cuenta
password_hash
```

### Claves primarias

Todas las tablas tendrán una clave primaria llamada:

```sql
id
```

Ejemplo:

```sql
usuarios
---------
id
nombre
email
```

### Tipo de Clave Primaria

Todas las entidades utilizarán UUID como identificador principal.

Implementación Java:

```java
UUID id;
```

Implementación MySQL:

```sql
CHAR(36)
```

Ejemplo:

```plaintext
550e8400-e29b-41d4-a716-446655440000
```

### Claves foráneas

Las claves foráneas utilizarán el formato:

```sql
<tabla>_id
```

Ejemplos:

```sql
usuario_id
cuenta_id
rol_id
```

---

# Convenciones Java

## Clases

Las entidades utilizarán PascalCase.

Ejemplos:

```java
Usuario
Cuenta
Transaccion
Prestamo
Rol
```

## Variables

Las propiedades utilizarán camelCase.

Ejemplos:

```java
nombre
email
passwordHash
fechaCreacion
```

---

# Seguridad

## Contraseñas

Las contraseñas nunca serán almacenadas en texto plano.

Se almacenará únicamente:

```sql
password_hash
```

Las contraseñas serán cifradas utilizando BCrypt antes de ser persistidas.

---

# Entidades Iniciales

## Rol

Representa el nivel de acceso dentro del sistema.

Campos preliminares:

* id
* nombre
* descripcion

Ejemplos de roles:

* ADMIN
* CLIENTE

---

## Usuario

Representa una persona registrada en la plataforma.

Campos preliminares:

* id
* nombre
* apellido
* email
* password_hash
* telefono
* fecha_creacion
* estado
* rol_id

Reglas:

* El email debe ser único.
* La contraseña se almacena como hash.
* Todo usuario debe tener un rol.

---

## Cuenta

Representa una cuenta bancaria asociada a un usuario.

Campos preliminares:

* id
* numero_cuenta
* tipo_cuenta
* saldo
* estado
* fecha_creacion
* usuario_id

Reglas:

* Un usuario puede tener múltiples cuentas.
* El número de cuenta debe ser único.
* El saldo nunca puede ser negativo.

---

## Transaccion

Representa un movimiento financiero realizado sobre una cuenta.

Campos preliminares:

* id
* tipo
* monto
* descripcion
* fecha
* cuenta_id

Tipos preliminares:

* DEPOSITO
* RETIRO
* TRANSFERENCIA

Reglas:

* Toda transacción pertenece a una cuenta.
* Toda transacción debe tener fecha.
* El monto debe ser mayor que cero.

---

## Prestamo

Representa una solicitud o crédito aprobado para un usuario.

Campos preliminares:

* id
* monto
* plazo_meses
* tasa_interes
* fecha_solicitud
* estado
* usuario_id

Estados preliminares:

* PENDIENTE
* APROBADO
* RECHAZADO
* PAGADO

Reglas:

* Todo préstamo pertenece a un usuario.
* El monto debe ser mayor que cero.

---

# Relaciones Iniciales

## Rol → Usuario

Relación:

```plaintext
1 : N
```

Un rol puede pertenecer a múltiples usuarios.

Un usuario solamente puede tener un rol.

---

## Usuario → Cuenta

Relación:

```plaintext
1 : N
```

Un usuario puede tener múltiples cuentas.

Una cuenta pertenece a un único usuario.

---

## Cuenta → Transaccion

Relación:

```plaintext
1 : N
```

Una cuenta puede tener múltiples transacciones.

Una transacción pertenece a una única cuenta.

---

## Usuario → Prestamo

Relación:

```plaintext
1 : N
```

Un usuario puede tener múltiples préstamos.

Un préstamo pertenece a un único usuario.

---

# Modelo Relacional Inicial

```plaintext
ROLES
 |
 | 1:N
 |
USUARIOS
 |
 | 1:N
 |
CUENTAS
 |
 | 1:N
 |
TRANSACCIONES

USUARIOS
 |
 | 1:N
 |
PRESTAMOS
```

---

# Tipos SQL Planeados

## UUID

```sql
CHAR(36)
```

## Texto corto

```sql
VARCHAR(100)
```

## Email

```sql
VARCHAR(150)
```

## Password Hash

```sql
VARCHAR(255)
```

## Valores monetarios

```sql
DECIMAL(15,2)
```

## Tasas de interés

```sql
DECIMAL(5,2)
```

## Fechas

```sql
DATETIME
```

---

# Restricciones Iniciales

## Usuarios

```sql
UNIQUE(email)
```

## Cuentas

```sql
UNIQUE(numero_cuenta)
```

## Roles

```sql
UNIQUE(nombre)
```

---

# Estado Actual del Modelo

Versión: V1

Objetivo:

* Construir una base sólida.
* Aplicar buenas prácticas de diseño.
* Implementar arquitectura en capas con Spring Boot.
* Mantener simplicidad antes de agregar características avanzadas.

---

# Pendientes por Definir

* Auditoría de acciones.
* Historial de cambios.
* Sistema de autenticación JWT.
* Recuperación de contraseña.
* Límites de transferencias.
* Tipos de cuentas adicionales.
* Gestión de cuotas de préstamos.
* Registro de sesiones.
* Notificaciones.
* Logs de seguridad.

---

Última actualización:

Junio 2026
FinNova v1

```
```
