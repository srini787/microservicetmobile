FROM openjdk:8
ADD target/config-server-0.0.1-SNAPSHOT.jar docker-config-server-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-config-server-0.0.1-SNAPSHOT.jar"]