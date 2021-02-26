package com.google.inject;

interface Lookups {
    <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral);

    <T> Provider<T> getProvider(Key<T> key);
}
