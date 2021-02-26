package org.codehaus.jackson.map.jsontype.impl;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public abstract class TypeSerializerBase extends TypeSerializer {
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    public String getPropertyName() {
        return null;
    }

    public abstract JsonTypeInfo.C4903As getTypeInclusion();

    protected TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this._idResolver = typeIdResolver;
        this._property = beanProperty;
    }

    public TypeIdResolver getTypeIdResolver() {
        return this._idResolver;
    }
}
