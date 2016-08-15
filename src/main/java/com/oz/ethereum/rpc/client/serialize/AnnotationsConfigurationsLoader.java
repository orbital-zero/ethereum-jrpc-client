package com.oz.ethereum.rpc.client.serialize;

import com.oz.ethereum.rpc.exceptions.PackageNotDefinedException;
import com.oz.utils.ArrayUtils;
import com.oz.utils.StringUtils;

import java.util.Map;

/**
 *
 * Created at 8/14/16, 22:02.
 * @author <a href="sock.sqt@gmail.com">sockosg</a>
 * @since 1.0
 */
public class AnnotationsConfigurationsLoader implements ConfigurationsLoader {

    private String packageToScan;
    private String[] packagesToScan;
    private Map<String, Object> configurations;

    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    public void setPackagesToScan(String... packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public void loadConfigurations() {
        if (StringUtils.isEmpty(this.packageToScan) && ArrayUtils.isEmpty(this.packagesToScan)) {
            throw new PackageNotDefinedException();
        }

        if (StringUtils.isNotEmpty(this.packageToScan)) {
            
        }
    }

}
