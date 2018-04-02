package com.quine.springbootblockchain.blockchain.hash;

import com.quine.springbootblockchain.blockchain.exception.BlockChainException;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */

public class NullHashException extends BlockChainException {

    private static final long serialVersionUID = -619561739986705441L;

    public NullHashException() {
        super();
    }

    public NullHashException(String message) {
        super(message);
    }

}
