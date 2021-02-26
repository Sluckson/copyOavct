package org.apache.harmony.awt;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public final class Utils {
    public static String getSystemProperty(String str) {
        return getSystemProperty(str, (String) null);
    }

    public static String getSystemProperty(final String str, final String str2) {
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty(str, str2);
            }
        });
    }

    public static void loadLibrary(final String str) throws UnsatisfiedLinkError, NullPointerException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
                public Object run() {
                    System.loadLibrary(str);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof UnsatisfiedLinkError) {
                throw ((UnsatisfiedLinkError) cause);
            } else if (cause instanceof NullPointerException) {
                throw ((NullPointerException) cause);
            }
        }
    }
}
