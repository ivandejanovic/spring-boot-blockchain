package com.quine.springbootblockchain.blockchain.block.data;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public interface Data {

    /**
     * @return
     */
    public default byte[] getRawData() {
        // Implicit fill array with zeros - Java automatically fills with zeros array
        return new byte[32];
    }

}
