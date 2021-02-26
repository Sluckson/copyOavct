package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public abstract class ScalarSerializerBase<T> extends SerializerBase<T> {
    protected ScalarSerializerBase(Class<T> cls) {
        super(cls);
    }

    protected ScalarSerializerBase(Class<?> cls, boolean z) {
        super(cls);
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
        typeSerializer.writeTypePrefixForScalar(t, jsonGenerator);
        serialize(t, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForScalar(t, jsonGenerator);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        return createSchemaNode("string", true);
    }
}
