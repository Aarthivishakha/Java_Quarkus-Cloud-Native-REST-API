# Quarkus Cloud-Native REST API (Java 11)

A production-shaped Quarkus REST microservice with health checks, versioned
CRUD endpoints, validation, centralized error responses, tests, container
packaging, CI, and exactly 12 integrated analysis-tool folders.

This branch uses Quarkus `3.6.9`, the final Quarkus line that supports Java 11,
with Jakarta REST and Jakarta Validation APIs. Modern analyzers run separately
on Java 17 where their current releases require a newer analyzer runtime.

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

The Dockerfile provides a repeatable Java 11 build/runtime and exposes port 8080.
Docker is optional for local development but useful for CI and deployment.
