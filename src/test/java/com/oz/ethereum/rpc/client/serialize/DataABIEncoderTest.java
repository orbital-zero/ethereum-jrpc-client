package com.oz.ethereum.rpc.client.serialize;

import com.oz.ehtereum.rpc.test.pojo.ReadOnlyPojo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 *
 * <p><b>Created:</b> 18/08/16, 02:23 PM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
@Slf4j
public class DataABIEncoderTest {

    private static final String abiFullText = "0x959c7bdb00000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000060000000000000000000000000486f6c61206d756e646f2c20686f6c61206d756e000000000000000000000000000000000000000000000000000000000000008e53616d75656c205175696e74616e612054656c6c657a2c2053616d75656c205175696e74616e612054656c6c657a2c2053616d75656c205175696e74616e612054656c6c657a2c2053616d75656c205175696e74616e612054656c6c657a2c2053616d75656c205175696e74616e612054656c6c657a2c2053616d75656c205175696e74616e612054656c6c657a000000000000000000000000000000000000";

    private DataABIEncoder encoder;
    private ConfigurationsLoader condigurationsLoader;

    @Before
    public void init() throws ClassNotFoundException {
        this.condigurationsLoader = new AnnotationsConfigurationsLoader();
        this.condigurationsLoader.setPackageToScan("com.oz.ethereum.rpc.client.serialize");
        this.condigurationsLoader.loadConfigurations();
        this.encoder = new DataABIEncoder(this.condigurationsLoader);
    }

    @Test
    public void testEncode() {
        ReadOnlyPojo pojo = new ReadOnlyPojo();
        pojo.setAdult(true);
        pojo.setUsername("Samuel Quintana Tellez, Samuel Quintana Tellez, Samuel Quintana Tellez, Samuel Quintana Tellez, Samuel Quintana Tellez, Samuel Quintana Tellez");
        pojo.setUserAddress(new BigInteger("486f6c61206d756e646f2c20686f6c61206d756e", 16));

        final String abiTextEncoded = this.encoder.splitLists("readOnlyMethod", pojo);
        log.info("Abi text : {}" , abiTextEncoded);
        Assert.assertEquals(this.abiFullText, abiTextEncoded);
    }

}
