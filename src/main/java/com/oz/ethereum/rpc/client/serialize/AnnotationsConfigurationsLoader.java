package com.oz.ethereum.rpc.client.serialize;

import com.oz.ethereum.rpc.client.serialize.annotations.MethodConfiguration;
import com.oz.ethereum.rpc.client.serialize.annotations.MethodsConfiguration;
import com.oz.ethereum.rpc.exceptions.PackageNotDefinedException;
import com.oz.utils.ArrayUtils;
import com.oz.utils.ClassFinder;
import com.oz.utils.CollectionUtils;
import com.oz.utils.StringUtils;
import lombok.Setter;

import java.util.List;
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

    @Setter
    private ConfigurationsReader reader;

    public AnnotationsConfigurationsLoader() {
        super();
        this.reader = new ConfigurationsReader();
    }

    public AnnotationsConfigurationsLoader(ConfigurationsReader reader) {
        super();
        this.reader = reader;
    }

    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    public void setPackagesToScan(String... packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public void loadConfigurations() throws ClassNotFoundException {
        if (StringUtils.isEmpty(this.packageToScan) && ArrayUtils.isEmpty(this.packagesToScan)) {
            throw new PackageNotDefinedException();
        }

        if (StringUtils.isNotEmpty(this.packageToScan)) {
            List<Class> classes = ClassFinder.getClasses(this.packageToScan);

            if (CollectionUtils.isEmpty(classes)) {
                // TODO : print warning that there are no packages configured
                return;
            }

            int[] configs = {0};
            classes.forEach(clazz -> {
                if (clazz.isAnnotationPresent(MethodsConfiguration.class) || clazz.isAnnotationPresent(MethodConfiguration.class)) {
                    this.createConfiguration(clazz);
                    configs[0]++;
                }
            });

            if (configs[0] == 0) {
                throw new PackageNotDefinedException("There are no classes with configurations defined.");
            }
        }
    }

    private void createConfiguration(Class clazz) {
        if (clazz.isAnnotationPresent(MethodsConfiguration.class)) {
            this.reader.createComplexConfiguration(clazz);
        } else if (clazz.isAnnotationPresent(MethodConfiguration.class)) {
            this.reader.createSimpleConfiguration(clazz);
        }
    }

}
