FROM maven:3.5.2-jdk-8-alpine AS buildimage

LABEL buildstage=true

COPY src /usr/share/hpctv-gateway/src/
COPY pom.xml /usr/share/hpctv-gateway/
COPY maven-settings.xml /usr/share/hpctv-gateway/

WORKDIR /usr/share/hpctv-gateway

RUN mvn --settings maven-settings.xml --quiet package

FROM openjdk:8-jdk-alpine AS openjdk

EXPOSE 8080

COPY --from=buildimage /usr/share/hpctv-gateway/target/hpctv-gateway.jar /usr/share/hpctv-gateway/hpctv-gateway.jar

VOLUME ["/tmp", "/var/log/hpctv-gateway", "/run/secrets"]

CMD ["java","-Dhpctv-gateway.log.dir=/var/log/hpctv-gateway","-Dhpctv-gateway.properties=/run/secrets/hpctv-gateway.properties","-jar","/usr/share/hpctv-gateway/hpctv-gateway.jar"]
