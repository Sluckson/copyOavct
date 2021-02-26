package com.google.inject.internal;

import java.lang.reflect.Array;

public final class ObjectArrays {
    private ObjectArrays() {
    }

    public static <T> T[] newArray(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }
}
