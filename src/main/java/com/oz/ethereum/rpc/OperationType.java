package com.oz.ethereum.rpc;

/**
 * Created at 8/12/16, 23:48.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 0.0.1
 */
public enum OperationType {

    SEND_RAW_TRANSACTION("eth_sendRawTransaction")
    ;

    private String operationType;

    private OperationType(String operationType) {
        this.operationType = this.operationType;
    }

}
