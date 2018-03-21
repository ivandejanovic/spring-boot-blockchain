FROM java:8

COPY /target/spring-boot-blockchain-0.1.0.jar /spring-boot-blockchain-0.1.0.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-blockchain-0.1.0.jar"]