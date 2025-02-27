FROM openjdk:17.0.1-jdk-slim

WORKDIR /app/java

COPY ./target/komorebi-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar app.jar
