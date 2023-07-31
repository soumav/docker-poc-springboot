FROM openjdk:17-oracle
ARG JAR_FILE=target/test-docker-springboot-bookdemo-app-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} sb-app.jar
ENTRYPOINT ["java","-jar","/sb-app.jar"]