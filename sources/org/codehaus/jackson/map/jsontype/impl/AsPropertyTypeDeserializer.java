package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.JsonParserSequence;
import org.codehaus.jackson.util.TokenBuffer;

public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {
    protected final String _typePropertyName;

    public AsPropertyTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(javaType, typeIdResolver, beanProperty);
        this._typePropertyName = str;
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.PROPERTY;
    }

    public String getPropertyName() {
        return this._typePropertyName;
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        } else if (currentToken != JsonToken.FIELD_NAME) {
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.START_OBJECT, "need JSON Object to contain As.PROPERTY type information (for class " + baseTypeName() + ")");
        }
        TokenBuffer tokenBuffer = null;
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            if (this._typePropertyName.equals(currentName)) {
                JsonDeserializer<Object> _findDeserializer = _findDeserializer(deserializationContext, jsonParser.getText());
                if (tokenBuffer != null) {
                    jsonParser = JsonParserSequence.createFlattened(tokenBuffer.asParser(jsonParser), jsonParser);
                }
                jsonParser.nextToken();
                return _findDeserializer.deserialize(jsonParser, deserializationContext);
            }
            if (tokenBuffer == null) {
                tokenBuffer = new TokenBuffer((ObjectCodec) null);
            }
            tokenBuffer.writeFieldName(currentName);
            tokenBuffer.copyCurrentStructure(jsonParser);
            currentToken = jsonParser.nextToken();
        }
        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.FIELD_NAME, "missing property '" + this._typePropertyName + "' that is to contain type id  (for class " + baseTypeName() + ")");
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
            return super.deserializeTypedFromArray(jsonParser, deserializationContext);
        }
        return deserializeTypedFromObject(jsonParser, deserializationContext);
    }
}
