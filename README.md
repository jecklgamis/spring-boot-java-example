## Spring Boot Java Example

[![Build](https://github.com/jecklgamis/spring-boot-java-example/actions/workflows/build.yml/badge.svg)](https://github.com/jecklgamis/spring-boot-java-example/actions/workflows/build.yml)


This is an example Spring Boot app using Java.

* Uses Jetty web container
* Enables some actuator endpoints (health, metrics)

## Running The App
Ensure you have Java 21 or later.
```
./mvnw clean package
java -jar target/spring-boot-java-example.jar
```

## Running The App Using Docker
Ensure you have a working Docker environment.
```
make dist image run
```

## Testing The Endpoints
Point your browser to `http://localhost:8080` or use `curl` in command line.

```
curl -v  http://localhost:8080/
```
Actuator endpoints:
* `http://localhost:8080/actuator/metrics`
* `http://localhost:8080/actuator/health`


