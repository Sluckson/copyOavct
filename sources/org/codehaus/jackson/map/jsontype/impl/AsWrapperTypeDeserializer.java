package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;

public class AsWrapperTypeDeserializer extends TypeDeserializerBase {
    public AsWrapperTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(javaType, typeIdResolver, beanProperty);
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.WRAPPER_OBJECT;
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _deserialize(jsonParser, deserializationContext);
    }

    private final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            JsonToken jsonToken = JsonToken.START_OBJECT;
            throw deserializationContext.wrongTokenException(jsonParser, jsonToken, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + baseTypeName());
        } else if (jsonParser.nextToken() == JsonToken.FIELD_NAME) {
            JsonDeserializer<Object> _findDeserializer = _findDeserializer(deserializationContext, jsonParser.getText());
            jsonParser.nextToken();
            Object deserialize = _findDeserializer.deserialize(jsonParser, deserializationContext);
            if (jsonParser.nextToken() == JsonToken.END_OBJECT) {
                return deserialize;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value");
        } else {
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            throw deserializationContext.wrongTokenException(jsonParser, jsonToken2, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
        }
    }
}
