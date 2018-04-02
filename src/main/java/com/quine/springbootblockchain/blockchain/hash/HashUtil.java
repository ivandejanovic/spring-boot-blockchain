package com.quine.springbootblockchain.blockchain.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.quine.springbootblockchain.blockchain.exception.WrapperException;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 */
public final class HashUtil {

    private HashUtil() {
        throw new IllegalStateException("It is not allowed to call private constructor.");
    }

    public static byte[] calculateRawHash(byte[] rawBytes) {
        try {
            String hashAlgorithm = "SHA-256";

            return hash(hashAlgorithm, rawBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new WrapperException(".calculateRawHash", ex);
        }

    }

    private static byte[] hash(String hashAlgorithm, byte[] rawBytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
        md.update(rawBytes);
        byte[] digest = md.digest();

        return digest;
    }

}
