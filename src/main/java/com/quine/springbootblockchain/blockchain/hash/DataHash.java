package com.quine.springbootblockchain.blockchain.hash;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class DataHash extends Hash {

    public DataHash(byte[] bytes) {
        super(bytes);
    }

    public static DataHash hash(byte[] rawData) {
        byte[] hashBytes = HashUtil.calculateRawHash(rawData);

        return new DataHash(hashBytes);
    }

}
