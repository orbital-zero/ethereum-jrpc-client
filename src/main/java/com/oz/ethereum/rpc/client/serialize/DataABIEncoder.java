package com.oz.ethereum.rpc.client.serialize;

import com.oz.utils.Constants;
import com.oz.utils.HexUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created at 8/12/16, 23:43.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Slf4j
public class DataABIEncoder {

    @Setter
    private ConfigurationsLoader configsLoader;

    private DataABIEncoder() {
        super();
    }

    public DataABIEncoder(ConfigurationsLoader configsLoader) {
        super();
        this.configsLoader = configsLoader;
    }

    public <T, X> String encode(String methodId, T objectData) {
        final Configuration config = this.configsLoader.getConfigs(methodId);

        List<String> data = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        StringBuffer encodedBuffer = new StringBuffer(Constants.HEX_PREFIX);
        encodedBuffer.append(config.getIn().getKeccak().substring(0, 8));

        for (Configuration.Parameter param : config.getIn().getParameters()) {
            switch (param.getSolidityType()) {
                case STRING: {
                    String value = this.getValue(objectData, param.getAttributeName());
                    String hexValue = String.format("%x", new BigInteger(1, value.getBytes()));
                    data.add(HexUtils.rightPadZeroFixed(hexValue, Constants.BLOCK_SIZE));
                    headers.add("L" + hexValue.length());
                    break;
                }
                case BOOL: {
                    Boolean value = this.getValue(objectData, param.getAttributeName());
                    data.add(this.serializeStaticNumberAbi(value ? 1 : 0));
                    headers.add(null);
                    break;
                }
                case UINT: case UINT_8: {
                    Integer value = this.getValue(objectData, param.getAttributeName());
                    data.add(this.serializeStaticNumberAbi(value));
                    headers.add(null);
                    break;
                }
                case UINT_32: case UINT_256: {
                    Long value = this.getValue(objectData, param.getAttributeName());
                    data.add(this.serializeStaticNumberAbi(value));
                    headers.add(null);
                    break;
                }
                case ADDRESS: {
                    BigInteger value = this.getValue(objectData, param.getAttributeName());
                    data.add(this.serializeStaticNumberAbi(value));
                    headers.add(null);
                    break;
                }
            }
        }

        return null;
    }

    public <T> T decode(String data, Class<T> clazzs) {
        return null;
    }

    private <T extends Number> String serializeStaticNumberAbi(T value) {
        return null;//HexUtils.zeroLeftPadHex(value);
    }

    public <T, U> U getValue(T objectData, String attributeName) {
        U value = null;
        try {
            value = (U) objectData.getClass().getField(attributeName).get(objectData);
        } catch (IllegalAccessException | NoSuchFieldException mulExc) {
            log.warn("The attribute {} is nor present or is inaccesibble in the class {}", attributeName, objectData.getClass().getName());
        }
        return value;
    }

}
