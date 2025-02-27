FROM openjdk:17.0.1-jdk-slim

RUN mkdir -p /app/java

COPY ./target/komorebi-0.0.1-SNAPSHOT.jar /app/java/app.jar

WORKDIR /app/java

ENTRYPOINT java -jar app.jar
