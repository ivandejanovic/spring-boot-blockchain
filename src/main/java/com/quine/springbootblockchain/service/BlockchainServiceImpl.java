/**
 *
 */
package com.quine.springbootblockchain.service;

import com.quine.springbootblockchain.data.DemoData;

import com.quine.springbootblockchain.blockchain.BlockChain;
import com.quine.springbootblockchain.blockchain.block.Block;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ivan Dejanovic
 */

@Component
@Scope("prototype")
public class BlockchainServiceImpl implements Runnable {
    @Value("${name}")
    private String name;

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
        Block block = new Block(prevBlock, demoData);
    }

}
