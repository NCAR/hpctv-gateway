FROM openjdk:8-jdk-alpine

ENV REFRESHED_AT 2018-01-22
LABEL repo=cisl-repo \
      name=hpctv-gateway \
      version=1.0

ARG APP_JAR
ADD ${APP_JAR} /usr/share/hpctv-gateway/hpctv-gateway.jar

ARG APP_PORT
EXPOSE ${APP_PORT}

VOLUME ["/tmp", "/run/secrets"]

CMD ["java","-Dhpctv-gateway.properties=/run/secrets/hpctv-gateway.properties","-jar","/usr/share/hpctv-gateway/hpctv-gateway.jar"]
