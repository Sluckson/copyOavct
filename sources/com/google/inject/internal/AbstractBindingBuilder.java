package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Scope;
import com.google.inject.spi.Element;
import com.google.inject.spi.InstanceBinding;
import com.lowagie.text.ElementTags;
import java.lang.annotation.Annotation;
import java.util.List;

public abstract class AbstractBindingBuilder<T> {
    public static final String ANNOTATION_ALREADY_SPECIFIED = "More than one annotation is specified for this binding.";
    public static final String BINDING_TO_NULL = "Binding to null instances is not allowed. Use toProvider(Providers.of(null)) if this is your intended behaviour.";
    public static final String CONSTANT_VALUE_ALREADY_SET = "Constant value is set more than once.";
    public static final String IMPLEMENTATION_ALREADY_SET = "Implementation is set more than once.";
    protected static final Key<?> NULL_KEY = Key.get(Void.class);
    public static final String SCOPE_ALREADY_SET = "Scope is set more than once.";
    public static final String SINGLE_INSTANCE_AND_SCOPE = "Setting the scope is not permitted when binding to a single instance.";
    protected final Binder binder;
    private BindingImpl<T> binding;
    protected List<Element> elements;
    protected int position;

    public AbstractBindingBuilder(Binder binder2, List<Element> list, Object obj, Key<T> key) {
        this.binder = binder2;
        this.elements = list;
        this.position = list.size();
        this.binding = new UntargettedBindingImpl(obj, key, Scoping.UNSCOPED);
        list.add(this.position, this.binding);
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> getBinding() {
        return this.binding;
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> setBinding(BindingImpl<T> bindingImpl) {
        this.binding = bindingImpl;
        this.elements.set(this.position, bindingImpl);
        return bindingImpl;
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> annotatedWithInternal(Class<? extends Annotation> cls) {
        Preconditions.checkNotNull(cls, "annotationType");
        checkNotAnnotated();
        BindingImpl<T> bindingImpl = this.binding;
        return setBinding(bindingImpl.withKey(Key.get(bindingImpl.getKey().getTypeLiteral(), cls)));
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> annotatedWithInternal(Annotation annotation) {
        Preconditions.checkNotNull(annotation, ElementTags.ANNOTATION);
        checkNotAnnotated();
        BindingImpl<T> bindingImpl = this.binding;
        return setBinding(bindingImpl.withKey(Key.get(bindingImpl.getKey().getTypeLiteral(), annotation)));
    }

    /* renamed from: in */
    public void mo36531in(Class<? extends Annotation> cls) {
        Preconditions.checkNotNull(cls, "scopeAnnotation");
        checkNotScoped();
        setBinding(getBinding().withScoping(Scoping.forAnnotation(cls)));
    }

    /* renamed from: in */
    public void mo36530in(Scope scope) {
        Preconditions.checkNotNull(scope, "scope");
        checkNotScoped();
        setBinding(getBinding().withScoping(Scoping.forInstance(scope)));
    }

    public void asEagerSingleton() {
        checkNotScoped();
        setBinding(getBinding().withScoping(Scoping.EAGER_SINGLETON));
    }

    /* access modifiers changed from: protected */
    public boolean keyTypeIsSet() {
        return !Void.class.equals(this.binding.getKey().getTypeLiteral().getType());
    }

    /* access modifiers changed from: protected */
    public void checkNotTargetted() {
        if (!(this.binding instanceof UntargettedBindingImpl)) {
            this.binder.addError(IMPLEMENTATION_ALREADY_SET, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void checkNotAnnotated() {
        if (this.binding.getKey().getAnnotationType() != null) {
            this.binder.addError(ANNOTATION_ALREADY_SPECIFIED, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void checkNotScoped() {
        BindingImpl<T> bindingImpl = this.binding;
        if (bindingImpl instanceof InstanceBinding) {
            this.binder.addError(SINGLE_INSTANCE_AND_SCOPE, new Object[0]);
        } else if (bindingImpl.getScoping().isExplicitlyScoped()) {
            this.binder.addError(SCOPE_ALREADY_SET, new Object[0]);
        }
    }
}
