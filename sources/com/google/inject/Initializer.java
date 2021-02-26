package com.google.inject;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.InjectionPoint;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

class Initializer {
    /* access modifiers changed from: private */
    public final Thread creatingThread = Thread.currentThread();
    /* access modifiers changed from: private */
    public final Map<Object, InjectableReference<?>> pendingInjection = Maps.newIdentityHashMap();
    /* access modifiers changed from: private */
    public final CountDownLatch ready = new CountDownLatch(1);

    Initializer() {
    }

    public <T> Initializable<T> requestInjection(InjectorImpl injectorImpl, T t, Object obj, Set<InjectionPoint> set) {
        Preconditions.checkNotNull(obj);
        if (t == null || (set.isEmpty() && !injectorImpl.membersInjectorStore.hasTypeListeners())) {
            return Initializables.m301of(t);
        }
        InjectableReference injectableReference = new InjectableReference(injectorImpl, t, obj);
        this.pendingInjection.put(t, injectableReference);
        return injectableReference;
    }

    /* access modifiers changed from: package-private */
    public void validateOustandingInjections(Errors errors) {
        for (InjectableReference validate : this.pendingInjection.values()) {
            try {
                validate.validate(errors);
            } catch (ErrorsException e) {
                errors.merge(e.getErrors());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void injectAll(Errors errors) {
        Iterator<InjectableReference<?>> it = Lists.newArrayList(this.pendingInjection.values()).iterator();
        while (it.hasNext()) {
            try {
                it.next().get(errors);
            } catch (ErrorsException e) {
                errors.merge(e.getErrors());
            }
        }
        if (this.pendingInjection.isEmpty()) {
            this.ready.countDown();
            return;
        }
        throw new AssertionError("Failed to satisfy " + this.pendingInjection);
    }

    private class InjectableReference<T> implements Initializable<T> {
        private final InjectorImpl injector;
        private final T instance;
        private MembersInjectorImpl<T> membersInjector;
        private final Object source;

        public InjectableReference(InjectorImpl injectorImpl, T t, Object obj) {
            this.injector = injectorImpl;
            this.instance = Preconditions.checkNotNull(t, "instance");
            this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        }

        public void validate(Errors errors) throws ErrorsException {
            this.membersInjector = this.injector.membersInjectorStore.get(TypeLiteral.get(this.instance.getClass()), errors.withSource(this.source));
        }

        public T get(Errors errors) throws ErrorsException {
            if (Initializer.this.ready.getCount() == 0) {
                return this.instance;
            }
            if (Thread.currentThread() != Initializer.this.creatingThread) {
                try {
                    Initializer.this.ready.await();
                    return this.instance;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (Initializer.this.pendingInjection.remove(this.instance) != null) {
                    this.membersInjector.injectAndNotify(this.instance, errors.withSource(this.source));
                }
                return this.instance;
            }
        }

        public String toString() {
            return this.instance.toString();
        }
    }
}
