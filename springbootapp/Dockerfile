FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD app.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./johan","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]