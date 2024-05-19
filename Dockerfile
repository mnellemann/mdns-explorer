FROM docker.io/eclipse-temurin:21 AS build
COPY . .
RUN apt update && apt install -y dpkg-dev rpm
RUN ./gradlew clean build jpackage
