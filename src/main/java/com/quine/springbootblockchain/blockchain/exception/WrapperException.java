package com.quine.springbootblockchain.blockchain.exception;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public class WrapperException extends RuntimeException {

    private static final long serialVersionUID = -9135764168706871611L;

    public WrapperException(String message, Exception cause) {
        super(message, cause);
    }

}
