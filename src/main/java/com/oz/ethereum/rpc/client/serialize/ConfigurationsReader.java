package com.oz.ethereum.rpc.client.serialize;

import com.oz.encrypt.KeccakSigner;
import com.oz.ethereum.rpc.client.serialize.annotations.MethodConfiguration;
import com.oz.ethereum.rpc.client.serialize.annotations.SolidityParameter;
import com.oz.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><b>Created:</b> 15/08/16, 11:38 AM</p>
 *
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 1.0
 */
public class ConfigurationsReader {

    private Map<String, Configuration> configs;

    public ConfigurationsReader() {
        super();
        this.configs = new HashMap<>();
    }

    public void createSimpleConfiguration(Class clazz) {
        MethodConfiguration annotationMethodConfig = (MethodConfiguration) clazz.getAnnotation(MethodConfiguration.class);

        Configuration config = new Configuration();
        this.configs.put(annotationMethodConfig.id(), config);

        // Processing IN parameters [methodName(uint,address)]
        if (ArrayUtils.isNotEmpty(annotationMethodConfig.inParameters())) {
            StringBuilder def = new StringBuilder(annotationMethodConfig.methodName());
            def.append("(");
            String prefix = "";

            for (SolidityParameter annotationParameter : annotationMethodConfig.inParameters()) {
                def.append(prefix);
                prefix = ",";
                def.append(annotationParameter.type());

                config.addInParameter(annotationParameter.name(), annotationParameter.type());
            }
            def.append(")");
            final String solvedDefinition = def.toString();

            config.getIn().setDefinition(solvedDefinition);
            config.getIn().setKeccak(KeccakSigner.getMethodId(solvedDefinition));
        }

        // Processing OUT parameters [(uint,address)]
        if (ArrayUtils.isNotEmpty(annotationMethodConfig.outParameters())) {
            StringBuilder def = new StringBuilder();

            def.append("(");
            String prefix = "";

            for (SolidityParameter annotationParameter : annotationMethodConfig.outParameters()) {
                def.append(prefix);
                prefix = ",";
                def.append(annotationParameter.type());

                config.addOutParameter(annotationParameter.name(), annotationParameter.type());
            }
            def.append(")");

            config.getOut().setDefinition(def.toString());
        }

    }

    public void createComplexConfiguration(Class clazz) {

    }

}
