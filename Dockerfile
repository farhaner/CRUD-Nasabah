FROM amazoncorretto:17.0.10-alpine
WORKDIR /app
COPY target/DataNasabah-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
