package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

public class ArrayDeserializers {
    static final ArrayDeserializers instance = new ArrayDeserializers();
    HashMap<JavaType, JsonDeserializer<Object>> _allDeserializers = new HashMap<>();

    private ArrayDeserializers() {
        add(Boolean.TYPE, new BooleanDeser());
        add(Byte.TYPE, new ByteDeser());
        add(Short.TYPE, new ShortDeser());
        add(Integer.TYPE, new IntDeser());
        add(Long.TYPE, new LongDeser());
        add(Float.TYPE, new FloatDeser());
        add(Double.TYPE, new DoubleDeser());
        add(String.class, new StringDeser());
        add(Character.TYPE, new CharDeser());
    }

    public static HashMap<JavaType, JsonDeserializer<Object>> getAll() {
        return instance._allDeserializers;
    }

    private void add(Class<?> cls, JsonDeserializer<?> jsonDeserializer) {
        this._allDeserializers.put(TypeFactory.defaultInstance().constructType((Type) cls), jsonDeserializer);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    static abstract class ArrayDeser<T> extends StdDeserializer<T> {
        protected ArrayDeser(Class<T> cls) {
            super((Class<?>) cls);
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    static final class StringDeser extends ArrayDeser<String[]> {
        public StringDeser() {
            super(String[].class);
        }

        public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            Object[] resetAndStart = leaseObjectBuffer.resetAndStart();
            int i = 0;
            while (true) {
                JsonToken nextToken = jsonParser.nextToken();
                if (nextToken != JsonToken.END_ARRAY) {
                    String text = nextToken == JsonToken.VALUE_NULL ? null : jsonParser.getText();
                    if (i >= resetAndStart.length) {
                        resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                        i = 0;
                    }
                    resetAndStart[i] = text;
                    i++;
                } else {
                    String[] strArr = (String[]) leaseObjectBuffer.completeAndClearBuffer(resetAndStart, i, String.class);
                    deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                    return strArr;
                }
            }
        }

        private final String[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                String[] strArr = new String[1];
                strArr[0] = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : jsonParser.getText();
                return strArr;
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class CharDeser extends ArrayDeser<char[]> {
        public CharDeser() {
            super(char[].class);
        }

        public char[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                char[] textCharacters = jsonParser.getTextCharacters();
                int textOffset = jsonParser.getTextOffset();
                int textLength = jsonParser.getTextLength();
                char[] cArr = new char[textLength];
                System.arraycopy(textCharacters, textOffset, cArr, 0, textLength);
                return cArr;
            } else if (jsonParser.isExpectedStartArrayToken()) {
                StringBuilder sb = new StringBuilder(64);
                while (true) {
                    JsonToken nextToken = jsonParser.nextToken();
                    if (nextToken == JsonToken.END_ARRAY) {
                        return sb.toString().toCharArray();
                    }
                    if (nextToken == JsonToken.VALUE_STRING) {
                        String text = jsonParser.getText();
                        if (text.length() == 1) {
                            sb.append(text.charAt(0));
                        } else {
                            throw JsonMappingException.from(jsonParser, "Can not convert a JSON String of length " + text.length() + " into a char element of char array");
                        }
                    } else {
                        throw deserializationContext.mappingException((Class<?>) Character.TYPE);
                    }
                }
            } else {
                if (currentToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                    Object embeddedObject = jsonParser.getEmbeddedObject();
                    if (embeddedObject == null) {
                        return null;
                    }
                    if (embeddedObject instanceof char[]) {
                        return (char[]) embeddedObject;
                    }
                    if (embeddedObject instanceof String) {
                        return ((String) embeddedObject).toCharArray();
                    }
                    if (embeddedObject instanceof byte[]) {
                        return Base64Variants.getDefaultVariant().encode((byte[]) embeddedObject, false).toCharArray();
                    }
                }
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    static final class BooleanDeser extends ArrayDeser<boolean[]> {
        public BooleanDeser() {
            super(boolean[].class);
        }

        public boolean[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.BooleanBuilder booleanBuilder = deserializationContext.getArrayBuilders().getBooleanBuilder();
            boolean[] zArr = (boolean[]) booleanBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                boolean _parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
                if (i >= zArr.length) {
                    zArr = (boolean[]) booleanBuilder.appendCompletedChunk(zArr, i);
                    i = 0;
                }
                zArr[i] = _parseBooleanPrimitive;
                i++;
            }
            return (boolean[]) booleanBuilder.completeAndClearBuffer(zArr, i);
        }

        private final boolean[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new boolean[]{_parseBooleanPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class ByteDeser extends ArrayDeser<byte[]> {
        public ByteDeser() {
            super(byte[].class);
        }

        public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            byte b;
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                return jsonParser.getBinaryValue(deserializationContext.getBase64Variant());
            }
            if (currentToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object embeddedObject = jsonParser.getEmbeddedObject();
                if (embeddedObject == null) {
                    return null;
                }
                if (embeddedObject instanceof byte[]) {
                    return (byte[]) embeddedObject;
                }
            }
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.ByteBuilder byteBuilder = deserializationContext.getArrayBuilders().getByteBuilder();
            byte[] bArr = (byte[]) byteBuilder.resetAndStart();
            int i = 0;
            while (true) {
                JsonToken nextToken = jsonParser.nextToken();
                if (nextToken == JsonToken.END_ARRAY) {
                    return (byte[]) byteBuilder.completeAndClearBuffer(bArr, i);
                }
                if (nextToken == JsonToken.VALUE_NUMBER_INT || nextToken == JsonToken.VALUE_NUMBER_FLOAT) {
                    b = jsonParser.getByteValue();
                } else if (nextToken == JsonToken.VALUE_NULL) {
                    b = 0;
                } else {
                    throw deserializationContext.mappingException(this._valueClass.getComponentType());
                }
                if (i >= bArr.length) {
                    bArr = (byte[]) byteBuilder.appendCompletedChunk(bArr, i);
                    i = 0;
                }
                bArr[i] = b;
                i++;
            }
        }

        private final byte[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            byte b;
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                JsonToken currentToken = jsonParser.getCurrentToken();
                if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                    b = jsonParser.getByteValue();
                } else if (currentToken == JsonToken.VALUE_NULL) {
                    b = 0;
                } else {
                    throw deserializationContext.mappingException(this._valueClass.getComponentType());
                }
                return new byte[]{b};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class ShortDeser extends ArrayDeser<short[]> {
        public ShortDeser() {
            super(short[].class);
        }

        public short[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.ShortBuilder shortBuilder = deserializationContext.getArrayBuilders().getShortBuilder();
            short[] sArr = (short[]) shortBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                short _parseShortPrimitive = _parseShortPrimitive(jsonParser, deserializationContext);
                if (i >= sArr.length) {
                    sArr = (short[]) shortBuilder.appendCompletedChunk(sArr, i);
                    i = 0;
                }
                sArr[i] = _parseShortPrimitive;
                i++;
            }
            return (short[]) shortBuilder.completeAndClearBuffer(sArr, i);
        }

        private final short[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new short[]{_parseShortPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class IntDeser extends ArrayDeser<int[]> {
        public IntDeser() {
            super(int[].class);
        }

        public int[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.IntBuilder intBuilder = deserializationContext.getArrayBuilders().getIntBuilder();
            int[] iArr = (int[]) intBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
                if (i >= iArr.length) {
                    iArr = (int[]) intBuilder.appendCompletedChunk(iArr, i);
                    i = 0;
                }
                iArr[i] = _parseIntPrimitive;
                i++;
            }
            return (int[]) intBuilder.completeAndClearBuffer(iArr, i);
        }

        private final int[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new int[]{_parseIntPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class LongDeser extends ArrayDeser<long[]> {
        public LongDeser() {
            super(long[].class);
        }

        public long[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.LongBuilder longBuilder = deserializationContext.getArrayBuilders().getLongBuilder();
            long[] jArr = (long[]) longBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                long _parseLongPrimitive = _parseLongPrimitive(jsonParser, deserializationContext);
                if (i >= jArr.length) {
                    jArr = (long[]) longBuilder.appendCompletedChunk(jArr, i);
                    i = 0;
                }
                jArr[i] = _parseLongPrimitive;
                i++;
            }
            return (long[]) longBuilder.completeAndClearBuffer(jArr, i);
        }

        private final long[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new long[]{_parseLongPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class FloatDeser extends ArrayDeser<float[]> {
        public FloatDeser() {
            super(float[].class);
        }

        public float[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.FloatBuilder floatBuilder = deserializationContext.getArrayBuilders().getFloatBuilder();
            float[] fArr = (float[]) floatBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                float _parseFloatPrimitive = _parseFloatPrimitive(jsonParser, deserializationContext);
                if (i >= fArr.length) {
                    fArr = (float[]) floatBuilder.appendCompletedChunk(fArr, i);
                    i = 0;
                }
                fArr[i] = _parseFloatPrimitive;
                i++;
            }
            return (float[]) floatBuilder.completeAndClearBuffer(fArr, i);
        }

        private final float[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new float[]{_parseFloatPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    static final class DoubleDeser extends ArrayDeser<double[]> {
        public DoubleDeser() {
            super(double[].class);
        }

        public double[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.isExpectedStartArrayToken()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            ArrayBuilders.DoubleBuilder doubleBuilder = deserializationContext.getArrayBuilders().getDoubleBuilder();
            double[] dArr = (double[]) doubleBuilder.resetAndStart();
            int i = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                double _parseDoublePrimitive = _parseDoublePrimitive(jsonParser, deserializationContext);
                if (i >= dArr.length) {
                    dArr = (double[]) doubleBuilder.appendCompletedChunk(dArr, i);
                    i = 0;
                }
                dArr[i] = _parseDoublePrimitive;
                i++;
            }
            return (double[]) doubleBuilder.completeAndClearBuffer(dArr, i);
        }

        private final double[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new double[]{_parseDoublePrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }
}
