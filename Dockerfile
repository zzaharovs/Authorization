FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080
ADD target/Authorization-1.0.0-SNAPSHOT.jar authorization.jar

CMD ["java", "-jar", "authorization.jar"]