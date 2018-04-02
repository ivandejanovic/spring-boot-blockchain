package com.quine.springbootblockchain.blockchain.block.data;

import java.util.List;
import java.util.function.Predicate;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @param <T>
 * @author djm.im
 */
public interface Validator<T> {

    /**
     * @param data
     * @return
     */
    public default boolean isValid(T tt, List<Predicate<T>> rules) {
        for (Predicate<T> rule : rules) {
            if (!rule.test(tt)) {
                return false;
            }
        }
        return true;
    }

}
