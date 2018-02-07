FROM maven:3.5.2-jdk-8-alpine AS maven

COPY src /usr/share/hpctv-gateway/src/
COPY pom.xml /usr/share/hpctv-gateway/
COPY maven-settings.xml /usr/share/hpctv-gateway/

WORKDIR /usr/share/hpctv-gateway

RUN mvn --settings maven-settings.xml package

FROM openjdk:8-jdk-alpine AS openjdk

LABEL repo=cisl-repo \
      name=hpctv-gateway \
      version=1.0

EXPOSE 8080

COPY --from=maven /usr/share/hpctv-gateway/target/hpctv-gateway.jar /usr/share/hpctv-gateway/hpctv-gateway.jar

VOLUME ["/tmp", "/run/secrets"]

ENTRYPOINT ["java","-Dhpctv-gateway.properties=/run/secrets/hpctv-gateway.properties","-jar","/usr/share/hpctv-gateway/hpctv-gateway.jar"]
