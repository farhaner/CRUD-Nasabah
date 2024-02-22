FROM maven:3.8.5-openjdk-17-slim AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
COPY . $HOME
RUN mvn -Dmaven.test.skip=true clean package

FROM openjdk:20-ea-17-slim-buster
WORKDIR /usr/app
COPY --from=build /usr/app/target/*.jar /usr/app/*.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/*.jar"]

#FROM amazoncorretto:17.0.10-alpine
#WORKDIR /app
#COPY target/DataNasabah-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]