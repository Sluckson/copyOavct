package com.google.inject.matcher;

public interface Matcher<T> {
    Matcher<T> and(Matcher<? super T> matcher);

    boolean matches(T t);

    /* renamed from: or */
    Matcher<T> mo36999or(Matcher<? super T> matcher);
}
