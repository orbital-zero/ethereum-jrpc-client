package com.oz.ethereum.rpc.exceptions;

/**
 * Created at 8/14/16, 22:46.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class EthereumRpcServerException extends RuntimeException {

    public EthereumRpcServerException() {
        super("There is an error calling the RPC Ethereum server or the output is wrong.");
    }

    public EthereumRpcServerException(String message) {
        super(message);
    }

}
