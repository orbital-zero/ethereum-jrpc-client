package com.oz.utils;

/**
 * Created at 8/14/16, 22:40.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class StringUtils {

    public static final String SPACE = " ";

    public static boolean isEmpty(final String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isNotEmpty(final String string) {
        return !isEmpty(string);
    }

}
