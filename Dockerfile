FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY target/convenios-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8093

ENTRYPOINT ["java", "-jar", "app.jar"]