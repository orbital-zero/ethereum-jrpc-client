package com.oz.ethereum.rpc.client.serialize;

import com.oz.ethereum.rpc.client.serialize.ConfigurationsLoader;

/**
 * Created at 8/14/16, 22:35.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class XmlConfigurationsLoader implements ConfigurationsLoader {

    private String packageToScan;
    private String[] packagesToScan;

    @Override
    public void setPackageToScan(String setPackageToScan) {
        this.packageToScan = packageToScan;
    }

    @Override
    public void setPackagesToScan(String... setPackagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    @Override
    public void loadConfigurations() {
        // TODO
    }

}
