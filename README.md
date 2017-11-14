## SpringBoot Java Example

[![Build Status](https://travis-ci.org/jecklgamis/springboot-java-example.svg?branch=master)](https://travis-ci.org/jecklgamis/springboot-java-example)

This is an example SpringBoot app using Java. This uses the Jetty web container.

## Running The App
Ensure you have Java 8 or later
```
./mvnw clean package
java -jar target/springboot-java-example.jar
```

## Running The App In Docker

```
mvn clean package
docker build -t springboot-java-example .
docker run springboot-java-example
```


## Testing The Endpoint
Point your browser to http://localhost:8080 or use `curl` in command line.

```
curl -v  http://localhost:8080/
```


## JSON/XML Serialization Examples

GET JSON response

```
curl -v -H "Accept:application/json" http://localhost:8080/user/some-id
```

GET XML response
```
curl -v -H "Accept:application/xml" http://localhost:8080/user/some-id
```

PUT JSON request
```
curl -v  -X PUT  -H "Content-Type:application/json"  http://localhost:8080/user -d'{"username":"user","email":"user@example.com"}'
```

PUT XML request
```
curl -v  -X PUT  -H "Content-Type:application/xml"  http://localhost:8080/user -d'<?xml version="1.0" encoding="UTF-8" standalone="yes"?><user><username>me</username><email>me@example.com</email></user>'
```


## Makefile
A wrapper Makefile can save some keystrokes. `make dist image run` creates the jar, docker image, and runs the docker image

.Makefile
```
default:
	cat ./Makefile
dist:
	mvn clean package
image:
	docker build -t springboot-java-example:latest .
run:
	docker run -p 8080:8080 springboot-java-example:latest
run-bash:
	docker run -i -t springboot-java-example:latest /bin/bash
```

Have fun!


