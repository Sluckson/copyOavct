package org.codehaus.jackson.node;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public abstract class BaseJsonNode extends JsonNode implements JsonSerializableWithType {
    public abstract JsonToken asToken();

    public ObjectNode findParent(String str) {
        return null;
    }

    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        return list;
    }

    public JsonNode findValue(String str) {
        return null;
    }

    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        return list;
    }

    public List<String> findValuesAsText(String str, List<String> list) {
        return list;
    }

    public JsonParser.NumberType getNumberType() {
        return null;
    }

    public abstract void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException;

    public abstract void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException;

    protected BaseJsonNode() {
    }

    public final JsonNode findPath(String str) {
        JsonNode findValue = findValue(str);
        return findValue == null ? MissingNode.getInstance() : findValue;
    }

    public JsonParser traverse() {
        return new TreeTraversingParser(this);
    }

    public final void writeTo(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        serialize(jsonGenerator, (SerializerProvider) null);
    }
}
