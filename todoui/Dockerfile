FROM openjdk:13-alpine
RUN mkdir -p /opt/todoui
COPY target/todoui-0.0.1-SNAPSHOT.jar /opt/todoui.jar
CMD ["java", "-jar", "/opt/todoui.jar"]