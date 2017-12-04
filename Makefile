default:
	cat ./Makefile
dist:
	./mvnw clean package
image:
	docker build -t springboot-java-example:latest .
run:
	docker run -p 8080:8080  -p 8443:8443 springboot-java-example:latest
run-bash:
	docker run -i -t springboot-java-example:latest /bin/bash
