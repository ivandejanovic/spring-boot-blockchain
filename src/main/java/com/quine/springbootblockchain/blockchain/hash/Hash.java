package com.quine.springbootblockchain.blockchain.hash;

import java.util.Arrays;

/**
 * Original implementation taken from https://github.com/djm-im/jLocalCoin
 *
 * @author djm.im
 * <p>
 * <p>
 * This is wrapper class for byte[]
 * <p>
 * TODO: the class should be immutable
 */
// TODO ???
// update to Hash be interface
public abstract class Hash extends ByteArray {

    private int hashCode;

    public Hash(byte[] bytes) {
        if (bytes == null) {
            throw new NullHashException("Hash cannot have null value.");
        }

        this.content = Arrays.copyOf(bytes, bytes.length);

        this.hashCode = Arrays.hashCode(this.content);
    }

    /**
     * @return Method returns byte array copy.
     */
    public byte[] getRawHash() {
        return Arrays.copyOf(this.content, this.content.length);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Hash other = (Hash) obj;

        byte[] bytes = other.content;
        if (this.content == null) {
            // if (bytes == null) true else false
            return bytes == null;
        }

        // ELSE: content is not null

        if (bytes == null) {
            return false;
        }

        if (this.content.length != bytes.length) {
            return false;
        }

        return Arrays.equals(this.content, bytes);
    }

    /**
     * @return Method returns hexadecimal representation of hash.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte aByte : this.content) {
            sb.append(String.format("%02X", aByte));
        }

        return sb.toString();
    }

}
