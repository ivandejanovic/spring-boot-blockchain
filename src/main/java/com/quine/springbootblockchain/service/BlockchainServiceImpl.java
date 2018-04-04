package com.quine.springbootblockchain.service;

import com.quine.springbootblockchain.blockchain.block.Miner;
import com.quine.springbootblockchain.data.DemoData;

import com.quine.springbootblockchain.blockchain.BlockChain;
import com.quine.springbootblockchain.blockchain.block.Block;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ivan Dejanovic
 */

@Component
@Scope("prototype")
public class BlockchainServiceImpl implements Runnable {
    @Value("${name}")
    private String name;

    @Value("${nextPort}")
    private String nextPort;

    private static final Logger logger = LoggerFactory.getLogger(BlockchainServiceImpl.class);

    private BlockChain blockChain;

    @PostConstruct
    public void init() {
        logger.info("Block service initiated in app name: " + name);

        blockChain = new BlockChain();
    }

    @Override
    public void run() {
        logger.info("Block operation started in app name: " + name);

        Block prevBlock = blockChain.getTopBlock();
        DemoData demoData = new DemoData();
        Block block = Miner.createNewBlock(prevBlock, demoData);
        blockChain.add(block);

        logger.info("Data: " + demoData.toString() + " added to BlockChain in app name: " + name);

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:" + nextPort + "/sync";
            HttpEntity<String> request = new HttpEntity<>(new String(demoData.toString()));
            String response = restTemplate.postForObject(url, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public String sync(String data) {
        Block prevBlock = blockChain.getTopBlock();
        DemoData demoData = new DemoData(data);
        Block block = Miner.createNewBlock(prevBlock, demoData);
        blockChain.add(block);

        logger.info("Data: " + demoData.toString() + " added to BlockChain in app name: " + name);

        return "OK";
    }
}
