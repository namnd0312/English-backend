
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} English-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/English-backend-0.0.1-SNAPSHOT.jar"]