package com.quine.springbootblockchain.blockchain;

import com.quine.springbootblockchain.blockchain.block.Block;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class BlockWrapper {

    private Block block;

    private BlockWrapper prevBlockWrapper;

    public BlockWrapper(Block block, BlockWrapper prevBlockWrapper) {
        this.block = block;
        this.prevBlockWrapper = prevBlockWrapper;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockWrapper getPrevBlockWrapper() {
        return this.prevBlockWrapper;
    }

}
