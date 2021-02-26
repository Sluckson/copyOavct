package com.google.inject;

import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.MatcherAndConverter;
import com.google.inject.spi.TypeListenerBinding;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

interface State {
    public static final State NONE = new State() {
        public void blacklist(Key<?> key) {
        }

        public <T> BindingImpl<T> getExplicitBinding(Key<T> key) {
            return null;
        }

        public Scope getScope(Class<? extends Annotation> cls) {
            return null;
        }

        public boolean isBlacklisted(Key<?> key) {
            return true;
        }

        public State parent() {
            throw new UnsupportedOperationException();
        }

        public Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel() {
            throw new UnsupportedOperationException();
        }

        public void putBinding(Key<?> key, BindingImpl<?> bindingImpl) {
            throw new UnsupportedOperationException();
        }

        public void putAnnotation(Class<? extends Annotation> cls, Scope scope) {
            throw new UnsupportedOperationException();
        }

        public void addConverter(MatcherAndConverter matcherAndConverter) {
            throw new UnsupportedOperationException();
        }

        public MatcherAndConverter getConverter(String str, TypeLiteral<?> typeLiteral, Errors errors, Object obj) {
            throw new UnsupportedOperationException();
        }

        public Iterable<MatcherAndConverter> getConvertersThisLevel() {
            return ImmutableSet.m348of();
        }

        public void addTypeListener(TypeListenerBinding typeListenerBinding) {
            throw new UnsupportedOperationException();
        }

        public List<TypeListenerBinding> getTypeListenerBindings() {
            return ImmutableList.m335of();
        }

        public Object lock() {
            throw new UnsupportedOperationException();
        }
    };

    void addConverter(MatcherAndConverter matcherAndConverter);

    void addTypeListener(TypeListenerBinding typeListenerBinding);

    void blacklist(Key<?> key);

    MatcherAndConverter getConverter(String str, TypeLiteral<?> typeLiteral, Errors errors, Object obj);

    Iterable<MatcherAndConverter> getConvertersThisLevel();

    <T> BindingImpl<T> getExplicitBinding(Key<T> key);

    Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel();

    Scope getScope(Class<? extends Annotation> cls);

    List<TypeListenerBinding> getTypeListenerBindings();

    boolean isBlacklisted(Key<?> key);

    Object lock();

    State parent();

    void putAnnotation(Class<? extends Annotation> cls, Scope scope);

    void putBinding(Key<?> key, BindingImpl<?> bindingImpl);
}
