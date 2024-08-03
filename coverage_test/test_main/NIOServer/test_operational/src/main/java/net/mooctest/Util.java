package net.mooctest;

import org.junit.AssumptionViolatedException;

import java.lang.annotation.Annotation;

public class Util {
    public static void verifyException(String sourceClass, Throwable t) throws AssertionError {
        if (t instanceof AssumptionViolatedException) {
            throw (AssumptionViolatedException)t;
        } else {
            assertThrownBy(sourceClass, t);
        }
    }

    public static void assertThrownBy(String sourceClass, Throwable t) throws AssertionError {
        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace.length != 0) {
            StackTraceElement el = stackTrace[0];
            if (sourceClass != null) {
                String name = el.getClassName();
                if (!sourceClass.equals(name)) {
                    Class klass;
                    try {
                        klass = Object.class.getClassLoader().loadClass(sourceClass);
                    } catch (ClassNotFoundException var10) {
                        throw new AssertionError("Cannot load/analyze class " + sourceClass);
                    }

                    Annotation[] var6 = klass.getAnnotations();
                    int var7 = var6.length;

                    for(int var8 = 0; var8 < var7; ++var8) {
                        Annotation annotation = var6[var8];
                        if (annotation.getClass().getName().equals(name)) {
                            return;
                        }
                    }

                    do {
                        if (klass == null) {
                            if (name.equals("java.lang.System")) {
                                return;
                            }

                            throw new AssertionError("Exception was not thrown in " + sourceClass + " but in " + el + ": " + t);
                        }

                        klass = klass.getSuperclass();
                    } while(klass == null || !klass.getName().equals(name));

                }
            }
        }
    }
}
