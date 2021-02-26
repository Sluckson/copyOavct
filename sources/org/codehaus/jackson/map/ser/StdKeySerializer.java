package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;

public final class StdKeySerializer extends SerializerBase<Object> {
    static final StdKeySerializer instace = new StdKeySerializer();

    public StdKeySerializer() {
        super(Object.class);
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeFieldName(obj.getClass() == String.class ? (String) obj : obj.toString());
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        return createSchemaNode("string");
    }
}
