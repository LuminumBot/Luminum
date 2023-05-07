FROM maven:3.9.1-eclipse-temurin-17-alpine

ARG LUMINUM_VERSION
ENV LUMINUM_VERSION=$LUMINUM_VERSION

WORKDIR /usr/src/app

RUN apk update && apk upgrade

COPY . .
RUN mvn package && mv ./target/Luminum-$LUMINUM_VERSION.jar /usr/bin/app.jar && cd .. && rm -rf ./app

WORKDIR /usr/bin
CMD exec java -jar app.jar
