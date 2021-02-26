package com.google.inject.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class Lists {
    private Lists() {
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayList(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    static int computeArrayListCapacity(int i) {
        Preconditions.checkArgument(i >= 0);
        return (int) Math.min(((long) i) + 5 + ((long) (i / 10)), 2147483647L);
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return newArrayList(iterable.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        while (it.hasNext()) {
            newArrayList.add(it.next());
        }
        return newArrayList;
    }

    public static <E> ArrayList<E> newArrayList(@Nullable E e, E[] eArr) {
        ArrayList<E> arrayList = new ArrayList<>(eArr.length + 1);
        arrayList.add(e);
        for (E add : eArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
