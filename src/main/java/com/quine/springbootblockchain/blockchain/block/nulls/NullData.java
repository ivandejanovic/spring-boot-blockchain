package com.quine.springbootblockchain.blockchain.block.nulls;

import com.quine.springbootblockchain.blockchain.block.data.Data;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public final class NullData implements Data {

    private static final String NULL_DATA = "Null Data";

    @Override
    public byte[] getRawData() {
        return NULL_DATA.getBytes();
    }

    @Override
    public String toString() {
        return NULL_DATA;
    }

}
