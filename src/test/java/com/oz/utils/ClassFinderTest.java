package com.oz.utils;

import com.oz.utils.ClassFinder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * <p><b>Created:</b> 15/08/16, 10:38 AM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 0.1.0
 */
public class ClassFinderTest {

    @Test
    public void getClasses() throws IOException, ClassNotFoundException {
        List<Class> classes = ClassFinder.getClasses("com.oz.ethereum.rpc.client.serialize");

        System.out.println(classes);
    }

}
