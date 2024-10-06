package example.c02_serviceLocator.cc02_upgrade;

import java.util.HashMap;

public class ServiceCache {
    static HashMap<String, Object> cache = new HashMap<>();

    static Object getInstance(String key) {
        return cache.get(key.toLowerCase());
    }

    static void loadInstance(Object object){
        String objectClass = object.getClass().getSimpleName().toLowerCase();
        System.out.println("init cache: " + objectClass);
        cache.put(objectClass, object);
    }
}
