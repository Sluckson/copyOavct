package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.internal.Preconditions;

public final class ProviderLookup<T> implements Element {
    /* access modifiers changed from: private */
    public Provider<T> delegate;
    /* access modifiers changed from: private */
    public final Key<T> key;
    private final Object source;

    public ProviderLookup(Object obj, Key<T> key2) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.key = (Key) Preconditions.checkNotNull(key2, "key");
    }

    public Object getSource() {
        return this.source;
    }

    public Key<T> getKey() {
        return this.key;
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit((ProviderLookup<T>) this);
    }

    public void initializeDelegate(Provider<T> provider) {
        Preconditions.checkState(this.delegate == null, "delegate already initialized");
        this.delegate = (Provider) Preconditions.checkNotNull(provider, "delegate");
    }

    public void applyTo(Binder binder) {
        initializeDelegate(binder.withSource(getSource()).getProvider(this.key));
    }

    public Provider<T> getDelegate() {
        return this.delegate;
    }

    public Provider<T> getProvider() {
        return new Provider<T>() {
            public T get() {
                Preconditions.checkState(ProviderLookup.this.delegate != null, "This Provider cannot be used until the Injector has been created.");
                return ProviderLookup.this.delegate.get();
            }

            public String toString() {
                return "Provider<" + ProviderLookup.this.key.getTypeLiteral() + ">";
            }
        };
    }
}
