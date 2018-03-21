FROM java:8

COPY /target/spring-boot-demo-0.1.0.jar /spring-boot-demo-0.1.0.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-demo-0.1.0.jar"]