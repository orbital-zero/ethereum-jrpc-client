package com.oz.utils;

import java.math.BigInteger;

/**
 *
 * <p><b>Created:</b> 17/08/16, 11:59 AM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
public class HexUtils {

    private static final int PAD_LIMIT = 8192;

    public static <T extends Number> String zeroLeftPadHex(final T value, final int length) {
        return String.format("%0" + length + "x", value);
    }

    public static <T extends Number> String zeroLeftPadHexFixed(final T value, final int bytesLength) {
        return zeroLeftPadHex(value, bytesLength * 2);
    }

    public static String rightPadZeroFixed(String hexString, final int bytesLength) {
        final int length = hexString.length();
        final int bitsLength = bytesLength * 2;
        final int mod = length % bitsLength;

        if (mod == 0) {
            return hexString;
        }

        return String.format("%1$-" + (length + (bitsLength - mod)) + "s", hexString).replace(StringUtils.SPACE, "0");
    }

}
