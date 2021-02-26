package com.google.inject;

import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.internal.Preconditions;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.Message;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;

public abstract class AbstractModule implements Module {
    Binder binder;

    /* access modifiers changed from: protected */
    public abstract void configure();

    public final synchronized void configure(Binder binder2) {
        Preconditions.checkState(this.binder == null, "Re-entry is not allowed.");
        this.binder = (Binder) Preconditions.checkNotNull(binder2, "builder");
        try {
            configure();
        } finally {
            this.binder = null;
        }
    }

    /* access modifiers changed from: protected */
    public Binder binder() {
        return this.binder;
    }

    /* access modifiers changed from: protected */
    public void bindScope(Class<? extends Annotation> cls, Scope scope) {
        this.binder.bindScope(cls, scope);
    }

    /* access modifiers changed from: protected */
    public <T> LinkedBindingBuilder<T> bind(Key<T> key) {
        return this.binder.bind(key);
    }

    /* access modifiers changed from: protected */
    public <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
        return this.binder.bind(typeLiteral);
    }

    /* access modifiers changed from: protected */
    public <T> AnnotatedBindingBuilder<T> bind(Class<T> cls) {
        return this.binder.bind(cls);
    }

    /* access modifiers changed from: protected */
    public AnnotatedConstantBindingBuilder bindConstant() {
        return this.binder.bindConstant();
    }

    /* access modifiers changed from: protected */
    public void install(Module module) {
        this.binder.install(module);
    }

    /* access modifiers changed from: protected */
    public void addError(String str, Object... objArr) {
        this.binder.addError(str, objArr);
    }

    /* access modifiers changed from: protected */
    public void addError(Throwable th) {
        this.binder.addError(th);
    }

    /* access modifiers changed from: protected */
    public void addError(Message message) {
        this.binder.addError(message);
    }

    /* access modifiers changed from: protected */
    public void requestInjection(Object obj) {
        this.binder.requestInjection(obj);
    }

    /* access modifiers changed from: protected */
    public void requestStaticInjection(Class<?>... clsArr) {
        this.binder.requestStaticInjection(clsArr);
    }

    /* access modifiers changed from: protected */
    public void requireBinding(Key<?> key) {
        this.binder.getProvider(key);
    }

    /* access modifiers changed from: protected */
    public void requireBinding(Class<?> cls) {
        this.binder.getProvider(cls);
    }

    /* access modifiers changed from: protected */
    public <T> Provider<T> getProvider(Key<T> key) {
        return this.binder.getProvider(key);
    }

    /* access modifiers changed from: protected */
    public <T> Provider<T> getProvider(Class<T> cls) {
        return this.binder.getProvider(cls);
    }

    /* access modifiers changed from: protected */
    public void convertToTypes(Matcher<? super TypeLiteral<?>> matcher, TypeConverter typeConverter) {
        this.binder.convertToTypes(matcher, typeConverter);
    }

    /* access modifiers changed from: protected */
    public Stage currentStage() {
        return this.binder.currentStage();
    }

    /* access modifiers changed from: protected */
    public <T> MembersInjector<T> getMembersInjector(Class<T> cls) {
        return this.binder.getMembersInjector(cls);
    }

    /* access modifiers changed from: protected */
    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
        return this.binder.getMembersInjector(typeLiteral);
    }

    /* access modifiers changed from: protected */
    public void bindListener(Matcher<? super TypeLiteral<?>> matcher, TypeListener typeListener) {
        this.binder.bindListener(matcher, typeListener);
    }
}
