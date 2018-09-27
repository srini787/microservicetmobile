FROM openjdk:8
ADD target/db-service-0.0.1-SNAPSHOT.jar docker-db-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-db-service-0.0.1-SNAPSHOT.jar"]