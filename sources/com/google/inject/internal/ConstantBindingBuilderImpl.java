package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.ConstantBindingBuilder;
import com.google.inject.spi.Element;
import java.lang.annotation.Annotation;
import java.util.List;

public final class ConstantBindingBuilderImpl<T> extends AbstractBindingBuilder<T> implements AnnotatedConstantBindingBuilder, ConstantBindingBuilder {
    public String toString() {
        return "ConstantBindingBuilder";
    }

    public ConstantBindingBuilderImpl(Binder binder, List<Element> list, Object obj) {
        super(binder, list, obj, NULL_KEY);
    }

    public ConstantBindingBuilder annotatedWith(Class<? extends Annotation> cls) {
        annotatedWithInternal(cls);
        return this;
    }

    public ConstantBindingBuilder annotatedWith(Annotation annotation) {
        annotatedWithInternal(annotation);
        return this;
    }

    /* renamed from: to */
    public void mo36510to(String str) {
        toConstant(String.class, str);
    }

    /* renamed from: to */
    public void mo36506to(int i) {
        toConstant(Integer.class, Integer.valueOf(i));
    }

    /* renamed from: to */
    public void mo36507to(long j) {
        toConstant(Long.class, Long.valueOf(j));
    }

    /* renamed from: to */
    public void mo36512to(boolean z) {
        toConstant(Boolean.class, Boolean.valueOf(z));
    }

    /* renamed from: to */
    public void mo36504to(double d) {
        toConstant(Double.class, Double.valueOf(d));
    }

    /* renamed from: to */
    public void mo36505to(float f) {
        toConstant(Float.class, Float.valueOf(f));
    }

    /* renamed from: to */
    public void mo36511to(short s) {
        toConstant(Short.class, Short.valueOf(s));
    }

    /* renamed from: to */
    public void mo36503to(char c) {
        toConstant(Character.class, Character.valueOf(c));
    }

    /* renamed from: to */
    public void mo36508to(Class<?> cls) {
        toConstant(Class.class, cls);
    }

    /* renamed from: to */
    public <E extends Enum<E>> void mo36509to(E e) {
        toConstant(e.getDeclaringClass(), e);
    }

    private void toConstant(Class<?> cls, Object obj) {
        Key<? extends Annotation> key;
        if (keyTypeIsSet()) {
            this.binder.addError(AbstractBindingBuilder.CONSTANT_VALUE_ALREADY_SET, new Object[0]);
            return;
        }
        BindingImpl binding = getBinding();
        if (binding.getKey().getAnnotation() != null) {
            key = Key.get(cls, binding.getKey().getAnnotation());
        } else if (binding.getKey().getAnnotationType() != null) {
            key = Key.get(cls, binding.getKey().getAnnotationType());
        } else {
            key = Key.get(cls);
        }
        Key<? extends Annotation> key2 = key;
        if (obj == null) {
            this.binder.addError(AbstractBindingBuilder.BINDING_TO_NULL, new Object[0]);
        }
        setBinding(new InstanceBindingImpl(binding.getSource(), key2, binding.getScoping(), ImmutableSet.m348of(), obj));
    }
}
