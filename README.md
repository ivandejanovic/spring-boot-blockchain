# spring-boot-blockchain
SpringBoot Blockchain

This application is intended to be used as an demo of three systems using blockchain.

Once start.sh is executed the script starts two instances of the application. System01 listening on port 8081 and System02 listening on port 8082. System01 has System02 as its next system. System02 has System01 as its next system. All of this can be configured by modifying the start.sh script.

System is intended to be used in a following way. Once both systems are online hit /initiate endpoint on one of the systems. That system will call /block endpoint on its next system and return the response. The next system will respond to the call but will also start a new thread in which it will attempt to add a block to the chain. Once it adds a block to the chain it will send the block data to its next system by calling sync endpoint for blockchain sync.