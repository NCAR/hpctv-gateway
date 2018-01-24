FROM maven:3.5.2-jdk-8-alpine AS maven

ENV REFRESHED_AT 2018-01-22
LABEL repo=cisl-repo \
      name=hpctv-gateway \
      version=1.0

COPY src /usr/share/hpctv-gateway/
COPY pom.xml /usr/share/hpctv-gateway/

WORKDIR /usr/share/hpctv-gateway

RUN mvn package

FROM openjdk:8-jdk-alpine AS openjdk

EXPOSE 8443

COPY --from=maven /usr/share/hpctv-gateway/target/hpctv-gateway.jar /usr/share/hpctv-gateway/

VOLUME ["/tmp", "/run/secrets"]

CMD ["java","-Dhpctv-gateway.properties=/run/secrets/hpctv-gateway.properties","-jar","/usr/share/hpctv-gateway/hpctv-gateway.jar"]
