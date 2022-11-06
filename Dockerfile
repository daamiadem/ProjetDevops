FROM openjdk:8
EXPOSE 8088
ADD /target/DevopsProject-1.0.jar  DevopsProject-1.0.jar
ENTRYPOINT ["java", "-jar", "DevopsProject-1.0.jar"]