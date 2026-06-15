\# Arquitectura Backend - FinNova



\## Objetivo



Definir la arquitectura utilizada por el backend de FinNova para garantizar mantenibilidad, escalabilidad y buenas prácticas de desarrollo.



\---



\# Tecnologías



\* Java 17

\* Spring Boot 3.x

\* Spring Data JPA

\* Spring Validation

\* MySQL

\* Maven

\* Lombok

\* JWT (futuro)



\---



\# Arquitectura



Se utilizará una arquitectura en capas.



```plaintext

Controller

&#x20;   ↓

Service

&#x20;   ↓

Repository

&#x20;   ↓

Database

```



\---



\# Estructura del Proyecto



```plaintext

src/main/java/com/finnova/backend



├── config

├── controller

├── dto

├── entity

├── exception

├── repository

├── service

```



\---



\## Controller



Responsabilidades:



\* Recibir peticiones HTTP.

\* Validar entradas básicas.

\* Delegar la lógica al Service.

\* Retornar respuestas HTTP.



No debe contener lógica de negocio.



\---



\## Service



Responsabilidades:



\* Implementar reglas de negocio.

\* Orquestar operaciones.

\* Validar procesos funcionales.

\* Comunicarse con Repository.



Toda la lógica de negocio debe vivir aquí.



\---



\## Repository



Responsabilidades:



\* Acceso a datos.

\* Operaciones CRUD.

\* Consultas personalizadas.



Implementado mediante Spring Data JPA.



\---



\## Entity



Responsabilidades:



\* Representar tablas de base de datos.

\* Definir relaciones JPA.



Ejemplos:



\* Usuario

\* Cuenta

\* Transaccion

\* Prestamo

\* Rol



\---



\## DTO



Responsabilidades:



\* Transporte de información entre capas.

\* Evitar exponer entidades directamente.



Ejemplos:



\* UsuarioRequestDTO

\* UsuarioResponseDTO



\---



\## Exception



Responsabilidades:



\* Manejo centralizado de errores.

\* Excepciones personalizadas.



Ejemplos:



\* UsuarioNoEncontradoException

\* CuentaNoEncontradaException



\---



\## Config



Responsabilidades:



\* Configuración global.

\* Seguridad.

\* CORS.

\* Beans.



\---



\# Flujo de una petición



Cliente



↓



Controller



↓



Service



↓



Repository



↓



MySQL



↓



Repository



↓



Service



↓



Controller



↓



Cliente



\---



\# Principios



\* Separación de responsabilidades.

\* Bajo acoplamiento.

\* Alta cohesión.

\* Código reutilizable.

\* Seguridad desde el diseño.

\* DTOs para intercambio de datos.

\* Contraseñas cifradas con BCrypt.

\* UUID como identificador principal.



