FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /service
COPY --from=build /workspace/target/quarkus-app/ ./
EXPOSE 8080
USER 1001
CMD ["java", "-jar", "quarkus-run.jar"]
