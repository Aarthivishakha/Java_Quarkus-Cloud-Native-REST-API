# Quarkus Cloud-Native REST API (Java 8)

A production-shaped Quarkus REST microservice with health checks, versioned
CRUD endpoints, validation, centralized error responses, tests, container
packaging, CI, and exactly 12 integrated analysis-tool folders.

Java 8 requires the legacy Quarkus 1.13 line. Quarkus 2+ requires Java 11, so
this branch uses Quarkus `1.13.7.Final` and `javax.ws.rs` APIs. The application
build runs on Java 8; modern analysis tools run separately on Java 17 where
their current releases require a newer analyzer runtime.

## API

| Method | Path | Purpose |
|---|---|---|
| GET | `/health` | Liveness status |
| GET | `/api/v1/items` | List items |
| POST | `/api/v1/items` | Create an item |
| GET | `/api/v1/items/{id}` | Get an item |
| PUT | `/api/v1/items/{id}` | Replace an item |
| DELETE | `/api/v1/items/{id}` | Delete an item |

## Build and run

```bash
mvn test
mvn quarkus:dev
curl http://localhost:8080/health
```

Maven 3.8+ is required for the local build.

## Tools

`tool-triggers/` contains exactly 12 folders matching the requested Java tool
set. Each manifest targets this project's `src/main/java`, tests, `pom.xml`,
JaCoCo output, or Git history. See `tool-triggers/README.md`.

## Docker

The Dockerfile provides a repeatable Java 8 build/runtime and exposes port 8080.
Docker is optional for local development but useful for CI and deployment.
