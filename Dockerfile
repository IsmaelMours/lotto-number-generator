FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/Lotto-number-generator-0.0.1-SNAPSHOT.jar Lotto-number-generator-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "Lotto-number-generator-0.0.1-SNAPSHOT.jar"]