FROM maven:3.8.2-jdk-8
ADD target/projectDevOps-0.0.1-SNAPSHOT.jar projectDevOps-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "projectDevOps-0.0.1-SNAPSHOT.jar"]