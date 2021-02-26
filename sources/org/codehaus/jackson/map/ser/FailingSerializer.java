package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;

public final class FailingSerializer extends SerializerBase<Object> {
    final String _msg;

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        return null;
    }

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        throw new JsonGenerationException(this._msg);
    }
}
