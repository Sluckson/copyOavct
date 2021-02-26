package org.codehaus.jackson.map.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HierarchicType {
    protected final Type _actualType;
    protected final ParameterizedType _genericType;
    protected final Class<?> _rawClass;
    protected HierarchicType _subType;
    protected HierarchicType _superType;

    public HierarchicType(Type type) {
        this._actualType = type;
        if (type instanceof Class) {
            this._rawClass = (Class) type;
            this._genericType = null;
        } else if (type instanceof ParameterizedType) {
            this._genericType = (ParameterizedType) type;
            this._rawClass = (Class) this._genericType.getRawType();
        } else {
            throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
        }
    }

    public void setSuperType(HierarchicType hierarchicType) {
        this._superType = hierarchicType;
    }

    public HierarchicType getSuperType() {
        return this._superType;
    }

    public void setSubType(HierarchicType hierarchicType) {
        this._subType = hierarchicType;
    }

    public HierarchicType getSubType() {
        return this._subType;
    }

    public boolean isGeneric() {
        return this._genericType != null;
    }

    public ParameterizedType asGeneric() {
        return this._genericType;
    }

    public Class<?> getRawClass() {
        return this._rawClass;
    }

    public String toString() {
        ParameterizedType parameterizedType = this._genericType;
        if (parameterizedType != null) {
            return parameterizedType.toString();
        }
        return this._rawClass.getName();
    }
}
