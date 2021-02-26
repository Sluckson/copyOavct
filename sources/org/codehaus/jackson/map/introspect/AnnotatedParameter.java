package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import org.codehaus.jackson.map.type.TypeFactory;

public final class AnnotatedParameter extends AnnotatedMember {
    protected final AnnotationMap _annotations;
    protected final AnnotatedMember _owner;
    protected final Type _type;

    public AnnotatedElement getAnnotated() {
        return null;
    }

    public String getName() {
        return "";
    }

    public AnnotatedParameter(AnnotatedMember annotatedMember, Type type, AnnotationMap annotationMap) {
        this._owner = annotatedMember;
        this._type = type;
        this._annotations = annotationMap;
    }

    public void addOrOverride(Annotation annotation) {
        this._annotations.add(annotation);
    }

    public int getModifiers() {
        return this._owner.getModifiers();
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotations.get(cls);
    }

    public Type getGenericType() {
        return this._type;
    }

    public Class<?> getRawType() {
        Type type = this._type;
        if (type instanceof Class) {
            return (Class) type;
        }
        return TypeFactory.defaultInstance().constructType(this._type).getRawClass();
    }

    public Class<?> getDeclaringClass() {
        return this._owner.getDeclaringClass();
    }

    public Member getMember() {
        return this._owner.getMember();
    }

    public Type getParameterType() {
        return this._type;
    }
}
