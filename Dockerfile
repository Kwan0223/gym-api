FROM adoptopenjdk/openjdk11 AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle settings.gradle
COPY gradlew.bat .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew :bootJar

FROM adoptopenjdk/openjdk11
ARG PROFILE
COPY --from=builder build/libs/kwan-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]