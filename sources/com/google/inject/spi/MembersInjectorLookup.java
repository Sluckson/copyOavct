package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Preconditions;

public final class MembersInjectorLookup<T> implements Element {
    /* access modifiers changed from: private */
    public MembersInjector<T> delegate;
    private final Object source;
    /* access modifiers changed from: private */
    public final TypeLiteral<T> type;

    public MembersInjectorLookup(Object obj, TypeLiteral<T> typeLiteral) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.type = (TypeLiteral) Preconditions.checkNotNull(typeLiteral, "type");
    }

    public Object getSource() {
        return this.source;
    }

    public TypeLiteral<T> getType() {
        return this.type;
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit((MembersInjectorLookup<T>) this);
    }

    public void initializeDelegate(MembersInjector<T> membersInjector) {
        Preconditions.checkState(this.delegate == null, "delegate already initialized");
        this.delegate = (MembersInjector) Preconditions.checkNotNull(membersInjector, "delegate");
    }

    public void applyTo(Binder binder) {
        initializeDelegate(binder.withSource(getSource()).getMembersInjector(this.type));
    }

    public MembersInjector<T> getDelegate() {
        return this.delegate;
    }

    public MembersInjector<T> getMembersInjector() {
        return new MembersInjector<T>() {
            public void injectMembers(T t) {
                Preconditions.checkState(MembersInjectorLookup.this.delegate != null, "This MembersInjector cannot be used until the Injector has been created.");
                MembersInjectorLookup.this.delegate.injectMembers(t);
            }

            public String toString() {
                return "MembersInjector<" + MembersInjectorLookup.this.type + ">";
            }
        };
    }
}
