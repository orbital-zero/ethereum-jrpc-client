package com.oz.ethereum.rpc.client.serialize.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 * Created at 8/13/16, 19:25.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Target(ElementType.ANNOTATION_TYPE)
public @interface SolidityParameter {

    String name();

    SolidityType type();

}
