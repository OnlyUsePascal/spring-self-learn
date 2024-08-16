package example.c01_dependencyInjection.c01_concept;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector {
    static String CONFIG_FILE = "c01_01.properties";

    static Object getInstance(String instanceKey) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            String instanceProp = properties.getProperty(instanceKey);
            return Class.forName(instanceProp).getDeclaredConstructor().newInstance();

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
