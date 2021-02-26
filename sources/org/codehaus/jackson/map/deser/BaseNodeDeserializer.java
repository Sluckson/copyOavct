package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

/* compiled from: JsonNodeDeserializer */
abstract class BaseNodeDeserializer<N extends JsonNode> extends StdDeserializer<N> {
    /* access modifiers changed from: protected */
    public void _handleDuplicateField(String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
    }

    public BaseNodeDeserializer(Class<N> cls) {
        super((Class<?>) cls);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public void _reportProblem(JsonParser jsonParser, String str) throws JsonMappingException {
        throw new JsonMappingException(str, jsonParser.getTokenLocation());
    }

    /* access modifiers changed from: protected */
    public final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectNode objectNode = deserializationContext.getNodeFactory().objectNode();
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            JsonNode deserializeAny = deserializeAny(jsonParser, deserializationContext);
            JsonNode put = objectNode.put(currentName, deserializeAny);
            if (put != null) {
                _handleDuplicateField(currentName, objectNode, put, deserializeAny);
            }
            currentToken = jsonParser.nextToken();
        }
        return objectNode;
    }

    /* access modifiers changed from: protected */
    public final ArrayNode deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ArrayNode arrayNode = deserializationContext.getNodeFactory().arrayNode();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            arrayNode.add(deserializeAny(jsonParser, deserializationContext));
        }
        return arrayNode;
    }

    /* access modifiers changed from: protected */
    public final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        switch (jsonParser.getCurrentToken()) {
            case START_OBJECT:
            case FIELD_NAME:
                return deserializeObject(jsonParser, deserializationContext);
            case START_ARRAY:
                return deserializeArray(jsonParser, deserializationContext);
            case VALUE_STRING:
                return nodeFactory.textNode(jsonParser.getText());
            case VALUE_NUMBER_INT:
                JsonParser.NumberType numberType = jsonParser.getNumberType();
                if (numberType == JsonParser.NumberType.BIG_INTEGER || deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
                    return nodeFactory.numberNode(jsonParser.getBigIntegerValue());
                }
                if (numberType == JsonParser.NumberType.INT) {
                    return nodeFactory.numberNode(jsonParser.getIntValue());
                }
                return nodeFactory.numberNode(jsonParser.getLongValue());
            case VALUE_NUMBER_FLOAT:
                if (jsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL || deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return nodeFactory.numberNode(jsonParser.getDecimalValue());
                }
                return nodeFactory.numberNode(jsonParser.getDoubleValue());
            case VALUE_TRUE:
                return nodeFactory.booleanNode(true);
            case VALUE_FALSE:
                return nodeFactory.booleanNode(false);
            case VALUE_NULL:
                return nodeFactory.nullNode();
            default:
                throw deserializationContext.mappingException(getValueClass());
        }
    }
}
