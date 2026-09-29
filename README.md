# Práctica Backend - API REST de Productos

API REST para gestionar un catálogo de productos, construida con **Java 17+**, **Spring Boot**, **Spring Data JPA** y **PostgreSQL (Supabase)**.

## Requisitos
- Java 17 o superior
- Maven 3.9+
- Una base de datos PostgreSQL (Supabase)

## Configuración
Define estas variables de entorno antes de ejecutar:

| Variable | Descripción |
|---|---|
| DB_URL | `jdbc:postgresql://HOST:5432/postgres?sslmode=require` |
| DB_USERNAME | `postgres.PROJECT_REF` |
| DB_PASSWORD | Contraseña de la base de datos |

Ejemplo en PowerShell:

```powershell
$env:DB_URL='jdbc:postgresql://HOST:5432/postgres?sslmode=require'
$env:DB_USERNAME='postgres.PROJECT_REF'
$env:DB_PASSWORD='tu_password'
```

> Se usa el *Session pooler* de Supabase (puerto 5432), compatible con redes IPv4.

## Ejecución
```bash
mvn spring-boot:run
```

## Pruebas
```bash
mvn test
```

## Endpoints

Base: `/api/products`

| Método | Ruta | Descripción | Respuesta |
|---|---|---|---|
| GET | `/api/products` | Lista todos los productos | 200 |
| GET | `/api/products/{id}` | Obtiene un producto por id | 200 / 404 |
| POST | `/api/products` | Crea un producto | 201 / 400 |
| PUT | `/api/products/{id}` | Actualiza un producto | 200 / 400 / 404 |
| DELETE | `/api/products/{id}` | Elimina un producto | 204 / 404 |

### Ejemplo de producto
```json
{
  "name": "Mouse",
  "description": "Inalámbrico",
  "price": 25.50,
  "stock": 10
}
```

### Validaciones
- `name`: obligatorio, máximo 100 caracteres
- `price`: obligatorio, mayor a 0
- `stock`: obligatorio, mayor o igual a 0

Si alguna falla, la API responde **400** con el detalle de los errores.

## Flujo de trabajo (GitFlow)
- `main`: versiones estables (etiquetadas)
- `develop`: integración
- `feature/*`: una rama por historia de usuario
- `release/*`: preparación de versiones

Se incluye `api-requests.http` para probar los endpoints con la extensión REST Client de VS Code.