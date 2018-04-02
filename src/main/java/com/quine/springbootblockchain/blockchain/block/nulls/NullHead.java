package com.quine.springbootblockchain.blockchain.block.nulls;

import com.quine.springbootblockchain.blockchain.block.Head;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class NullHead extends Head {

    public NullHead() {
        super(NullValues.NULL_BLOCK_HASH, NullValues.NULL_LENGTH, NullValues.NULL_TIMESTAMP, NullValues.NULL_DATA_HASH);
    }

}
