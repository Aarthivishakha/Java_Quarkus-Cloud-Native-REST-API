FROM maven:3.8.8-eclipse-temurin-8 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

FROM eclipse-temurin:8-jre
WORKDIR /service
COPY --from=build /workspace/target/lib/ ./lib/
COPY --from=build /workspace/target/*-runner.jar ./application.jar
EXPOSE 8080
USER 1001
CMD ["java", "-jar", "application.jar"]
