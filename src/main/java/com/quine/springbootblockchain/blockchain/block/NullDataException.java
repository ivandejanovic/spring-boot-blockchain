package com.quine.springbootblockchain.blockchain.block;

import com.quine.springbootblockchain.blockchain.exception.BlockChainException;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class NullDataException extends BlockChainException {

    private static final long serialVersionUID = -1031046769280836501L;

    public NullDataException(String message) {
        super(message);
    }

}
