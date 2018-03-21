# spring-boot-blockchain
SpringBoot Blockchain

This application is intended to be used as an demo of three systems using blockchain.

Once start.sh is executed the script starts three instances of the application. System01 listening on port 8081, System02 listening on port 8082 and System03 listening on port 8083. System01 has System02 as its next system. System02 has System03 as its next system. System03 has System01 as its next system. All of this can be configured by modifying the start.sh script.

System is intended to be used in a following way. Once all three systems are online hit /initiate endpoint on one of the systems. That system will call /block endpoint on its next system and return the response. The next system will respond to the call but will also start a new thread in which it will attempt to add a block to the chain. The other two systems will act as miners.