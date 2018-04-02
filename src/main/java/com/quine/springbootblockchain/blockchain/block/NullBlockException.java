package com.quine.springbootblockchain.blockchain.block;

import com.quine.springbootblockchain.blockchain.exception.BlockChainException;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class NullBlockException extends BlockChainException {

    private static final long serialVersionUID = -7697007268158053867L;

    public NullBlockException(String message) {
        super(message);
    }

}
