package com.oz.ethereum.rpc.client;

/**
 * Created at 8/12/16, 23:48.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 0.0.1
 */
public enum OperationType {

    CALL("call"),
    SEND_RAW_TRANSACTION("eth_sendRawTransaction"),
    GET_TRANSACTION_COUNT("eth_getTransactionCount"),
    GET_TRANSACTION_BY_HASH("eth_getTransactionByHash"),
    ;

    private String operationType;

    private OperationType(String operationType) {
        this.operationType = this.operationType;
    }

    @Override
    public String toString() {
        return this.operationType;
    }

}
