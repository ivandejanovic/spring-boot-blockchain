#!/bin/bash

java -Dname=System01 -DnextPort=8082 -jar target/spring-boot-blockchain-0.1.0.jar --server.port=8081&
java -Dname=System02 -DnextPort=8081 -jar target/spring-boot-blockchain-0.1.0.jar --server.port=8082&