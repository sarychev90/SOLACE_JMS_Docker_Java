# Build stage
FROM maven:3.8.6-openjdk-18 AS build
COPY . /home
RUN mvn -f /home/pom.xml clean install -pl :solaceJmsShare -pl :solaceJmsConsumer 

# Package stage
FROM openjdk:18.0-jdk-slim
ARG JAR_FILE=*.jar
COPY --from=build /home/solaceJmsConsumer/target/${JAR_FILE} /usr/local/lib/consumer.jar
EXPOSE 8070
CMD ["java","-jar","-Dspring.profiles.active=docker","/usr/local/lib/consumer.jar"]