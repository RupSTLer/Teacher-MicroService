FROM openjdk:17
EXPOSE 9002
LABEL maintainer="RupSTLer"          
ADD target/teacher-microservice.jar teacher-microservice.jar
ENTRYPOINT ["java", "-jar", "teacher-microservice.jar"]