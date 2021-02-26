package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.Message;
import com.google.inject.spi.TypeEncounter;
import java.util.List;

final class EncounterImpl<T> implements TypeEncounter<T> {
    private final Errors errors;
    private List<InjectionListener<? super T>> injectionListeners;
    private final Lookups lookups;
    private List<MembersInjector<? super T>> membersInjectors;
    private boolean valid = true;

    public EncounterImpl(Errors errors2, Lookups lookups2) {
        this.errors = errors2;
        this.lookups = lookups2;
    }

    public void invalidate() {
        this.valid = false;
    }

    public ImmutableList<MembersInjector<? super T>> getMembersInjectors() {
        List<MembersInjector<? super T>> list = this.membersInjectors;
        return list == null ? ImmutableList.m335of() : ImmutableList.copyOf(list);
    }

    public ImmutableList<InjectionListener<? super T>> getInjectionListeners() {
        List<InjectionListener<? super T>> list = this.injectionListeners;
        return list == null ? ImmutableList.m335of() : ImmutableList.copyOf(list);
    }

    public void register(MembersInjector<? super T> membersInjector) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        if (this.membersInjectors == null) {
            this.membersInjectors = Lists.newArrayList();
        }
        this.membersInjectors.add(membersInjector);
    }

    public void register(InjectionListener<? super T> injectionListener) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        if (this.injectionListeners == null) {
            this.injectionListeners = Lists.newArrayList();
        }
        this.injectionListeners.add(injectionListener);
    }

    public void addError(String str, Object... objArr) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        this.errors.addMessage(str, objArr);
    }

    public void addError(Throwable th) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        this.errors.errorInUserCode(th, "An exception was caught and reported. Message: %s", th.getMessage());
    }

    public void addError(Message message) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        this.errors.addMessage(message);
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        return this.lookups.getProvider(key);
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Key.get(cls));
    }

    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
        Preconditions.checkState(this.valid, "Encounters may not be used after hear() returns.");
        return this.lookups.getMembersInjector(typeLiteral);
    }

    public <T> MembersInjector<T> getMembersInjector(Class<T> cls) {
        return getMembersInjector(TypeLiteral.get(cls));
    }
}
