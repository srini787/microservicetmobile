FROM openjdk:8
ADD target/eureka-service-0.0.1-SNAPSHOT.jar docker-eureka-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-eureka-service-0.0.1-SNAPSHOT.jar"] 