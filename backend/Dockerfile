FROM maven:3.8.1-jdk-11-slim AS build

WORKDIR /app

COPY ./mvnw .
COPY ./.mvn .mvn

COPY ./pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY ./src src

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11.0.7-slim

COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app

ENTRYPOINT [ "java", "-cp", "app:app/lib/*", "com.inprobe.product" ]