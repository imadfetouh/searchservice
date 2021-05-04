FROM openjdk:11
EXPOSE 8088
ARG JAR_FILE=/searchservice/target/searchservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]