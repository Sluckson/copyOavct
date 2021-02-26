package com.google.inject;

import com.google.inject.internal.Annotations;
import com.google.inject.internal.MoreTypes;
import com.google.inject.internal.Preconditions;
import com.google.inject.internal.ToStringBuilder;
import com.lowagie.text.ElementTags;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class Key<T> {
    private final AnnotationStrategy annotationStrategy;
    private final int hashCode;
    private final TypeLiteral<T> typeLiteral;

    interface AnnotationStrategy {
        Annotation getAnnotation();

        Class<? extends Annotation> getAnnotationType();

        boolean hasAttributes();

        AnnotationStrategy withoutAttributes();
    }

    protected Key(Class<? extends Annotation> cls) {
        this.annotationStrategy = strategyFor(cls);
        this.typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
        this.hashCode = computeHashCode();
    }

    protected Key(Annotation annotation) {
        this.annotationStrategy = strategyFor(annotation);
        this.typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
        this.hashCode = computeHashCode();
    }

    protected Key() {
        this.annotationStrategy = NullAnnotationStrategy.INSTANCE;
        this.typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
        this.hashCode = computeHashCode();
    }

    private Key(Type type, AnnotationStrategy annotationStrategy2) {
        this.annotationStrategy = annotationStrategy2;
        this.typeLiteral = MoreTypes.makeKeySafe(TypeLiteral.get(type));
        this.hashCode = computeHashCode();
    }

    private Key(TypeLiteral<T> typeLiteral2, AnnotationStrategy annotationStrategy2) {
        this.annotationStrategy = annotationStrategy2;
        this.typeLiteral = MoreTypes.makeKeySafe(typeLiteral2);
        this.hashCode = computeHashCode();
    }

    private int computeHashCode() {
        return (this.typeLiteral.hashCode() * 31) + this.annotationStrategy.hashCode();
    }

    public final TypeLiteral<T> getTypeLiteral() {
        return this.typeLiteral;
    }

    public final Class<? extends Annotation> getAnnotationType() {
        return this.annotationStrategy.getAnnotationType();
    }

    public final Annotation getAnnotation() {
        return this.annotationStrategy.getAnnotation();
    }

    /* access modifiers changed from: package-private */
    public boolean hasAnnotationType() {
        return this.annotationStrategy.getAnnotationType() != null;
    }

    /* access modifiers changed from: package-private */
    public String getAnnotationName() {
        Annotation annotation = this.annotationStrategy.getAnnotation();
        if (annotation != null) {
            return annotation.toString();
        }
        return this.annotationStrategy.getAnnotationType().toString();
    }

    /* access modifiers changed from: package-private */
    public Class<? super T> getRawType() {
        return this.typeLiteral.getRawType();
    }

    /* access modifiers changed from: package-private */
    public Key<Provider<T>> providerKey() {
        return ofType(this.typeLiteral.providerType());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        Key key = (Key) obj;
        if (!this.annotationStrategy.equals(key.annotationStrategy) || !this.typeLiteral.equals(key.typeLiteral)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final String toString() {
        return new ToStringBuilder(Key.class).add("type", this.typeLiteral).add(ElementTags.ANNOTATION, this.annotationStrategy).toString();
    }

    static <T> Key<T> get(Class<T> cls, AnnotationStrategy annotationStrategy2) {
        return new Key<>((Type) cls, annotationStrategy2);
    }

    public static <T> Key<T> get(Class<T> cls) {
        return new Key<>((Type) cls, (AnnotationStrategy) NullAnnotationStrategy.INSTANCE);
    }

    public static <T> Key<T> get(Class<T> cls, Class<? extends Annotation> cls2) {
        return new Key<>((Type) cls, strategyFor(cls2));
    }

    public static <T> Key<T> get(Class<T> cls, Annotation annotation) {
        return new Key<>((Type) cls, strategyFor(annotation));
    }

    public static Key<?> get(Type type) {
        return new Key<>(type, (AnnotationStrategy) NullAnnotationStrategy.INSTANCE);
    }

    public static Key<?> get(Type type, Class<? extends Annotation> cls) {
        return new Key<>(type, strategyFor(cls));
    }

    public static Key<?> get(Type type, Annotation annotation) {
        return new Key<>(type, strategyFor(annotation));
    }

    public static <T> Key<T> get(TypeLiteral<T> typeLiteral2) {
        return new Key<>(typeLiteral2, (AnnotationStrategy) NullAnnotationStrategy.INSTANCE);
    }

    public static <T> Key<T> get(TypeLiteral<T> typeLiteral2, Class<? extends Annotation> cls) {
        return new Key<>(typeLiteral2, strategyFor(cls));
    }

    public static <T> Key<T> get(TypeLiteral<T> typeLiteral2, Annotation annotation) {
        return new Key<>(typeLiteral2, strategyFor(annotation));
    }

    /* access modifiers changed from: package-private */
    public <T> Key<T> ofType(Class<T> cls) {
        return new Key<>((Type) cls, this.annotationStrategy);
    }

    /* access modifiers changed from: package-private */
    public Key<?> ofType(Type type) {
        return new Key<>(type, this.annotationStrategy);
    }

    /* access modifiers changed from: package-private */
    public <T> Key<T> ofType(TypeLiteral<T> typeLiteral2) {
        return new Key<>(typeLiteral2, this.annotationStrategy);
    }

    /* access modifiers changed from: package-private */
    public boolean hasAttributes() {
        return this.annotationStrategy.hasAttributes();
    }

    /* access modifiers changed from: package-private */
    public Key<T> withoutAttributes() {
        return new Key<>(this.typeLiteral, this.annotationStrategy.withoutAttributes());
    }

    static boolean isMarker(Class<? extends Annotation> cls) {
        return cls.getDeclaredMethods().length == 0;
    }

    static AnnotationStrategy strategyFor(Annotation annotation) {
        Preconditions.checkNotNull(annotation, ElementTags.ANNOTATION);
        Class<? extends Annotation> annotationType = annotation.annotationType();
        ensureRetainedAtRuntime(annotationType);
        ensureIsBindingAnnotation(annotationType);
        if (annotationType.getDeclaredMethods().length == 0) {
            return new AnnotationTypeStrategy(annotationType, annotation);
        }
        return new AnnotationInstanceStrategy(annotation);
    }

    static AnnotationStrategy strategyFor(Class<? extends Annotation> cls) {
        Preconditions.checkNotNull(cls, "annotation type");
        ensureRetainedAtRuntime(cls);
        ensureIsBindingAnnotation(cls);
        return new AnnotationTypeStrategy(cls, (Annotation) null);
    }

    private static void ensureRetainedAtRuntime(Class<? extends Annotation> cls) {
        Preconditions.checkArgument(Annotations.isRetainedAtRuntime(cls), "%s is not retained at runtime. Please annotate it with @Retention(RUNTIME).", cls.getName());
    }

    private static void ensureIsBindingAnnotation(Class<? extends Annotation> cls) {
        Preconditions.checkArgument(isBindingAnnotation(cls), "%s is not a binding annotation. Please annotate it with @BindingAnnotation.", cls.getName());
    }

    enum NullAnnotationStrategy implements AnnotationStrategy {
        INSTANCE;

        public Annotation getAnnotation() {
            return null;
        }

        public Class<? extends Annotation> getAnnotationType() {
            return null;
        }

        public boolean hasAttributes() {
            return false;
        }

        public String toString() {
            return "[none]";
        }

        public AnnotationStrategy withoutAttributes() {
            throw new UnsupportedOperationException("Key already has no attributes.");
        }
    }

    static class AnnotationInstanceStrategy implements AnnotationStrategy {
        final Annotation annotation;

        public boolean hasAttributes() {
            return true;
        }

        AnnotationInstanceStrategy(Annotation annotation2) {
            this.annotation = (Annotation) Preconditions.checkNotNull(annotation2, ElementTags.ANNOTATION);
        }

        public AnnotationStrategy withoutAttributes() {
            return new AnnotationTypeStrategy(getAnnotationType(), this.annotation);
        }

        public Annotation getAnnotation() {
            return this.annotation;
        }

        public Class<? extends Annotation> getAnnotationType() {
            return this.annotation.annotationType();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AnnotationInstanceStrategy)) {
                return false;
            }
            return this.annotation.equals(((AnnotationInstanceStrategy) obj).annotation);
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        public String toString() {
            return this.annotation.toString();
        }
    }

    static class AnnotationTypeStrategy implements AnnotationStrategy {
        final Annotation annotation;
        final Class<? extends Annotation> annotationType;

        public boolean hasAttributes() {
            return false;
        }

        AnnotationTypeStrategy(Class<? extends Annotation> cls, Annotation annotation2) {
            this.annotationType = (Class) Preconditions.checkNotNull(cls, "annotation type");
            this.annotation = annotation2;
        }

        public AnnotationStrategy withoutAttributes() {
            throw new UnsupportedOperationException("Key already has no attributes.");
        }

        public Annotation getAnnotation() {
            return this.annotation;
        }

        public Class<? extends Annotation> getAnnotationType() {
            return this.annotationType;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AnnotationTypeStrategy)) {
                return false;
            }
            return this.annotationType.equals(((AnnotationTypeStrategy) obj).annotationType);
        }

        public int hashCode() {
            return this.annotationType.hashCode();
        }

        public String toString() {
            return "@" + this.annotationType.getName();
        }
    }

    static boolean isBindingAnnotation(Annotation annotation) {
        return isBindingAnnotation(annotation.annotationType());
    }

    static boolean isBindingAnnotation(Class<? extends Annotation> cls) {
        return cls.isAnnotationPresent(BindingAnnotation.class);
    }
}
