package com.oz.ethereum.rpc.client;

import lombok.Data;

/**
 * Created at 8/16/16, 00:38.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Data
public class Transaction {

    private String from;
    private String to;
    private Long gas;
    private Long gasPrice;
    private Long quantity;
    private String data;
    private Long nonce;

    public String sign(String privateKey) {
        // TODO : sign transaction.
        return null;
    }

}
