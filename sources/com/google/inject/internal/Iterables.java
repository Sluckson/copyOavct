package com.google.inject.internal;

import java.util.Arrays;
import java.util.Iterator;

public final class Iterables {
    private Iterables() {
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(iterable2);
        return concat(Arrays.asList(new Iterable[]{iterable, iterable2}));
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        final Iterable<? extends Iterable<? extends T>> transform = transform(iterable, new Function<Iterable<? extends T>, Iterator<? extends T>>() {
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        });
        return new IterableWithToString<T>() {
            public Iterator<T> iterator() {
                return Iterators.concat(transform.iterator());
            }
        };
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new IterableWithToString<T>() {
            public Iterator<T> iterator() {
                return Iterators.transform(iterable.iterator(), function);
            }
        };
    }

    static abstract class IterableWithToString<E> implements Iterable<E> {
        IterableWithToString() {
        }

        public String toString() {
            return Iterables.toString(this);
        }
    }
}
