package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;

class Initializables {
    Initializables() {
    }

    /* renamed from: of */
    static <T> Initializable<T> m301of(final T t) {
        return new Initializable<T>() {
            public T get(Errors errors) throws ErrorsException {
                return t;
            }

            public String toString() {
                return String.valueOf(t);
            }
        };
    }
}
