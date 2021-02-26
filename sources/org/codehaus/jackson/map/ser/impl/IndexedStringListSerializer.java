package org.codehaus.jackson.map.ser.impl;

import java.io.IOException;
import java.util.List;
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
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> implements ResolvableSerializer {
    protected JsonSerializer<String> _serializer;

    public IndexedStringListSerializer(BeanProperty beanProperty) {
        super(List.class, beanProperty);
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

    public void serialize(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartArray();
        if (this._serializer == null) {
            serializeContents(list, jsonGenerator, serializerProvider);
        } else {
            serializeUsingCustom(list, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
    }

    public void serializeWithType(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
        typeSerializer.writeTypePrefixForArray(list, jsonGenerator);
        if (this._serializer == null) {
            serializeContents(list, jsonGenerator, serializerProvider);
        } else {
            serializeUsingCustom(list, jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffixForArray(list, jsonGenerator);
    }

    private final void serializeContents(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (str == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonGenerator.writeString(str);
                }
            }
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, (Object) list, 0);
        }
    }

    private final void serializeUsingCustom(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        try {
            int size = list.size();
            JsonSerializer<String> jsonSerializer = this._serializer;
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (str == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonSerializer.serialize(str, jsonGenerator, serializerProvider);
                }
            }
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, (Object) list, 0);
        }
    }
}
