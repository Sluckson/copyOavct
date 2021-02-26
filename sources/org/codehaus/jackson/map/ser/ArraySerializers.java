package org.codehaus.jackson.map.ser;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.lowagie.text.ElementTags;
import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.node.ObjectNode;

public final class ArraySerializers {
    private ArraySerializers() {
    }

    public static abstract class AsArraySerializer<T> extends ContainerSerializerBase<T> {
        protected final BeanProperty _property;
        protected final TypeSerializer _valueTypeSerializer;

        /* access modifiers changed from: protected */
        public abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException;

        protected AsArraySerializer(Class<T> cls, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            super(cls);
            this._valueTypeSerializer = typeSerializer;
            this._property = beanProperty;
        }

        public final void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeStartArray();
            serializeContents(t, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
        }

        public final void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            typeSerializer.writeTypePrefixForArray(t, jsonGenerator);
            serializeContents(t, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffixForArray(t, jsonGenerator);
        }
    }

    @JacksonStdImpl
    public static final class StringArraySerializer extends AsArraySerializer<String[]> implements ResolvableSerializer {
        protected JsonSerializer<Object> _elementSerializer;

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        public StringArraySerializer(BeanProperty beanProperty) {
            super(String[].class, (TypeSerializer) null, beanProperty);
        }

        public void serializeContents(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            int length = strArr.length;
            if (length != 0) {
                JsonSerializer<Object> jsonSerializer = this._elementSerializer;
                if (jsonSerializer != null) {
                    serializeContentsSlow(strArr, jsonGenerator, serializerProvider, jsonSerializer);
                    return;
                }
                for (int i = 0; i < length; i++) {
                    if (strArr[i] == null) {
                        jsonGenerator.writeNull();
                    } else {
                        jsonGenerator.writeString(strArr[i]);
                    }
                }
            }
        }

        private void serializeContentsSlow(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException, JsonGenerationException {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (strArr[i] == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonSerializer.serialize(strArr[i], jsonGenerator, serializerProvider);
                }
            }
        }

        public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
            JsonSerializer<Object> findValueSerializer = serializerProvider.findValueSerializer((Class<?>) String.class, this._property);
            if (findValueSerializer != null && findValueSerializer.getClass().getAnnotation(JacksonStdImpl.class) == null) {
                this._elementSerializer = findValueSerializer;
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode("string"));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class BooleanArraySerializer extends AsArraySerializer<boolean[]> {
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        public BooleanArraySerializer() {
            super(boolean[].class, (TypeSerializer) null, (BeanProperty) null);
        }

        public void serializeContents(boolean[] zArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (boolean writeBoolean : zArr) {
                jsonGenerator.writeBoolean(writeBoolean);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode("boolean"));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class ByteArraySerializer extends SerializerBase<byte[]> {
        public ByteArraySerializer() {
            super(byte[].class);
        }

        public void serialize(byte[] bArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeBinary(bArr);
        }

        public void serializeWithType(byte[] bArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            typeSerializer.writeTypePrefixForScalar(bArr, jsonGenerator);
            jsonGenerator.writeBinary(bArr);
            typeSerializer.writeTypeSuffixForScalar(bArr, jsonGenerator);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode("string"));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class ShortArraySerializer extends AsArraySerializer<short[]> {
        public ShortArraySerializer() {
            this((TypeSerializer) null);
        }

        public ShortArraySerializer(TypeSerializer typeSerializer) {
            super(short[].class, typeSerializer, (BeanProperty) null);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new ShortArraySerializer(typeSerializer);
        }

        public void serializeContents(short[] sArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (short writeNumber : sArr) {
                jsonGenerator.writeNumber((int) writeNumber);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode("integer"));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class CharArraySerializer extends SerializerBase<char[]> {
        public CharArraySerializer() {
            super(char[].class);
        }

        public void serialize(char[] cArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.writeStartArray();
                _writeArrayContents(jsonGenerator, cArr);
                jsonGenerator.writeEndArray();
                return;
            }
            jsonGenerator.writeString(cArr, 0, cArr.length);
        }

        public void serializeWithType(char[] cArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                typeSerializer.writeTypePrefixForArray(cArr, jsonGenerator);
                _writeArrayContents(jsonGenerator, cArr);
                typeSerializer.writeTypeSuffixForArray(cArr, jsonGenerator);
                return;
            }
            typeSerializer.writeTypePrefixForScalar(cArr, jsonGenerator);
            jsonGenerator.writeString(cArr, 0, cArr.length);
            typeSerializer.writeTypeSuffixForScalar(cArr, jsonGenerator);
        }

        private final void _writeArrayContents(JsonGenerator jsonGenerator, char[] cArr) throws IOException, JsonGenerationException {
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.writeString(cArr, i, 1);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            ObjectNode createSchemaNode2 = createSchemaNode("string");
            createSchemaNode2.put("type", "string");
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode2);
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class IntArraySerializer extends AsArraySerializer<int[]> {
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        public IntArraySerializer() {
            super(int[].class, (TypeSerializer) null, (BeanProperty) null);
        }

        public void serializeContents(int[] iArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (int writeNumber : iArr) {
                jsonGenerator.writeNumber(writeNumber);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode("integer"));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class LongArraySerializer extends AsArraySerializer<long[]> {
        public LongArraySerializer() {
            this((TypeSerializer) null);
        }

        public LongArraySerializer(TypeSerializer typeSerializer) {
            super(long[].class, typeSerializer, (BeanProperty) null);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new LongArraySerializer(typeSerializer);
        }

        public void serializeContents(long[] jArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (long writeNumber : jArr) {
                jsonGenerator.writeNumber(writeNumber);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode(ElementTags.NUMBER, true));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class FloatArraySerializer extends AsArraySerializer<float[]> {
        public FloatArraySerializer() {
            this((TypeSerializer) null);
        }

        public FloatArraySerializer(TypeSerializer typeSerializer) {
            super(float[].class, typeSerializer, (BeanProperty) null);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new FloatArraySerializer(typeSerializer);
        }

        public void serializeContents(float[] fArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (float writeNumber : fArr) {
                jsonGenerator.writeNumber(writeNumber);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode(ElementTags.NUMBER));
            return createSchemaNode;
        }
    }

    @JacksonStdImpl
    public static final class DoubleArraySerializer extends AsArraySerializer<double[]> {
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        public DoubleArraySerializer() {
            super(double[].class, (TypeSerializer) null, (BeanProperty) null);
        }

        public void serializeContents(double[] dArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            for (double writeNumber : dArr) {
                jsonGenerator.writeNumber(writeNumber);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, (JsonNode) createSchemaNode(ElementTags.NUMBER));
            return createSchemaNode;
        }
    }
}
