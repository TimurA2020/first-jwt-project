FROM maven:3.8.1-openjdk-17-slim AS Builder
WORKDIR /usr/src/
COPY pom.xml .
RUN mvn clean install -Dmaven.test.skip

FROM openjdk:17-oracle
WORKDIR /app
COPY --from=builder /usr/src/target/order-service*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]