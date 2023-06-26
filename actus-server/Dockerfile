FROM openjdk:11
ARG JAR_FILE=actus-webapp/target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]
