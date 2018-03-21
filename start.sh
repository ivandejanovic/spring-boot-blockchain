#!/bin/bash

java -Dname=System01 -Dport=8082 -jar target/spring-boot-blockchain-0.1.0.jar --server.port=8081&
java -Dname=System02 -Dport=8083 -jar target/spring-boot-blockchain-0.1.0.jar --server.port=8082&
java -Dname=System03 -Dport=8081 -jar target/spring-boot-blockchain-0.1.0.jar --server.port=8083&