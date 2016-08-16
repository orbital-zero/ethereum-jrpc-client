package com.oz.ethereum.rpc.client.serialize;

import com.oz.ethereum.rpc.client.serialize.annotations.SolidityType;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import sun.reflect.misc.FieldUtil;

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

        List<String> headers = new ArrayList<>();
        List<String> data = new ArrayList<>();
        for (Configuration.Parameter param : config.getIn().getParameters()) {
            switch (param.getSolidityType()) {
                case STRING: {
                    String value = this.getValue(objectData, param.getAttributeName());
                    break;
                }
            }
        }

        return null;
    }

    public <T> T decode(String data, Class<T> clazzs) {
        return null;
    }

    public <T, U> U getValue(T objectData, String attributeName) {
        U value = null;
        try {
            value = (U) objectData.getClass().getField(attributeName).get(objectData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return value;
    }

}
