package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.UnmodifiableIterator;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.InjectionPoint;

class MembersInjectorImpl<T> implements MembersInjector<T> {
    private final ImmutableList<InjectionListener<? super T>> injectionListeners;
    private final InjectorImpl injector;
    private final ImmutableList<SingleMemberInjector> memberInjectors;
    private final TypeLiteral<T> typeLiteral;
    private final ImmutableList<MembersInjector<? super T>> userMembersInjectors;

    MembersInjectorImpl(InjectorImpl injectorImpl, TypeLiteral<T> typeLiteral2, EncounterImpl<T> encounterImpl, ImmutableList<SingleMemberInjector> immutableList) {
        this.injector = injectorImpl;
        this.typeLiteral = typeLiteral2;
        this.memberInjectors = immutableList;
        this.userMembersInjectors = encounterImpl.getMembersInjectors();
        this.injectionListeners = encounterImpl.getInjectionListeners();
    }

    public ImmutableList<SingleMemberInjector> getMemberInjectors() {
        return this.memberInjectors;
    }

    public void injectMembers(T t) {
        Errors errors = new Errors(this.typeLiteral);
        try {
            injectAndNotify(t, errors);
        } catch (ErrorsException e) {
            errors.merge(e.getErrors());
        }
        errors.throwProvisionExceptionIfErrorsExist();
    }

    /* access modifiers changed from: package-private */
    public void injectAndNotify(final T t, final Errors errors) throws ErrorsException {
        if (t != null) {
            this.injector.callInContext(new ContextualCallable<Void>() {
                public Void call(InternalContext internalContext) throws ErrorsException {
                    MembersInjectorImpl.this.injectMembers(t, errors, internalContext);
                    return null;
                }
            });
            notifyListeners(t, errors);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyListeners(T t, Errors errors) throws ErrorsException {
        int size = errors.size();
        UnmodifiableIterator<InjectionListener<? super T>> it = this.injectionListeners.iterator();
        while (it.hasNext()) {
            InjectionListener next = it.next();
            try {
                next.afterInjection(t);
            } catch (RuntimeException e) {
                errors.errorNotifyingInjectionListener(next, this.typeLiteral, e);
            }
        }
        errors.throwIfNewErrors(size);
    }

    /* access modifiers changed from: package-private */
    public void injectMembers(T t, Errors errors, InternalContext internalContext) {
        int size = this.memberInjectors.size();
        for (int i = 0; i < size; i++) {
            ((SingleMemberInjector) this.memberInjectors.get(i)).inject(errors, internalContext, t);
        }
        int size2 = this.userMembersInjectors.size();
        for (int i2 = 0; i2 < size2; i2++) {
            MembersInjector membersInjector = (MembersInjector) this.userMembersInjectors.get(i2);
            try {
                membersInjector.injectMembers(t);
            } catch (RuntimeException e) {
                errors.errorInUserInjector(membersInjector, this.typeLiteral, e);
            }
        }
    }

    public String toString() {
        return "MembersInjector<" + this.typeLiteral + ">";
    }

    public ImmutableSet<InjectionPoint> getInjectionPoints() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<SingleMemberInjector> it = this.memberInjectors.iterator();
        while (it.hasNext()) {
            builder.add(it.next().getInjectionPoint());
        }
        return builder.build();
    }
}
