package com.google.inject;

import java.lang.reflect.Constructor;

class Reflection {
    Reflection() {
    }

    static class InvalidConstructor {
        InvalidConstructor() {
            throw new AssertionError();
        }
    }

    static <T> Constructor<T> invalidConstructor() {
        try {
            return InvalidConstructor.class.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }
}
