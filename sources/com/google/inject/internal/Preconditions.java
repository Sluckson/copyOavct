package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T checkNotNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, objArr));
    }

    public static <T extends Iterable<?>> T checkContentsNotNull(T t) {
        if (!containsOrIsNull(t)) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T extends Iterable<?>> T checkContentsNotNull(T t, Object obj) {
        if (!containsOrIsNull(t)) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T extends Iterable<?>> T checkContentsNotNull(T t, String str, Object... objArr) {
        if (!containsOrIsNull(t)) {
            return t;
        }
        throw new NullPointerException(format(str, objArr));
    }

    private static boolean containsOrIsNull(Iterable<?> iterable) {
        if (iterable == null) {
            return true;
        }
        if (iterable instanceof Collection) {
            try {
                return ((Collection) iterable).contains((Object) null);
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            for (Object obj : iterable) {
                if (obj == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void checkElementIndex(int i, int i2) {
        checkElementIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    public static void checkElementIndex(int i, int i2, String str) {
        checkArgument(i2 >= 0, "negative size: %s", Integer.valueOf(i2));
        if (i < 0) {
            throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", str, Integer.valueOf(i)));
        } else if (i >= i2) {
            throw new IndexOutOfBoundsException(format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkPositionIndex(int i, int i2) {
        checkPositionIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    public static void checkPositionIndex(int i, int i2, String str) {
        checkArgument(i2 >= 0, "negative size: %s", Integer.valueOf(i2));
        if (i < 0) {
            throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", str, Integer.valueOf(i)));
        } else if (i > i2) {
            throw new IndexOutOfBoundsException(format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        checkPositionIndex(i, i3, "start index");
        checkPositionIndex(i2, i3, "end index");
        if (i2 < i) {
            throw new IndexOutOfBoundsException(format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    static String format(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i2)) != -1) {
            sb.append(str.substring(i2, indexOf));
            sb.append(objArr[i]);
            int i3 = i + 1;
            i2 = indexOf + 2;
            i = i3;
        }
        sb.append(str.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
