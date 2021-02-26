package com.google.inject.internal;

public interface Function<F, T> {
    T apply(@Nullable F f);

    boolean equals(@Nullable Object obj);
}
