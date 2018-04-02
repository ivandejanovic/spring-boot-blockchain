package com.quine.springbootblockchain.blockchain.block;

import com.google.common.primitives.Longs;

import com.quine.springbootblockchain.blockchain.BlockUtil;
import com.quine.springbootblockchain.blockchain.block.nulls.NullBlockHash;
import com.quine.springbootblockchain.blockchain.hash.BlockHash;
import com.quine.springbootblockchain.blockchain.hash.DataHash;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class Head {

    private long timestamp;

    private final BlockHash prevBlockHash;

    private final long length;

    private int difficulty;

    private DataHash dataHash;

    private long nonce;

    public Head(BlockHash prevHash, long lenght, DataHash hashData, int difficulty) {
        this.timestamp = System.currentTimeMillis() / 1000;

        this.prevBlockHash = prevHash;

        this.length = lenght;

        this.difficulty = difficulty;

        this.dataHash = hashData;
    }

    protected Head(NullBlockHash nullBlockHash, long length, long nullTimestamp, DataHash nullDataHash) {
        this.prevBlockHash = nullBlockHash;
        this.length = length;
        this.timestamp = nullTimestamp;
        this.dataHash = nullDataHash;
    }

    public byte[] getRawHead() {
        byte[] rawPrevHash = new byte[32];
        if (this.prevBlockHash != null) {
            rawPrevHash = this.prevBlockHash.getRawHash();
        }

        byte[] rawLength = Longs.toByteArray(this.length);
        byte[] rawNonce = Longs.toByteArray(this.nonce);
        byte[] rawDifficulty = Longs.toByteArray(this.difficulty);
        byte[] rawTimestamp = Longs.toByteArray(this.timestamp);
        byte[] rawDataHash = this.dataHash.getRawHash();

        byte[] rawHead = BlockUtil.concatenateArrays(rawPrevHash, rawLength, rawNonce, rawDifficulty, rawTimestamp,
                rawDataHash);

        return rawHead;
    }

    public BlockHash getPrevHash() {
        return this.prevBlockHash;
    }

    public long getLength() {
        return this.length;
    }

    public void incNonce() {
        this.nonce++;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(System.lineSeparator());

        sb.append("\tPrev: " + this.prevBlockHash);
        sb.append(System.lineSeparator());

        sb.append("\tLength: " + this.length);
        sb.append(System.lineSeparator());

        sb.append("\tNonce: " + this.nonce);
        sb.append(System.lineSeparator());

        sb.append("\tDifficulty: " + this.difficulty);
        sb.append(System.lineSeparator());

        sb.append("\tTimestamp: " + this.timestamp);
        sb.append(System.lineSeparator());

        sb.append("\tData Hash: " + this.dataHash);
        sb.append(System.lineSeparator());

        sb.append("}");

        return sb.toString();
    }

}
