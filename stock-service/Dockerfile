FROM openjdk:8
ADD target/stock-service-0.0.1-SNAPSHOT.jar docker-stock-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-stock-service-0.0.1-SNAPSHOT.jar"]