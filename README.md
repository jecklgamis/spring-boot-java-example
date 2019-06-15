## Spring Boot Java Example

[![Build Status](https://travis-ci.org/jecklgamis/spring-boot-java-example.svg?branch=master)](https://travis-ci.org/jecklgamis/spring-boot-java-example)

This is an example Spring Boot app using Java. 

* Uses Jetty web container
* Starts HTTP and HTTPs listener 
* Enables some actuator endpoints (health, metrics)

## Running The App
Ensure you have Java 8 or later.
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
curl -v -k https://localhost:8443/
```
Actuator endpoints:
* `http://localhost:8080/actuator/metrics`
* `http://localhost:8080/actuator/health`


