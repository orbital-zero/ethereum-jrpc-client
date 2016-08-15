package com.oz.ethereum.rpc.client.serialize.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 * Created at 8/14/16, 21:39.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
@Target(ElementType.TYPE)
public @interface MethodsConfiguration {

    MethodConfiguration[] configurations();

}
