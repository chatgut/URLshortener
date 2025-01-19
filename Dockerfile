FROM openjdk:21-jdk-slim as build

RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/UrlShortener1-0.0.1-SNAPSHOT.jar /app/UrlShortener1.jar

EXPOSE 8080

CMD ["java", "-jar", "UrlShortener1.jar"]
