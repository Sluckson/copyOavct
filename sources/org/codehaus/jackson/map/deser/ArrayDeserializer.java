package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Array;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class ArrayDeserializer extends ContainerDeserializer<Object[]> {
    protected final JavaType _arrayType;
    protected final Class<?> _elementClass;
    protected final JsonDeserializer<Object> _elementDeserializer;
    final TypeDeserializer _elementTypeDeserializer;
    protected final boolean _untyped;

    @Deprecated
    public ArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> jsonDeserializer) {
        this(arrayType, jsonDeserializer, (TypeDeserializer) null);
    }

    public ArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(Object[].class);
        this._arrayType = arrayType;
        this._elementClass = arrayType.getContentType().getRawClass();
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
    }

    public JavaType getContentType() {
        return this._arrayType.getContentType();
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    public Object[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object[] objArr;
        Object obj;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] resetAndStart = leaseObjectBuffer.resetAndStart();
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        int i = 0;
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                break;
            }
            if (nextToken == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                obj = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
            if (i >= resetAndStart.length) {
                resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                i = 0;
            }
            resetAndStart[i] = obj;
            i++;
        }
        if (this._untyped) {
            objArr = leaseObjectBuffer.completeAndClearBuffer(resetAndStart, i);
        } else {
            objArr = leaseObjectBuffer.completeAndClearBuffer(resetAndStart, i, this._elementClass);
        }
        deserializationContext.returnObjectBuffer(leaseObjectBuffer);
        return objArr;
    }

    public Object[] deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return (Object[]) typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        byte[] binaryValue = jsonParser.getBinaryValue(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[binaryValue.length];
        int length = binaryValue.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(binaryValue[i]);
        }
        return bArr;
    }

    private final Object[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object obj;
        Object[] objArr;
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                obj = null;
            } else {
                TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
                if (typeDeserializer == null) {
                    obj = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    obj = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                }
            }
            if (this._untyped) {
                objArr = new Object[1];
            } else {
                objArr = (Object[]) Array.newInstance(this._elementClass, 1);
            }
            objArr[0] = obj;
            return objArr;
        } else if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING && this._elementClass == Byte.class) {
            return deserializeFromBase64(jsonParser, deserializationContext);
        } else {
            throw deserializationContext.mappingException(this._arrayType.getRawClass());
        }
    }
}
