package com.quine.springbootblockchain.blockchain;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 * <p>
 * Value object that contains data about current state of blockchain.
 */
public final class BlockChainStatus {

    private final long length;

    public BlockChainStatus(long length) {
        this.length = length;
    }

    public long getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        return "{ BlockChain : { Length: " + this.length + " } }";
    }

}
