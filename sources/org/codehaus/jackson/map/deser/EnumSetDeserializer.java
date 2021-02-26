package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.EnumSet;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.TypeDeserializer;

public final class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> {
    final Class<Enum> _enumClass;
    final EnumDeserializer _enumDeserializer;

    public EnumSetDeserializer(EnumResolver enumResolver) {
        super((Class<?>) EnumSet.class);
        this._enumDeserializer = new EnumDeserializer(enumResolver);
        this._enumClass = enumResolver.getEnumClass();
    }

    public EnumSet<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.isExpectedStartArrayToken()) {
            EnumSet<?> constructSet = constructSet();
            while (true) {
                JsonToken nextToken = jsonParser.nextToken();
                if (nextToken == JsonToken.END_ARRAY) {
                    return constructSet;
                }
                if (nextToken != JsonToken.VALUE_NULL) {
                    constructSet.add(this._enumDeserializer.deserialize(jsonParser, deserializationContext));
                } else {
                    throw deserializationContext.mappingException((Class<?>) this._enumClass);
                }
            }
        } else {
            throw deserializationContext.mappingException((Class<?>) EnumSet.class);
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private EnumSet constructSet() {
        return EnumSet.noneOf(this._enumClass);
    }
}
