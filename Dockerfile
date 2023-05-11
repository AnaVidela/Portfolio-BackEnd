FROM openjdk:11
COPY target/Backend-0.0.1-SNAPSHOT.jar port.jar
ENTRYPOINT ["java","-jar","/port.jar"]
EXPOSE  8080