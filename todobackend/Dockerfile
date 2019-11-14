FROM openjdk:13-alpine
RUN mkdir -p /opt/todobackend
COPY target/todobackend-0.0.1-SNAPSHOT.jar /opt/todobackend.jar
CMD ["java", "-jar", "/opt/todobackend.jar"]