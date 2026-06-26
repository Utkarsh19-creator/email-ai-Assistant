FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn/ .mvn/

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
