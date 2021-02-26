package org.codehaus.jackson.map.ser.impl;

import java.io.IOException;
import java.util.Collection;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> implements ResolvableSerializer {
    protected JsonSerializer<String> _serializer;

    public StringCollectionSerializer(BeanProperty beanProperty) {
        super(Collection.class, beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonNode contentSchema() {
        return createSchemaNode("string", true);
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<Object> findValueSerializer = serializerProvider.findValueSerializer((Class<?>) String.class, this._property);
        if (!isDefaultSerializer(findValueSerializer)) {
            this._serializer = findValueSerializer;
        }
    }

    public void serialize(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartArray();
        if (this._serializer == null) {
            serializeContents(collection, jsonGenerator, serializerProvider);
        } else {
            serializeUsingCustom(collection, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
    }

    public void serializeWithType(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
        typeSerializer.writeTypePrefixForArray(collection, jsonGenerator);
        if (this._serializer == null) {
            serializeContents(collection, jsonGenerator, serializerProvider);
        } else {
            serializeUsingCustom(collection, jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffixForArray(collection, jsonGenerator);
    }

    private final void serializeContents(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        if (this._serializer != null) {
            serializeUsingCustom(collection, jsonGenerator, serializerProvider);
            return;
        }
        int i = 0;
        for (String next : collection) {
            if (next == null) {
                try {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, i);
                }
            } else {
                jsonGenerator.writeString(next);
            }
            i++;
        }
    }

    private void serializeUsingCustom(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        JsonSerializer<String> jsonSerializer = this._serializer;
        for (String next : collection) {
            if (next == null) {
                try {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, 0);
                }
            } else {
                jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
            }
        }
    }
}
