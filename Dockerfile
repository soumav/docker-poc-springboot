FROM openjdk:17-oracle
#ENV MONGO_DB_USERNAME=admin \
#	MONGO_DB_PWD=password	
#VOLUME /tmp
#EXPOSE 8080
COPY ./wait /wait
RUN chmod +x /wait
ARG JAR_FILE=target/test-docker-springboot-bookdemo-app-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} sb-app.jar
CMD /wait && java -jar /sb-app.jar