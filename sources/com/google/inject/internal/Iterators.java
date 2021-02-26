package com.google.inject.internal;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Iterators {
    static final Iterator<Object> EMPTY_ITERATOR = new UnmodifiableIterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }
    };
    private static final ListIterator<Object> EMPTY_LIST_ITERATOR = new ListIterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public boolean hasPrevious() {
            return false;
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return -1;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public Object previous() {
            throw new NoSuchElementException();
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException();
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    };

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return (UnmodifiableIterator) EMPTY_ITERATOR;
    }

    public static <T> ListIterator<T> emptyListIterator() {
        return EMPTY_LIST_ITERATOR;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static String toString(Iterator<?> it) {
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> T getOnlyElement(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", " + it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(">");
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> Iterator<T> concat(final Iterator<? extends Iterator<? extends T>> it) {
        Preconditions.checkNotNull(it);
        return new Iterator<T>() {
            Iterator<? extends T> current = Iterators.emptyIterator();
            Iterator<? extends T> removeFrom;

            public boolean hasNext() {
                while (!this.current.hasNext() && it.hasNext()) {
                    this.current = (Iterator) it.next();
                }
                return this.current.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    Iterator<? extends T> it = this.current;
                    this.removeFrom = it;
                    return it.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Preconditions.checkState(this.removeFrom != null, "no calls to next() since last call to remove()");
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <F, T> Iterator<T> transform(final Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(function);
        return new Iterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return function.apply(it.next());
            }

            public void remove() {
                it.remove();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> forArray(final T... tArr) {
        return new UnmodifiableIterator<T>() {

            /* renamed from: i */
            int f380i = 0;
            final int length = tArr.length;

            public boolean hasNext() {
                return this.f380i < this.length;
            }

            public T next() {
                try {
                    T t = tArr[this.f380i];
                    this.f380i++;
                    return t;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public static <T> UnmodifiableIterator<T> forArray(final T[] tArr, final int i, int i2) {
        Preconditions.checkArgument(i2 >= 0);
        final int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, tArr.length);
        return new UnmodifiableIterator<T>() {

            /* renamed from: i */
            int f381i = i;

            public boolean hasNext() {
                return this.f381i < i3;
            }

            public T next() {
                if (hasNext()) {
                    T[] tArr = tArr;
                    int i = this.f381i;
                    this.f381i = i + 1;
                    return tArr[i];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable final T t) {
        return new UnmodifiableIterator<T>() {
            boolean done;

            public boolean hasNext() {
                return !this.done;
            }

            public T next() {
                if (!this.done) {
                    this.done = true;
                    return t;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new Enumeration<T>() {
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public T nextElement() {
                return it.next();
            }
        };
    }
}
