package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class ToStringSerializer extends SerializerBase<Object> {
    public static final ToStringSerializer instance = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeString(obj.toString());
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
        typeSerializer.writeTypePrefixForScalar(obj, jsonGenerator);
        serialize(obj, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForScalar(obj, jsonGenerator);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        return createSchemaNode("string", true);
    }
}
