package com.google.inject.internal;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueAnnotations {
    private static final AtomicInteger nextUniqueValue = new AtomicInteger(1);

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface Internal {
        int value();
    }

    private UniqueAnnotations() {
    }

    public static Annotation create() {
        return create(nextUniqueValue.getAndIncrement());
    }

    static Annotation create(final int i) {
        return new Internal() {
            public int value() {
                return i;
            }

            public Class<? extends Annotation> annotationType() {
                return Internal.class;
            }

            public String toString() {
                return "@" + Internal.class.getName() + "(value=" + i + ")";
            }

            public boolean equals(Object obj) {
                return (obj instanceof Internal) && ((Internal) obj).value() == value();
            }

            public int hashCode() {
                return ("value".hashCode() * 127) ^ i;
            }
        };
    }
}
