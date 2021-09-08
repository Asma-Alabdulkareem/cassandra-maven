FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /app

COPY src ./src

COPY pom.xml ./

RUN mvn -f pom.xml clean install

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/spring-boot-cassandra-0.0.1-SNAPSHOT.jar ./mvn_cassandra.jar

EXPOSE 9003

CMD ["java","-jar","/app/mvn_cassandra.jar"]
