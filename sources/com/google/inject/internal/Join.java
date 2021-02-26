package com.google.inject.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public final class Join {
    private Join() {
    }

    public static String join(String str, Iterable<?> iterable) {
        return join(str, iterable.iterator());
    }

    public static String join(String str, Object[] objArr) {
        return join(str, (Iterable<?>) Arrays.asList(objArr));
    }

    public static String join(String str, @Nullable Object obj, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return join(str, (Iterable<?>) Lists.newArrayList(obj, objArr));
    }

    public static String join(String str, Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        join(sb, str, it);
        return sb.toString();
    }

    public static String join(String str, String str2, Map<?, ?> map) {
        return ((StringBuilder) join(new StringBuilder(), str, str2, map)).toString();
    }

    public static <T extends Appendable> T join(T t, String str, Iterable<?> iterable) {
        return join(t, str, iterable.iterator());
    }

    public static <T extends Appendable> T join(T t, String str, Object[] objArr) {
        return join(t, str, (Iterable<?>) Arrays.asList(objArr));
    }

    public static <T extends Appendable> T join(T t, String str, @Nullable Object obj, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return join(t, str, (Iterable<?>) Lists.newArrayList(obj, objArr));
    }

    public static <T extends Appendable> T join(T t, String str, Iterator<?> it) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(str);
        if (it.hasNext()) {
            try {
                appendOneToken(t, it.next());
                while (it.hasNext()) {
                    t.append(str);
                    appendOneToken(t, it.next());
                }
            } catch (IOException e) {
                throw new JoinException(e);
            }
        }
        return t;
    }

    public static <T extends Appendable> T join(T t, String str, String str2, Map<?, ?> map) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        if (it.hasNext()) {
            try {
                appendOneEntry(t, str, it.next());
                while (it.hasNext()) {
                    t.append(str2);
                    appendOneEntry(t, str, it.next());
                }
            } catch (IOException e) {
                throw new JoinException(e);
            }
        }
        return t;
    }

    private static void appendOneEntry(Appendable appendable, String str, Map.Entry<?, ?> entry) throws IOException {
        appendOneToken(appendable, entry.getKey());
        appendable.append(str);
        appendOneToken(appendable, entry.getValue());
    }

    private static void appendOneToken(Appendable appendable, Object obj) throws IOException {
        appendable.append(toCharSequence(obj));
    }

    private static CharSequence toCharSequence(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : String.valueOf(obj);
    }

    public static class JoinException extends RuntimeException {
        private static final long serialVersionUID = 1;

        private JoinException(IOException iOException) {
            super(iOException);
        }
    }
}
