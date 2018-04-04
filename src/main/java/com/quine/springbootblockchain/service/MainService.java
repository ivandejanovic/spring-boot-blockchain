package com.quine.springbootblockchain.service;

/**
 * @author Ivan Dejanovic
 */
public interface MainService {

    /**
     * Method that returns greetings message.
     *
     * @return greetings
     */
    public String greetings();

    /**
     * Method that calls another system (set through JVM parameters) to initiate block addition to blockchain.
     *
     * @return status
     */
    public String initiate();

    /**
     * Method that starts (on another thread) creation of new block and start operation for adding it to blockchain.
     *
     * @return status
     */
    public String block();

    /**
     * Method that syncs the ne block to blockchain.
     *
     * @param data
     *
     * @return status
     */
    public String sync(String data);
}
