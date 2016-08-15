package com.oz.encrypt;

import com.oz.utils.Constants;
import org.apache.commons.codec.binary.Hex;
import org.kocakosm.pitaya.security.Digest;
import org.kocakosm.pitaya.security.Digests;

/**
 * <p><b>Created:</b> 15/08/16, 04:57 PM</p>
 *
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
public class KeccakSigner {

    public static String getMethodId(String method) {
        Digest sha3 = Digests.keccak256();
        byte[] hash = sha3.digest(method.getBytes());
        return Constants.HEX_PREFIX + Hex.encodeHexString(hash);
    }

}
