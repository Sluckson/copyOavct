package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import java.util.HashMap;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;

public abstract class TypeDeserializerBase extends TypeDeserializer {
    protected final JavaType _baseType;
    protected final HashMap<String, JsonDeserializer<Object>> _deserializers = new HashMap<>();
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    public String getPropertyName() {
        return null;
    }

    public abstract JsonTypeInfo.C4903As getTypeInclusion();

    protected TypeDeserializerBase(JavaType javaType, TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this._baseType = javaType;
        this._idResolver = typeIdResolver;
        this._property = beanProperty;
    }

    public String baseTypeName() {
        return this._baseType.getRawClass().getName();
    }

    public TypeIdResolver getTypeIdResolver() {
        return this._idResolver;
    }

    public String toString() {
        return '[' + getClass().getName() + "; base-type:" + this._baseType + "; id-resolver: " + this._idResolver + ']';
    }

    /* access modifiers changed from: protected */
    public final JsonDeserializer<Object> _findDeserializer(DeserializationContext deserializationContext, String str) throws IOException, JsonProcessingException {
        JsonDeserializer<Object> jsonDeserializer;
        synchronized (this._deserializers) {
            jsonDeserializer = this._deserializers.get(str);
            if (jsonDeserializer == null) {
                JavaType typeFromId = this._idResolver.typeFromId(str);
                if (typeFromId != null) {
                    if (this._baseType != null && this._baseType.getClass() == typeFromId.getClass()) {
                        typeFromId = this._baseType.narrowBy(typeFromId.getRawClass());
                    }
                    jsonDeserializer = deserializationContext.getDeserializerProvider().findValueDeserializer(deserializationContext.getConfig(), typeFromId, this._property);
                    this._deserializers.put(str, jsonDeserializer);
                } else {
                    throw deserializationContext.unknownTypeException(this._baseType, str);
                }
            }
        }
        return jsonDeserializer;
    }
}
