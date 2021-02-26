package com.google.inject.internal;

import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.ScopeAnnotation;
import com.google.inject.TypeLiteral;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Member;

public class Annotations {
    public static boolean isRetainedAtRuntime(Class<? extends Annotation> cls) {
        Retention retention = (Retention) cls.getAnnotation(Retention.class);
        return retention != null && retention.value() == RetentionPolicy.RUNTIME;
    }

    public static Class<? extends Annotation> findScopeAnnotation(Errors errors, Class<?> cls) {
        return findScopeAnnotation(errors, cls.getAnnotations());
    }

    public static Class<? extends Annotation> findScopeAnnotation(Errors errors, Annotation[] annotationArr) {
        Class<? extends Annotation> cls = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(ScopeAnnotation.class)) {
                if (cls != null) {
                    errors.duplicateScopeAnnotations(cls, annotation.annotationType());
                } else {
                    cls = annotation.annotationType();
                }
            }
        }
        return cls;
    }

    public static boolean isScopeAnnotation(Class<? extends Annotation> cls) {
        return cls.isAnnotationPresent(ScopeAnnotation.class);
    }

    public static void checkForMisplacedScopeAnnotations(Class<?> cls, Object obj, Errors errors) {
        Class<? extends Annotation> findScopeAnnotation;
        if (!Classes.isConcrete(cls) && (findScopeAnnotation = findScopeAnnotation(errors, cls)) != null) {
            errors.withSource(cls).scopeAnnotationOnAbstractType(findScopeAnnotation, cls, obj);
        }
    }

    public static Key<?> getKey(TypeLiteral<?> typeLiteral, Member member, Annotation[] annotationArr, Errors errors) throws ErrorsException {
        int size = errors.size();
        Annotation findBindingAnnotation = findBindingAnnotation(errors, member, annotationArr);
        errors.throwIfNewErrors(size);
        return findBindingAnnotation == null ? Key.get(typeLiteral) : Key.get(typeLiteral, findBindingAnnotation);
    }

    public static Annotation findBindingAnnotation(Errors errors, Member member, Annotation[] annotationArr) {
        Annotation annotation = null;
        for (Annotation annotation2 : annotationArr) {
            if (annotation2.annotationType().isAnnotationPresent(BindingAnnotation.class)) {
                if (annotation != null) {
                    errors.duplicateBindingAnnotations(member, annotation.annotationType(), annotation2.annotationType());
                } else {
                    annotation = annotation2;
                }
            }
        }
        return annotation;
    }
}
