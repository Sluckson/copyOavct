package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collection;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class CollectionDeserializer extends ContainerDeserializer<Collection<Object>> {
    protected final JavaType _collectionType;
    final Constructor<Collection<Object>> _defaultCtor;
    final JsonDeserializer<Object> _valueDeserializer;
    final TypeDeserializer _valueTypeDeserializer;

    public CollectionDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, Constructor<Collection<Object>> constructor) {
        super(javaType.getRawClass());
        this._collectionType = javaType;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        if (constructor != null) {
            this._defaultCtor = constructor;
            return;
        }
        throw new IllegalArgumentException("No default constructor found for container class " + javaType.getRawClass().getName());
    }

    public JavaType getContentType() {
        return this._collectionType.getContentType();
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            return deserialize(jsonParser, deserializationContext, (Collection<Object>) this._defaultCtor.newInstance(new Object[0]));
        } catch (Exception e) {
            throw deserializationContext.instantiationException(this._collectionType.getRawClass(), (Throwable) e);
        }
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException, JsonProcessingException {
        Object obj;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                return collection;
            }
            if (nextToken == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
            collection.add(obj);
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private final Collection<Object> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException, JsonProcessingException {
        Object obj;
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
            collection.add(obj);
            return collection;
        }
        throw deserializationContext.mappingException(this._collectionType.getRawClass());
    }
}
