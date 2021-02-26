package com.google.inject.internal;

import java.util.Arrays;

public final class Objects {
    private Objects() {
    }

    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
