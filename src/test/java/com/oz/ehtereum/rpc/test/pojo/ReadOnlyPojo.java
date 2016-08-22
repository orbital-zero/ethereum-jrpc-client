package com.oz.ehtereum.rpc.test.pojo;

import com.oz.ethereum.rpc.client.serialize.annotations.SolidityParameter;
import com.oz.ethereum.rpc.client.serialize.annotations.SolidityType;
import lombok.Data;

import java.math.BigInteger;

/**
 *
 * <p><b>Created:</b> 18/08/16, 02:30 PM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
@Data
public class ReadOnlyPojo {

    private BigInteger userAddress;
    private boolean isAdult;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer id;
    private Integer age;

}
