package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.type.JavaType;

public class AbstractDeserializer extends JsonDeserializer<Object> {
    protected final JavaType _baseType;

    public AbstractDeserializer(JavaType javaType) {
        this._baseType = javaType;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        switch (jsonParser.getCurrentToken()) {
            case VALUE_STRING:
                return jsonParser.getText();
            case VALUE_NUMBER_INT:
                if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.getBigIntegerValue();
                }
                return Integer.valueOf(jsonParser.getIntValue());
            case VALUE_NUMBER_FLOAT:
                if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.getDecimalValue();
                }
                return Double.valueOf(jsonParser.getDoubleValue());
            case VALUE_TRUE:
                return Boolean.TRUE;
            case VALUE_FALSE:
                return Boolean.FALSE;
            case VALUE_EMBEDDED_OBJECT:
                return jsonParser.getEmbeddedObject();
            case VALUE_NULL:
                return null;
            case START_ARRAY:
                return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
            default:
                return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        throw deserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types can only be instantiated with additional type information");
    }
}
