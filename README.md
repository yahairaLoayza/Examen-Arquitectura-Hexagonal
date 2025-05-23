﻿# Examen-Arquitectura-Hexagonal
Este proyecto implementa una solución basada en arquitectura hexagonal modular con el objetivo de consumir información de empresas desde la API de SUNAT y almacenarla en una base de datos PostgreSQL. Se incluyen funcionalidades CRUD, respuesta estandarizada, manejo de errores y tres métodos de consumo de la API externa (RestTemplate, OpenFeign, Retrofit).

📁 Estructura del Proyecto (Módulos):

domain: Contiene las entidades de negocio (Empresa), interfaces de puertos y lógica empresarial.

application: Implementa los casos de uso y servicios de aplicación.

infrastructure: Contiene la lógica de persistencia (JPA), controladores REST, adaptadores a la API SUNAT y configuración.

⚙️ Tecnologías Utilizadas:

Java 17

Spring Boot 3+

Spring Data JPA

PostgreSQL

OpenFeign

Retrofit2

RestTemplate

Lombok

Maven

Arquitectura Hexagonal

🚀 Configuración Inicial:

Base de Datos

Crear una base de datos llamada empresa_db en PostgreSQL:

CREATE DATABASE empresa_db;

Configuración application.yml o application.properties

spring:
datasource:
url: jdbc:postgresql://localhost:5432/empresa_db
username: postgres
password: admin
jpa:
hibernate:
ddl-auto: update
show-sql: true

token:
api: apis-token-14589.xAnvbI1zFUP9ucNJPBMVjwctnPBwP45n


📡 Consumo de la API SUNAT

La API externa consultada es:

(https://api.apis.net.pe/v2/sunat/ruc/full?numero=20601030013)

Para obtener los datos de una empresa por su RUC, el sistema implementa:

RestTemplate

OpenFeign

Retrofit

Estos métodos están disponibles en el UseCase SunatUseCaseImpl.

🧱 Entidad Empresa

Se define con los siguientes campos:

razonSocial

numeroDocumento

estado

condicion

direccion

departamento

provincia

distrito

actividadEconomica

numeroTrabajadores

La clase usa el patrón Builder (Lombok @Builder).

📌 Endpoints CRUD

GET /api/empresas/{id} → Obtener empresa por ID
GET /api/empresas → Listar todas las empresas
POST /api/empresas/registrar/{ruc} → Registrar empresa desde SUNAT por RUC
PUT /api/empresas/{id} → Actualizar empresa
DELETE /api/empresas/{id} → Eliminar empresa

Todos los endpoints responden con la siguiente estructura estándar:

{
"codigo": 200,
"mensaje": "Operación exitosa",
"data": {...}
}

❗ Manejo de Errores

El sistema maneja errores globalmente con mensajes personalizados:

400: Los datos enviados son inválidos

404: No se encontró la empresa solicitada

500: Ocurrió un error inesperado en el sistema

