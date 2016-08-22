package com.oz.ethereum.rpc.client;

import com.oz.encrypt.KeccakUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * Created at 8/16/16, 00:38.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class Transaction {

    private String from;
    private String to;
    private Long gas;
    private Long gasPrice;
    private Long quantity;
    private String data;
    private Long nonce;

    protected boolean parsed;
    //private ECKey.ECDSASignature signature;
    protected byte[] rlpEncoded;

    public void sign(String privKeyBytes) {
        byte[] hash = this.getRawHash();
        //ECKey key = ECKey.fromPrivate(privKeyBytes.getBytes()).decompress();
        //this.signature = key.sign(hash);
        //this.rlpEncoded = null;
    }

    public byte[] getRawHash() {
        if(!this.parsed) {
            //this.rlpParse();
        }

        byte[] plainMsg = {};// = this.getEncodedRaw();
        return KeccakUtils.sha3(plainMsg).getBytes();
    }

}
