package com.oz.ethereum.rpc.client.serialize;

/**
 * Created at 8/14/16, 22:02.
 *
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class AnnotationsConfigurationsLoader implements ConfigurationsLoader {

    private String packageToScan;
    private String[] packagesToScan;

    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    public void setPackagesToScan(String... packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public void loadConfigurations() {

    }

}
