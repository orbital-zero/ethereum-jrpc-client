package com.oz.ethereum.rpc.client.serialize.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created at 8/14/16, 10:22.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 0.0.1
 */
@Target(ElementType.TYPE)
public @interface MethodConfiguration {

    /**
     * (Optional) Method name, is required only for MethodType.OUT
     * @return
     */
    String name() default "";

    SolidityParameter[] inParameters() default {};

    SolidityParameter[] outParameters() default {};

}
