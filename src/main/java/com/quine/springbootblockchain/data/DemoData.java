package com.quine.springbootblockchain.data;

import java.util.UUID;

import com.quine.springbootblockchain.blockchain.block.data.Data;

/**
 * @author Ivan Dejanovic
 */

public class DemoData implements Data {
    private String data;

    public DemoData() {
        data = UUID.randomUUID().toString();
    }

    @Override
    public byte[] getRawData() {
        return data.getBytes();
    }
}
