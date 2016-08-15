package com.oz.ethereum.rpc.client.serialize;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p><b>Created:</b> 15/08/16, 11:24 AM</p>
 *
 * @author <a href="mailto:sock.sqt@gmail.com">samuel</a>
 * @since 1.0.0
 */
public class AnnotationsConfigurationsLoaderTest {

    private ConfigurationsLoader loader;

    @Before
    public void init() {
        this.loader = new AnnotationsConfigurationsLoader();
        this.loader.setPackageToScan("com.oz.ethereum.rpc.client.serialize");
    }

    @Test
    public void testLoadConfigurations() throws Exception {
        this.loader.loadConfigurations();
    }

}
