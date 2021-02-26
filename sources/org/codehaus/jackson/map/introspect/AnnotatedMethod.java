package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.type.JavaType;

public final class AnnotatedMethod extends AnnotatedWithParams {
    protected final Method _method;
    protected Class<?>[] _paramTypes;

    public AnnotatedMethod(Method method, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(annotationMap, annotationMapArr);
        this._method = method;
    }

    public AnnotatedMethod withMethod(Method method) {
        return new AnnotatedMethod(method, this._annotations, this._paramAnnotations);
    }

    public Method getAnnotated() {
        return this._method;
    }

    public int getModifiers() {
        return this._method.getModifiers();
    }

    public String getName() {
        return this._method.getName();
    }

    public Type getGenericType() {
        return this._method.getGenericReturnType();
    }

    public Class<?> getRawType() {
        return this._method.getReturnType();
    }

    public JavaType getType(TypeBindings typeBindings) {
        return getType(typeBindings, this._method.getTypeParameters());
    }

    public Class<?> getDeclaringClass() {
        return this._method.getDeclaringClass();
    }

    public Member getMember() {
        return this._method;
    }

    public AnnotatedParameter getParameter(int i) {
        return new AnnotatedParameter(this, getParameterType(i), this._paramAnnotations[i]);
    }

    public int getParameterCount() {
        return getParameterTypes().length;
    }

    public Type[] getParameterTypes() {
        return this._method.getGenericParameterTypes();
    }

    public Class<?> getParameterClass(int i) {
        Class<?>[] parameterTypes = this._method.getParameterTypes();
        if (i >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i];
    }

    public Type getParameterType(int i) {
        Type[] genericParameterTypes = this._method.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return genericParameterTypes[i];
    }

    public Class<?>[] getParameterClasses() {
        if (this._paramTypes == null) {
            this._paramTypes = this._method.getParameterTypes();
        }
        return this._paramTypes;
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
    }

    public String toString() {
        return "[method " + getName() + ", annotations: " + this._annotations + "]";
    }
}
