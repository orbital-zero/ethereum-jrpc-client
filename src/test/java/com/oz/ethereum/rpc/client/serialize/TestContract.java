package com.oz.ethereum.rpc.client.serialize;

import com.oz.ethereum.rpc.client.serialize.annotations.MethodConfiguration;
import com.oz.ethereum.rpc.client.serialize.annotations.MethodsConfiguration;
import com.oz.ethereum.rpc.client.serialize.annotations.SolidityParameter;
import com.oz.ethereum.rpc.client.serialize.annotations.SolidityType;
import lombok.Data;

/**
 *
 * Created at 8/14/16, 10:01.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@MethodsConfiguration(configurations = {
    @MethodConfiguration(name = "baz", inParameters = {
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
    }, outParameters = {
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
    }),
    @MethodConfiguration(name = "baz", inParameters = {
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
            @SolidityParameter(name = "y", type = SolidityType.UINT_32),
    })
})
@Data
public class TestContract {

    private Boolean y;

}
