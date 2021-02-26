package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;

public class AsArrayTypeDeserializer extends TypeDeserializerBase {
    public AsArrayTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(javaType, typeIdResolver, beanProperty);
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.WRAPPER_ARRAY;
    }

    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    private final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object deserialize = _findDeserializer(deserializationContext, _locateTypeId(jsonParser, deserializationContext)).deserialize(jsonParser, deserializationContext);
        if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
            return deserialize;
        }
        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }

    /* access modifiers changed from: protected */
    public final String _locateTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            JsonToken jsonToken = JsonToken.START_ARRAY;
            throw deserializationContext.wrongTokenException(jsonParser, jsonToken, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName());
        } else if (jsonParser.nextToken() == JsonToken.VALUE_STRING) {
            String text = jsonParser.getText();
            jsonParser.nextToken();
            return text;
        } else {
            JsonToken jsonToken2 = JsonToken.VALUE_STRING;
            throw deserializationContext.wrongTokenException(jsonParser, jsonToken2, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
        }
    }
}
