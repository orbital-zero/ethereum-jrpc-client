package com.oz.ethereum.rpc.client;

import com.oz.utils.Constants;
import com.oz.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.spongycastle.util.BigIntegers;

import java.math.BigInteger;

/**
 *
 * Created at 8/16/16, 00:38.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class Transaction {

    private static final BigInteger DEFAULT_GAS_PRICE = new BigInteger("20000000000");
    private static final BigInteger DEFAULT_GAS_LIMIT = new BigInteger("2000000");

    private BigInteger from;
    private BigInteger to;
    private BigInteger gas;
    private BigInteger gasPrice;
    private BigInteger value;
    private String data;
    private BigInteger nonce;
    private BigInteger hash;
    private String input;
    private BigInteger transactionIndex;
    private BigInteger blockHash;
    private BigInteger blockNumber;

    private String encodedTransaction;

    public Transaction() {
        super();
        this.gasPrice = DEFAULT_GAS_PRICE;
        this.gas = DEFAULT_GAS_LIMIT;
    }

    public Transaction(final BigInteger gasPrice, final BigInteger gasLimit) {
        super();
        this.gasPrice = gasPrice;
        this.gas = gasLimit;
    }

    public void sign(final BigInteger privKeyBytes) {
        byte[] privateKey = BigIntegers.asUnsignedByteArray(privKeyBytes);
        byte[] nonce = BigIntegers.asUnsignedByteArray(this.nonce);
        byte[] gasPrice = BigIntegers.asUnsignedByteArray(this.gasPrice);
        byte[] gasLimit = BigIntegers.asUnsignedByteArray(this.gas);
        byte[] toAddress = BigIntegers.asUnsignedByteArray(this.to);
        byte[] value = BigIntegers.asUnsignedByteArray(this.value);
        byte[] data = org.spongycastle.util.encoders.Hex.decode(this.data.replaceFirst(Constants.HEX_PREFIX, StringUtils.EMPTY));

        org.ethereum.core.Transaction rawTransaction = new org.ethereum.core.Transaction(
                nonce,
                gasPrice,
                gasLimit,
                toAddress,
                value,
                data);

        rawTransaction.sign(privateKey);
        this.encodedTransaction = Hex.encodeHexString(rawTransaction.getEncoded());
    }

}
