package org.codehaus.jackson.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> implements Comparable<TypeReference<T>> {
    final Type _type;

    public int compareTo(TypeReference<T> typeReference) {
        return 0;
    }

    protected TypeReference() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            this._type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            return;
        }
        throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }

    public Type getType() {
        return this._type;
    }
}
