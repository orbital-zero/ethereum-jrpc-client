package com.oz.ethereum.rpc.client;

import lombok.Data;

import java.math.BigInteger;

/**
 * <p><b>Created:</b> 16/08/16, 04:14 PM</p>
 *
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
@Data
public class TxJsonRpcResponse {

    private BigInteger id;
    private Double jsonrpc;
    private Transaction result;

}
