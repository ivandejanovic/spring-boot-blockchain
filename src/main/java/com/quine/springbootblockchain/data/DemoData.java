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

    public DemoData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public byte[] getRawData() {
        return data.getBytes();
    }

    public String toString() {
        return data;
    }
}
