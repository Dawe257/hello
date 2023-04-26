FROM gradle:latest AS build

COPY . /home/gradle/project
WORKDIR /home/gradle/project

RUN gradle build

FROM openjdk:17-alpine

RUN mkdir -p /app
COPY --from=build /home/gradle/project/build/bootJar/*.jar /app/app.jar

WORKDIR /app

ENTRYPOINT java -jar app.jar