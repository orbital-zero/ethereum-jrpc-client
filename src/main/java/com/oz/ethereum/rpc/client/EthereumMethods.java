package com.oz.ethereum.rpc.client;

import com.oz.ethereum.rpc.client.serialize.DataABIEncoder;
import com.oz.ethereum.rpc.exceptions.EthereumRpcServerException;
import lombok.Setter;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p><b>Created:</b> 16/08/16, 03:24 PM</p>
 *
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
public class EthereumMethods {

    @Setter
    private JsonRpcClient rpcClient;
    @Setter
    private DataABIEncoder dataAbiEncoder;

    private EthereumMethods() {
        super();
    }

    private EthereumMethods(JsonRpcClient rpcClient, DataABIEncoder dataAbiEncoder) {
        super();
        this.rpcClient = rpcClient;
        this.dataAbiEncoder = dataAbiEncoder;
    }

    public <T, U> T call(String methodId, U data, Class<T> clazz) {
        JsonRpcRequest request = new JsonRpcRequest();
        request.setId(this.generateRandomId());
        request.setMethod(OperationType.CALL);

        request.getParams().add(this.dataAbiEncoder.encode(methodId, data));
        request.getParams().add("latest");

        T response = null;
        try {
            response = this.rpcClient.execute(request, clazz);
        } catch (IOException e) {
            throw new EthereumRpcServerException();
        }

        return response;
    }

    public <U> void call(String methodId, U data) {
        this.call(methodId, data, JsonRpcResponse.class);
    }

    public <T, U> T sendRawTransaction(BigInteger from, BigInteger to, String methodId, U data) {
        return null;
    }

    private Integer generateRandomId() {
        return ThreadLocalRandom.current().nextInt(1, 999999999);
    }

}
