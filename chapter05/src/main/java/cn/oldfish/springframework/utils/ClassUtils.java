package cn.oldfish.springframework.utils;

public class ClassUtils {
    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }

        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
        }

        return classLoader;
    }
}
