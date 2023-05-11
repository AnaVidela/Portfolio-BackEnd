FROM amazoncorrectto:11-alpine-jdk

COPY target/Backend-0.0.1-SNAPSHOT.jar port.jar

ENTRYPOINT ["java","-jar","/port.jar"]