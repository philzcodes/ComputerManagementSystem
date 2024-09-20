
#
# Build stage
#
FROM maven:3.9.1-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package

#
# Package stage
#
FROM eclipse-temurin:17-jdk
COPY --from=build /target/Iron-Fx-Funds-0.0.1-SNAPSHOT.jar Iron-Fx-Funds.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Iron-Fx-Funds.jar"]



