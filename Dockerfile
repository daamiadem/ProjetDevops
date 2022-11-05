FROM openjdk:8

ADD /target/DevopsProject-1.0.jar  DevopsProject-1.0.jar
ENTRYPOINT ["java", "-jar", "DevopsProject-1.0.jar"]