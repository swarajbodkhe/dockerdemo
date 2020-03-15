FROM maven:3.6.3-jdk-8-slim

COPY src usr/myapp/src
COPY testng.xml usr/myapp
COPY pom.xml usr/myapp
RUN mvn -f usr/myapp/pom.xml clean test