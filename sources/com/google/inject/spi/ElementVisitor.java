package com.google.inject.spi;

import com.google.inject.Binding;

public interface ElementVisitor<V> {
    <T> V visit(Binding<T> binding);

    V visit(InjectionRequest injectionRequest);

    <T> V visit(MembersInjectorLookup<T> membersInjectorLookup);

    V visit(Message message);

    V visit(PrivateElements privateElements);

    <T> V visit(ProviderLookup<T> providerLookup);

    V visit(ScopeBinding scopeBinding);

    V visit(StaticInjectionRequest staticInjectionRequest);

    V visit(TypeConverterBinding typeConverterBinding);

    V visit(TypeListenerBinding typeListenerBinding);
}
