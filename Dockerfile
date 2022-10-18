FROM openjdk:11
ADD target/sb-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]