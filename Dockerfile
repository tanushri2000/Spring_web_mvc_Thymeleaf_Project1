FROM openjdk:11

EXPOSE 8080

COPY target/Spring-web-mvc-Thymeleaf-Project.jar /Spring-web-mvc-Thymeleaf-Project.jar

ENTRYPOINT ["java", "-jar", "/Spring-web-mvc-Thymeleaf-Project.jar"]





