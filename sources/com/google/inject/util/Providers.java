package com.google.inject.util;

import com.google.inject.Provider;

public final class Providers {
    private Providers() {
    }

    /* renamed from: of */
    public static <T> Provider<T> m353of(final T t) {
        return new Provider<T>() {
            public T get() {
                return t;
            }

            public String toString() {
                return "of(" + t + ")";
            }
        };
    }
}
