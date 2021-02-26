package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.FailableCache;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.Lists;
import com.google.inject.internal.UnmodifiableIterator;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.TypeListenerBinding;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class MembersInjectorStore {
    private final FailableCache<TypeLiteral<?>, MembersInjectorImpl<?>> cache = new FailableCache<TypeLiteral<?>, MembersInjectorImpl<?>>() {
        /* access modifiers changed from: protected */
        public MembersInjectorImpl<?> create(TypeLiteral<?> typeLiteral, Errors errors) throws ErrorsException {
            return MembersInjectorStore.this.createWithListeners(typeLiteral, errors);
        }
    };
    private final InjectorImpl injector;
    private final ImmutableList<TypeListenerBinding> typeListenerBindings;

    MembersInjectorStore(InjectorImpl injectorImpl, List<TypeListenerBinding> list) {
        this.injector = injectorImpl;
        this.typeListenerBindings = ImmutableList.copyOf(list);
    }

    public boolean hasTypeListeners() {
        return !this.typeListenerBindings.isEmpty();
    }

    public <T> MembersInjectorImpl<T> get(TypeLiteral<T> typeLiteral, Errors errors) throws ErrorsException {
        return this.cache.get(typeLiteral, errors);
    }

    /* access modifiers changed from: private */
    public <T> MembersInjectorImpl<T> createWithListeners(TypeLiteral<T> typeLiteral, Errors errors) throws ErrorsException {
        Set<InjectionPoint> set;
        int size = errors.size();
        try {
            set = InjectionPoint.forInstanceMethodsAndFields((TypeLiteral<?>) typeLiteral);
        } catch (ConfigurationException e) {
            errors.merge(e.getErrorMessages());
            set = (Set) e.getPartialValue();
        }
        ImmutableList<SingleMemberInjector> injectors = getInjectors(set, errors);
        errors.throwIfNewErrors(size);
        EncounterImpl encounterImpl = new EncounterImpl(errors, this.injector.lookups);
        UnmodifiableIterator<TypeListenerBinding> it = this.typeListenerBindings.iterator();
        while (it.hasNext()) {
            TypeListenerBinding next = it.next();
            if (next.getTypeMatcher().matches(typeLiteral)) {
                try {
                    next.getListener().hear(typeLiteral, encounterImpl);
                } catch (RuntimeException e2) {
                    errors.errorNotifyingTypeListener(next, typeLiteral, e2);
                }
            }
        }
        encounterImpl.invalidate();
        errors.throwIfNewErrors(size);
        return new MembersInjectorImpl<>(this.injector, typeLiteral, encounterImpl, injectors);
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<SingleMemberInjector> getInjectors(Set<InjectionPoint> set, Errors errors) {
        ArrayList newArrayList = Lists.newArrayList();
        for (InjectionPoint next : set) {
            try {
                Errors errors2 = next.isOptional() ? new Errors(next) : errors.withSource(next);
                newArrayList.add(next.getMember() instanceof Field ? new SingleFieldInjector(this.injector, next, errors2) : new SingleMethodInjector(this.injector, next, errors2));
            } catch (ErrorsException unused) {
            }
        }
        return ImmutableList.copyOf(newArrayList);
    }
}
