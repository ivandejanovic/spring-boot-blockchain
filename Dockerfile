FROM java:8

#Copy Spring Boot application
COPY /target/spring-boot-blockchain-0.1.0.jar /target/spring-boot-blockchain-0.1.0.jar

#Copy start script
COPY start.sh start.sh

ENTRYPOINT ["start.sh"]

#Expose System01 port
EXPOSE 8081