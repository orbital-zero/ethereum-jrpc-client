package com.oz.ethereum.rpc.client;

import com.oz.ethereum.rpc.client.serialize.DataABIEncoder;
import com.oz.ethereum.rpc.exceptions.EthereumRpcServerException;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * <p><b>Created:</b> 16/08/16, 03:24 PM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
@Slf4j
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

        return this.execute(request, clazz);
    }

    public <U> void call(String methodId, U data) {
        this.call(methodId, data, BaseJsonRpcResponse.class);
    }

    public <U> BaseJsonRpcResponse sendRawTransaction(final BigInteger from, final BigInteger to, final String methodId,
          final U data, final BigInteger privateKey) {
        final BigInteger nonce = this.getTransactionCount(from).getResult();
        Transaction transaction = new Transaction();
        transaction.setData(this.dataAbiEncoder.encode(methodId, data));
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setNonce(nonce);

        transaction.sign(privateKey);

        JsonRpcRequest request = new JsonRpcRequest();
        request.setId(this.generateRandomId());
        request.setMethod(OperationType.SEND_RAW_TRANSACTION);

        request.getParams().add(transaction.getEncodedTransaction());

        return this.execute(request, BaseJsonRpcResponse.class);
    }

    public BaseJsonRpcResponse getTransactionCount(final BigInteger address) {
        JsonRpcRequest request = new JsonRpcRequest();
        request.setId(this.generateRandomId());
        request.setMethod(OperationType.GET_TRANSACTION_COUNT);

        request.getParams().add(address);
        request.getParams().add("latest");

        return this.execute(request, BaseJsonRpcResponse.class);
    }

    public TxJsonRpcResponse getTransactionByHash(final BigInteger transactionHash) {
        JsonRpcRequest request = new JsonRpcRequest();
        request.setId(this.generateRandomId());
        request.setMethod(OperationType.GET_TRANSACTION_BY_HASH);

        request.getParams().add(transactionHash);

        return this.execute(request, TxJsonRpcResponse.class);
    }

    private Integer generateRandomId() {
        return ThreadLocalRandom.current().nextInt(1, 999999999);
    }

    /**
     * Executes the method calling the json rpc API provided by geth.
     * @param request - Request information.
     * @param classTypeResponse - Response type, this one depends of the method.
     * @param <T> Response type.
     * @return Response of the call.
     */
    private <T> T execute(final JsonRpcRequest request, final Class<T> classTypeResponse) {
        T response = null;
        try {
            response = this.rpcClient.execute(request, classTypeResponse);
        } catch (IOException ioExc) {
            log.error("Error calling method {}", request.getMethod(), ioExc);
            throw new EthereumRpcServerException();
        }
        return response;
    }

}
