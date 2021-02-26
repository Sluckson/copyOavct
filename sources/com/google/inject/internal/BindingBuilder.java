package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.ConfigurationException;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.spi.Element;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.Message;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

public class BindingBuilder<T> extends AbstractBindingBuilder<T> implements AnnotatedBindingBuilder<T> {
    public BindingBuilder(Binder binder, List<Element> list, Object obj, Key<T> key) {
        super(binder, list, obj, key);
    }

    public BindingBuilder<T> annotatedWith(Class<? extends Annotation> cls) {
        annotatedWithInternal(cls);
        return this;
    }

    public BindingBuilder<T> annotatedWith(Annotation annotation) {
        annotatedWithInternal(annotation);
        return this;
    }

    /* renamed from: to */
    public BindingBuilder<T> m324to(Class<? extends T> cls) {
        return mo36513to((Key) Key.get(cls));
    }

    /* renamed from: to */
    public BindingBuilder<T> m323to(TypeLiteral<? extends T> typeLiteral) {
        return mo36513to((Key) Key.get(typeLiteral));
    }

    /* renamed from: to */
    public BindingBuilder<T> m322to(Key<? extends T> key) {
        Preconditions.checkNotNull(key, "linkedKey");
        checkNotTargetted();
        BindingImpl binding = getBinding();
        setBinding(new LinkedBindingImpl(binding.getSource(), binding.getKey(), binding.getScoping(), key));
        return this;
    }

    public void toInstance(T t) {
        Set<InjectionPoint> set;
        checkNotTargetted();
        if (t != null) {
            try {
                set = InjectionPoint.forInstanceMethodsAndFields(t.getClass());
            } catch (ConfigurationException e) {
                for (Message addError : e.getErrorMessages()) {
                    this.binder.addError(addError);
                }
                set = (Set) e.getPartialValue();
            }
        } else {
            this.binder.addError(AbstractBindingBuilder.BINDING_TO_NULL, new Object[0]);
            set = ImmutableSet.m348of();
        }
        Set<InjectionPoint> set2 = set;
        BindingImpl binding = getBinding();
        setBinding(new InstanceBindingImpl(binding.getSource(), binding.getKey(), binding.getScoping(), set2, t));
    }

    public BindingBuilder<T> toProvider(Provider<? extends T> provider) {
        Set<InjectionPoint> set;
        Preconditions.checkNotNull(provider, "provider");
        checkNotTargetted();
        try {
            set = InjectionPoint.forInstanceMethodsAndFields(provider.getClass());
        } catch (ConfigurationException e) {
            for (Message addError : e.getErrorMessages()) {
                this.binder.addError(addError);
            }
            set = (Set) e.getPartialValue();
        }
        Set<InjectionPoint> set2 = set;
        BindingImpl binding = getBinding();
        setBinding(new ProviderInstanceBindingImpl(binding.getSource(), binding.getKey(), binding.getScoping(), set2, provider));
        return this;
    }

    public BindingBuilder<T> toProvider(Class<? extends Provider<? extends T>> cls) {
        return toProvider((Key) Key.get(cls));
    }

    public BindingBuilder<T> toProvider(Key<? extends Provider<? extends T>> key) {
        Preconditions.checkNotNull(key, "providerKey");
        checkNotTargetted();
        BindingImpl binding = getBinding();
        setBinding(new LinkedProviderBindingImpl(binding.getSource(), binding.getKey(), binding.getScoping(), key));
        return this;
    }

    public String toString() {
        return "BindingBuilder<" + getBinding().getKey().getTypeLiteral() + ">";
    }
}
