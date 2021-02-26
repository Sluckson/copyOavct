package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.EnumMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;

public final class EnumMapDeserializer extends StdDeserializer<EnumMap<?, ?>> {
    final EnumResolver<?> _enumResolver;
    final JsonDeserializer<Object> _valueDeserializer;

    public EnumMapDeserializer(EnumResolver<?> enumResolver, JsonDeserializer<Object> jsonDeserializer) {
        super((Class<?>) EnumMap.class);
        this._enumResolver = enumResolver;
        this._valueDeserializer = jsonDeserializer;
    }

    public EnumMap<?, ?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
            EnumMap<?, ?> constructMap = constructMap();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                Enum findEnum = this._enumResolver.findEnum(jsonParser.getCurrentName());
                if (findEnum != null) {
                    constructMap.put(findEnum, jsonParser.nextToken() == JsonToken.VALUE_NULL ? null : this._valueDeserializer.deserialize(jsonParser, deserializationContext));
                } else {
                    throw deserializationContext.weirdStringException(this._enumResolver.getEnumClass(), "value not one of declared Enum instance names");
                }
            }
            return constructMap;
        }
        throw deserializationContext.mappingException((Class<?>) EnumMap.class);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    private EnumMap<?, ?> constructMap() {
        return new EnumMap<>(this._enumResolver.getEnumClass());
    }
}
