# Juegos Service

Microservicio encargado del catálogo de videojuegos: título, género, precio y descripción.

## Requisitos previos

- Java 17
- Maven
- MySQL corriendo en `localhost:3306`
- El **Eureka Server** (`infra/eureka-server`) debe estar corriendo en `http://localhost:8761` antes de levantar este microservicio

## 1. Clonar el repositorio

```bash
git clone <URL_DE_TU_REPOSITORIO>
cd juegos-service
```

## 2. Configurar la base de datos

Abre `src/main/resources/application.properties` y reemplaza `TU_PASSWORD_AQUI` por la contraseña de tu MySQL local.

## 3. Compilar

```bash
mvn clean install
```

## 4. Ejecutar

```bash
mvn spring-boot:run
```

La aplicación queda en `http://localhost:8082` (o accesible vía Gateway en `http://localhost:8080/api/juegos`).

## 5. Generar el .jar

```bash
mvn clean package
java -jar target/juegos-service-1.0.0.jar
```

## 6. Probar los endpoints con Postman

| Método | URL | Body (JSON) |
|---|---|---|
| GET | `http://localhost:8082/api/juegos` | — |
| GET | `http://localhost:8082/api/juegos/1` | — |
| POST | `http://localhost:8082/api/juegos` | `{"titulo":"Elden Ring","genero":"RPG","precio":39990,"descripcion":"Soulslike de mundo abierto"}` |
| PUT | `http://localhost:8082/api/juegos/1` | `{"titulo":"Elden Ring","genero":"RPG","precio":29990,"descripcion":"En oferta"}` |
| DELETE | `http://localhost:8082/api/juegos/1` | — |
