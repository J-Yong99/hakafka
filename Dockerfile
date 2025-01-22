FROM openjdk:23-jdk-slim

RUN apt-get update && apt-get install -y findutils && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /app
WORKDIR /app

COPY .gradle .gradle

COPY build.gradle /app/build.gradle
COPY gradlew /app/gradlew

COPY gradle gradle
COPY src src

RUN chmod +x gradlew
RUN --mount=type=cache,target=/root/.gradle ./gradlew build -x test

COPY build/libs/*SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]