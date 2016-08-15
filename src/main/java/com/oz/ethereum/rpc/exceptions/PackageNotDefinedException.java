package com.oz.ethereum.rpc.exceptions;

/**
 * Created at 8/14/16, 22:46.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class PackageNotDefinedException extends RuntimeException {

    public PackageNotDefinedException() {
        super("Package to scan not defined.");
    }

    public PackageNotDefinedException(String message) {
        super(message);
    }

}
