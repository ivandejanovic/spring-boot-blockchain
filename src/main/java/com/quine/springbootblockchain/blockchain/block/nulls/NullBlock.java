package com.quine.springbootblockchain.blockchain.block.nulls;

import com.quine.springbootblockchain.blockchain.block.Block;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public final class NullBlock extends Block {

    public NullBlock() {
        super(NullValues.NULL_HEAD, NullValues.NULL_DATA, NullValues.NULL_BLOCK_HASH);
    }

}
