package com.oz.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <p><b>Created:</b> 17/08/16, 01:47 PM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
@Slf4j
public class HexUtilsTest {

    private static final String text = "486f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f";
    private static final String textRightPadExpected = "486f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f2c20686f6c61206d756e646f000000000000000000000000000000000000000000000000000000000000";

    @Test
    public void testZeroLeftPadHex() throws Exception {

    }

    @Test
    public void testZeroLeftPadHexFixed() throws Exception {

    }

    @Test
    public void testZeroRightPadHex() throws Exception {

    }

    @Test
    public void testZeroRightPadHexFixed() throws Exception {
        Assert.assertEquals("Right padding is ok", textRightPadExpected, PadUtils.rightPadZeroFixed(text, 32));
    }

}
