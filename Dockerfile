FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

RUN useradd -m -s /bin/bash gymuser

COPY --from=build /app/target/*.jar app.jar

RUN chown -R gymuser:gymuser /app

USER gymuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
