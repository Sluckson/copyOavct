package com.google.inject;

import java.util.List;
import java.util.Map;

public interface Injector {
    Injector createChildInjector(Iterable<? extends Module> iterable);

    Injector createChildInjector(Module... moduleArr);

    <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> typeLiteral);

    <T> Binding<T> getBinding(Key<T> key);

    <T> Binding<T> getBinding(Class<T> cls);

    Map<Key<?>, Binding<?>> getBindings();

    <T> T getInstance(Key<T> key);

    <T> T getInstance(Class<T> cls);

    <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral);

    <T> MembersInjector<T> getMembersInjector(Class<T> cls);

    Injector getParent();

    <T> Provider<T> getProvider(Key<T> key);

    <T> Provider<T> getProvider(Class<T> cls);

    void injectMembers(Object obj);
}
