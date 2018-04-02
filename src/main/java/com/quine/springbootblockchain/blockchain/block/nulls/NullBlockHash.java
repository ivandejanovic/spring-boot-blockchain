package com.quine.springbootblockchain.blockchain.block.nulls;

import com.quine.springbootblockchain.blockchain.hash.BlockHash;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public final class NullBlockHash extends BlockHash {

    public NullBlockHash() {
        super(new byte[32]);
    }

}
