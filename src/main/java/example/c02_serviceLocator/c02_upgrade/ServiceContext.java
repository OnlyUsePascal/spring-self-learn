package example.c02_serviceLocator.c02_upgrade;

import java.lang.reflect.InvocationTargetException;

public class ServiceContext {
    static String packageBase = "org.example.c02_serviceLocator.c02_upgrade.";
    static Object objectLookup(String objectClass) {
        try {
            return Class.forName(packageBase + objectClass).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
