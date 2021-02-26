package org.codehaus.jackson.map;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

public abstract class JsonSerializer<T> {

    public static abstract class None extends JsonSerializer<Object> {
    }

    public Class<T> handledType() {
        return null;
    }

    public abstract void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException;

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        serialize(t, jsonGenerator, serializerProvider);
    }
}
