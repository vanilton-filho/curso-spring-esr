FROM openjdk:15-slim

WORKDIR /app

ARG JAR_FILE
COPY target/${JAR_FILE} api.jar
COPY wait-for-it.sh .

RUN chmod +x wait-for-it.sh

EXPOSE 8080
CMD ["java", "-jar", "api.jar"]
