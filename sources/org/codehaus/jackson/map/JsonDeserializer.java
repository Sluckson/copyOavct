package org.codehaus.jackson.map;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;

public abstract class JsonDeserializer<T> {

    public static abstract class None extends JsonDeserializer<Object> {
    }

    public abstract T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    public T getNullValue() {
        return null;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException();
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }
}
