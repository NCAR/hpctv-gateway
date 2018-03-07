FROM openjdk:8-jdk-alpine AS openjdk

EXPOSE 8080

COPY target/hpctv-gateway.jar /usr/share/hpctv-gateway/hpctv-gateway.jar

VOLUME ["/tmp", "/var/log/hpctv-gateway", "/run/secrets"]

CMD ["java","-Dhpctv-gateway.log.dir=/var/log/hpctv-gateway","-Dhpctv-gateway.properties=/run/secrets/hpctv-gateway.properties","-jar","/usr/share/hpctv-gateway/hpctv-gateway.jar"]
