FROM amazoncorrectto:11
COPY target/Backend-0.0.1-SNAPSHOT port.jar
ENTRYPOINT ["java","-jar","/port.jar"]