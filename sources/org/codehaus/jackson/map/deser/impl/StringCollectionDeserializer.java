package org.codehaus.jackson.map.deser.impl;

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
import org.codehaus.jackson.map.deser.ContainerDeserializer;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public final class StringCollectionDeserializer extends ContainerDeserializer<Collection<String>> {
    protected final JavaType _collectionType;
    final Constructor<Collection<String>> _defaultCtor;
    protected final boolean _isDefaultDeserializer;
    protected final JsonDeserializer<String> _valueDeserializer;

    public StringCollectionDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, Constructor<?> constructor) {
        super(javaType.getRawClass());
        this._collectionType = javaType;
        this._valueDeserializer = jsonDeserializer;
        this._defaultCtor = constructor;
        this._isDefaultDeserializer = isDefaultSerializer(jsonDeserializer);
    }

    public JavaType getContentType() {
        return this._collectionType.getContentType();
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            return deserialize(jsonParser, deserializationContext, (Collection<String>) this._defaultCtor.newInstance(new Object[0]));
        } catch (Exception e) {
            throw deserializationContext.instantiationException(this._collectionType.getRawClass(), (Throwable) e);
        }
    }

    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException, JsonProcessingException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        if (!this._isDefaultDeserializer) {
            return deserializeUsingCustom(jsonParser, deserializationContext, collection);
        }
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                return collection;
            }
            collection.add(nextToken == JsonToken.VALUE_NULL ? null : jsonParser.getText());
        }
    }

    private Collection<String> deserializeUsingCustom(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException, JsonProcessingException {
        String str;
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                return collection;
            }
            if (nextToken == JsonToken.VALUE_NULL) {
                str = null;
            } else {
                str = jsonDeserializer.deserialize(jsonParser, deserializationContext);
            }
            collection.add(str);
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private final Collection<String> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException, JsonProcessingException {
        String str;
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                str = null;
            } else {
                str = jsonDeserializer == null ? jsonParser.getText() : jsonDeserializer.deserialize(jsonParser, deserializationContext);
            }
            collection.add(str);
            return collection;
        }
        throw deserializationContext.mappingException(this._collectionType.getRawClass());
    }
}
