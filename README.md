# Práctica Backend - API REST de Productos

API REST con Java Spring Boot, Spring Data JPA y PostgreSQL (Supabase).
## Requisitos
- Java 17+
- Maven 3.9+
- Una base de datos PostgreSQL (Supabase)

## Configuración
Define estas variables de entorno antes de ejecutar:

| Variable | Descripción |
|---|---|
| DB_URL | jdbc:postgresql://HOST:5432/postgres?sslmode=require |
| DB_USERNAME | postgres.PROJECT_REF |
| DB_PASSWORD | Contraseña de la base de datos |

## Ejecución
    mvn spring-boot:run