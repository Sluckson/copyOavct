package org.codehaus.jackson.node;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public abstract class ValueNode extends BaseJsonNode {
    public abstract JsonToken asToken();

    public boolean isValueNode() {
        return true;
    }

    protected ValueNode() {
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        typeSerializer.writeTypePrefixForScalar(this, jsonGenerator);
        serialize(jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForScalar(this, jsonGenerator);
    }

    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    public String toString() {
        return getValueAsText();
    }
}
