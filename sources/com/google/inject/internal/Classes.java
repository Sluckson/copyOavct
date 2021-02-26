package com.google.inject.internal;

import java.lang.reflect.Modifier;

public class Classes {
    public static boolean isInnerClass(Class<?> cls) {
        return !Modifier.isStatic(cls.getModifiers()) && cls.getEnclosingClass() != null;
    }

    public static boolean isConcrete(Class<?> cls) {
        return !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers());
    }
}
