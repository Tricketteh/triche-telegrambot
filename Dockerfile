# syntax=docker/dockerfile:1
FROM openjdk:latest
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=Smshitbot
ENV BOT_TOKEN=1923681342:AAFcj9_RbenlIy0-qOvI02jJK-umIiYT3hw
ENV BOT_DB_USERNAME=user
ENV BOT_DB_PASSWORD=password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-jar", "/app.jar"]