FROM docker.io/eclipse-temurin:17 AS build
COPY . .
RUN apt update && apt install -y dpkg-dev rpm
RUN ./gradlew clean build jpackage
