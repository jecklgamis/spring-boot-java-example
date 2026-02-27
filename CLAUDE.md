# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot 4.0.3 example application using Java 25 and Jetty (not Tomcat). Provides a REST API with actuator endpoints for health/metrics.

## Build & Test Commands

```bash
./mvnw clean package          # Build and run all tests
./mvnw test                   # Run tests only
./mvnw verify                 # Run tests + integration tests
make dist                     # Build JAR + generate keystore and build-info
make image                    # Build Docker image
make run                      # Run Docker container (ports 8080, 8443)
make up                       # Full build + run
```

Run a single test class:
```bash
./mvnw test -Dtest=RootControllerTest
```

## Architecture

- **Entry point**: `ExampleApp.java` — configures Jetty with HTTP on port 8080 (via `server.http.port`)
- **Controllers**: `RootController` (`/`), `ProbeController` (`/probe/live`, `/probe/ready`), `BuildInfoController` (`/buildInfo`)
- **Test base class**: `BaseAppTest` — uses `@SpringBootTest` with random port, provides `TestRestTemplate`, activates "dev" profile
- **Config**: `src/main/resources/application.yml` — SSL disabled by default, actuator endpoints exposed at `/actuator/health` and `/actuator/metrics`

## Key Details

- Java 25 required (enforced by maven-enforcer-plugin)
- Tomcat is explicitly excluded; Jetty is the embedded server
- `build-info.json` is generated at build time by `generate-build-info.sh` (git branch, commit, timestamp)
- Docker image: `jecklgamis/springboot-java-example:latest`, runs as non-root `app` user
- Helm chart in `deployment/k8s/helm/` for Kubernetes deployment
