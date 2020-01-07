FROM openjdk:11.0.5-jre
ADD build/libs/smart-flowerpot-backend-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]