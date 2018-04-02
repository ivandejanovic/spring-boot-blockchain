/**
 *
 */
package com.quine.springbootblockchain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Dejanovic
 */

@Component
@Scope("prototype")
public class BlockchainServiceImpl implements Runnable {
    @Value("${name}")
    private String name;

    @Override
    public void run() {
        System.out.println("Block operation started in app name: " + name);
    }

}
