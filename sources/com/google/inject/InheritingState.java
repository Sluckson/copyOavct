package com.google.inject;

import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;
import com.google.inject.internal.MatcherAndConverter;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.TypeListenerBinding;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class InheritingState implements State {
    private final WeakKeySet blacklistedKeys = new WeakKeySet();
    private final List<MatcherAndConverter> converters = Lists.newArrayList();
    private final Map<Key<?>, Binding<?>> explicitBindings = Collections.unmodifiableMap(this.explicitBindingsMutable);
    private final Map<Key<?>, Binding<?>> explicitBindingsMutable = Maps.newLinkedHashMap();
    private final List<TypeListenerBinding> listenerBindings = Lists.newArrayList();
    private final Object lock;
    private final State parent;
    private final Map<Class<? extends Annotation>, Scope> scopes = Maps.newHashMap();

    InheritingState(State state) {
        this.parent = (State) Preconditions.checkNotNull(state, "parent");
        this.lock = state == State.NONE ? this : state.lock();
    }

    public State parent() {
        return this.parent;
    }

    public <T> BindingImpl<T> getExplicitBinding(Key<T> key) {
        Binding binding = this.explicitBindings.get(key);
        return binding != null ? (BindingImpl) binding : this.parent.getExplicitBinding(key);
    }

    public Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel() {
        return this.explicitBindings;
    }

    public void putBinding(Key<?> key, BindingImpl<?> bindingImpl) {
        this.explicitBindingsMutable.put(key, bindingImpl);
    }

    public Scope getScope(Class<? extends Annotation> cls) {
        Scope scope = this.scopes.get(cls);
        return scope != null ? scope : this.parent.getScope(cls);
    }

    public void putAnnotation(Class<? extends Annotation> cls, Scope scope) {
        this.scopes.put(cls, scope);
    }

    public Iterable<MatcherAndConverter> getConvertersThisLevel() {
        return this.converters;
    }

    public void addConverter(MatcherAndConverter matcherAndConverter) {
        this.converters.add(matcherAndConverter);
    }

    public MatcherAndConverter getConverter(String str, TypeLiteral<?> typeLiteral, Errors errors, Object obj) {
        MatcherAndConverter matcherAndConverter;
        MatcherAndConverter matcherAndConverter2 = null;
        State state = this;
        while (state != State.NONE) {
            Iterator<MatcherAndConverter> it = state.getConvertersThisLevel().iterator();
            while (true) {
                matcherAndConverter = matcherAndConverter2;
                while (it.hasNext()) {
                    matcherAndConverter2 = it.next();
                    if (matcherAndConverter2.getTypeMatcher().matches(typeLiteral)) {
                        if (matcherAndConverter != null) {
                            errors.ambiguousTypeConversion(str, obj, typeLiteral, matcherAndConverter, matcherAndConverter2);
                        }
                    }
                }
                break;
            }
            state = state.parent();
            matcherAndConverter2 = matcherAndConverter;
        }
        return matcherAndConverter2;
    }

    public void addTypeListener(TypeListenerBinding typeListenerBinding) {
        this.listenerBindings.add(typeListenerBinding);
    }

    public List<TypeListenerBinding> getTypeListenerBindings() {
        List<TypeListenerBinding> typeListenerBindings = this.parent.getTypeListenerBindings();
        ArrayList arrayList = new ArrayList(typeListenerBindings.size() + 1);
        arrayList.addAll(typeListenerBindings);
        arrayList.addAll(this.listenerBindings);
        return arrayList;
    }

    public void blacklist(Key<?> key) {
        this.parent.blacklist(key);
        this.blacklistedKeys.add(key);
    }

    public boolean isBlacklisted(Key<?> key) {
        return this.blacklistedKeys.contains(key);
    }

    public Object lock() {
        return this.lock;
    }
}
