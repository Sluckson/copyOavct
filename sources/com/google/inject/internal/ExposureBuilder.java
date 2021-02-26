package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.binder.AnnotatedElementBuilder;
import com.lowagie.text.ElementTags;
import java.lang.annotation.Annotation;

public class ExposureBuilder<T> implements AnnotatedElementBuilder {
    private final Binder binder;
    private Key<T> key;
    private final Object source;

    public String toString() {
        return "AnnotatedElementBuilder";
    }

    public ExposureBuilder(Binder binder2, Object obj, Key<T> key2) {
        this.binder = binder2;
        this.source = obj;
        this.key = key2;
    }

    /* access modifiers changed from: protected */
    public void checkNotAnnotated() {
        if (this.key.getAnnotationType() != null) {
            this.binder.addError(AbstractBindingBuilder.ANNOTATION_ALREADY_SPECIFIED, new Object[0]);
        }
    }

    public void annotatedWith(Class<? extends Annotation> cls) {
        Preconditions.checkNotNull(cls, "annotationType");
        checkNotAnnotated();
        this.key = Key.get(this.key.getTypeLiteral(), cls);
    }

    public void annotatedWith(Annotation annotation) {
        Preconditions.checkNotNull(annotation, ElementTags.ANNOTATION);
        checkNotAnnotated();
        this.key = Key.get(this.key.getTypeLiteral(), annotation);
    }

    public Key<?> getKey() {
        return this.key;
    }

    public Object getSource() {
        return this.source;
    }
}
