package org.codehaus.jackson.map.ser;

import com.lowagie.text.ElementTags;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.util.TokenBuffer;

public class StdSerializers {
    protected StdSerializers() {
    }

    protected static abstract class NonTypedScalarSerializer<T> extends ScalarSerializerBase<T> {
        protected NonTypedScalarSerializer(Class<T> cls) {
            super(cls);
        }

        public final void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            serialize(t, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    public static final class BooleanSerializer extends NonTypedScalarSerializer<Boolean> {
        final boolean _forPrimitive;

        public BooleanSerializer(boolean z) {
            super(Boolean.class);
            this._forPrimitive = z;
        }

        public void serialize(Boolean bool, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeBoolean(bool.booleanValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("boolean", !this._forPrimitive);
        }
    }

    @JacksonStdImpl
    public static final class StringSerializer extends NonTypedScalarSerializer<String> {
        public StringSerializer() {
            super(String.class);
        }

        public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeString(str);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }
    }

    @JacksonStdImpl
    public static final class IntegerSerializer extends NonTypedScalarSerializer<Integer> {
        public IntegerSerializer() {
            super(Integer.class);
        }

        public void serialize(Integer num, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(num.intValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }
    }

    @JacksonStdImpl
    public static final class IntLikeSerializer extends ScalarSerializerBase<Number> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public IntLikeSerializer() {
            super(Number.class);
        }

        public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(number.intValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }
    }

    @JacksonStdImpl
    public static final class LongSerializer extends ScalarSerializerBase<Long> {
        static final LongSerializer instance = new LongSerializer();

        public LongSerializer() {
            super(Long.class);
        }

        public void serialize(Long l, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(l.longValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(ElementTags.NUMBER, true);
        }
    }

    @JacksonStdImpl
    public static final class FloatSerializer extends ScalarSerializerBase<Float> {
        static final FloatSerializer instance = new FloatSerializer();

        public FloatSerializer() {
            super(Float.class);
        }

        public void serialize(Float f, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(f.floatValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(ElementTags.NUMBER, true);
        }
    }

    @JacksonStdImpl
    public static final class DoubleSerializer extends NonTypedScalarSerializer<Double> {
        static final DoubleSerializer instance = new DoubleSerializer();

        public DoubleSerializer() {
            super(Double.class);
        }

        public void serialize(Double d, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(d.doubleValue());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(ElementTags.NUMBER, true);
        }
    }

    @JacksonStdImpl
    public static final class NumberSerializer extends ScalarSerializerBase<Number> {
        public static final NumberSerializer instance = new NumberSerializer();

        public NumberSerializer() {
            super(Number.class);
        }

        public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (number instanceof BigDecimal) {
                jsonGenerator.writeNumber((BigDecimal) number);
            } else if (number instanceof BigInteger) {
                jsonGenerator.writeNumber((BigInteger) number);
            } else if (number instanceof Integer) {
                jsonGenerator.writeNumber(number.intValue());
            } else if (number instanceof Long) {
                jsonGenerator.writeNumber(number.longValue());
            } else if (number instanceof Double) {
                jsonGenerator.writeNumber(number.doubleValue());
            } else if (number instanceof Float) {
                jsonGenerator.writeNumber(number.floatValue());
            } else if ((number instanceof Byte) || (number instanceof Short)) {
                jsonGenerator.writeNumber(number.intValue());
            } else {
                jsonGenerator.writeNumber(number.toString());
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(ElementTags.NUMBER, true);
        }
    }

    @JacksonStdImpl
    public static final class CalendarSerializer extends ScalarSerializerBase<Calendar> {
        public static final CalendarSerializer instance = new CalendarSerializer();

        public CalendarSerializer() {
            super(Calendar.class);
        }

        public void serialize(Calendar calendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            serializerProvider.defaultSerializeDateValue(calendar.getTimeInMillis(), jsonGenerator);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? ElementTags.NUMBER : "string", true);
        }
    }

    @JacksonStdImpl
    public static final class UtilDateSerializer extends ScalarSerializerBase<Date> {
        public static final UtilDateSerializer instance = new UtilDateSerializer();

        public UtilDateSerializer() {
            super(Date.class);
        }

        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            serializerProvider.defaultSerializeDateValue(date, jsonGenerator);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? ElementTags.NUMBER : "string", true);
        }
    }

    @JacksonStdImpl
    public static final class SqlDateSerializer extends ScalarSerializerBase<java.sql.Date> {
        public SqlDateSerializer() {
            super(java.sql.Date.class);
        }

        public void serialize(java.sql.Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeString(date.toString());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }
    }

    @JacksonStdImpl
    public static final class SqlTimeSerializer extends ScalarSerializerBase<Time> {
        public SqlTimeSerializer() {
            super(Time.class);
        }

        public void serialize(Time time, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeString(time.toString());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }
    }

    @JacksonStdImpl
    public static final class SerializableSerializer extends SerializerBase<JsonSerializable> {
        protected static final SerializableSerializer instance = new SerializableSerializer();

        private SerializableSerializer() {
            super(JsonSerializable.class);
        }

        public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonSerializable.serialize(jsonGenerator, serializerProvider);
        }

        public final void serializeWithType(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            if (jsonSerializable instanceof JsonSerializableWithType) {
                ((JsonSerializableWithType) jsonSerializable).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
            } else {
                serialize(jsonSerializable, jsonGenerator, serializerProvider);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.codehaus.jackson.JsonNode getSchema(org.codehaus.jackson.map.SerializerProvider r6, java.lang.reflect.Type r7) throws org.codehaus.jackson.map.JsonMappingException {
            /*
                r5 = this;
                org.codehaus.jackson.node.ObjectNode r6 = r5.createObjectNode()
                r0 = 0
                if (r7 == 0) goto L_0x0044
                org.codehaus.jackson.type.JavaType r7 = org.codehaus.jackson.map.type.TypeFactory.type((java.lang.reflect.Type) r7)
                java.lang.Class r7 = r7.getRawClass()
                java.lang.Class<org.codehaus.jackson.schema.JsonSerializableSchema> r1 = org.codehaus.jackson.schema.JsonSerializableSchema.class
                boolean r1 = r7.isAnnotationPresent(r1)
                if (r1 == 0) goto L_0x0044
                java.lang.Class<org.codehaus.jackson.schema.JsonSerializableSchema> r1 = org.codehaus.jackson.schema.JsonSerializableSchema.class
                java.lang.annotation.Annotation r7 = r7.getAnnotation(r1)
                org.codehaus.jackson.schema.JsonSerializableSchema r7 = (org.codehaus.jackson.schema.JsonSerializableSchema) r7
                java.lang.String r1 = r7.schemaType()
                java.lang.String r2 = r7.schemaObjectPropertiesDefinition()
                java.lang.String r3 = "##irrelevant"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L_0x0034
                java.lang.String r2 = r7.schemaObjectPropertiesDefinition()
                goto L_0x0035
            L_0x0034:
                r2 = r0
            L_0x0035:
                java.lang.String r4 = r7.schemaItemDefinition()
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x0047
                java.lang.String r0 = r7.schemaItemDefinition()
                goto L_0x0047
            L_0x0044:
                java.lang.String r1 = "any"
                r2 = r0
            L_0x0047:
                java.lang.String r7 = "type"
                r6.put((java.lang.String) r7, (java.lang.String) r1)
                if (r2 == 0) goto L_0x0068
                java.lang.String r7 = "properties"
                org.codehaus.jackson.map.ObjectMapper r1 = new org.codehaus.jackson.map.ObjectMapper     // Catch:{ IOException -> 0x0061 }
                r1.<init>()     // Catch:{ IOException -> 0x0061 }
                java.lang.Class<org.codehaus.jackson.JsonNode> r3 = org.codehaus.jackson.JsonNode.class
                java.lang.Object r1 = r1.readValue((java.lang.String) r2, r3)     // Catch:{ IOException -> 0x0061 }
                org.codehaus.jackson.JsonNode r1 = (org.codehaus.jackson.JsonNode) r1     // Catch:{ IOException -> 0x0061 }
                r6.put((java.lang.String) r7, (org.codehaus.jackson.JsonNode) r1)     // Catch:{ IOException -> 0x0061 }
                goto L_0x0068
            L_0x0061:
                r6 = move-exception
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                r7.<init>(r6)
                throw r7
            L_0x0068:
                if (r0 == 0) goto L_0x0084
                java.lang.String r7 = "items"
                org.codehaus.jackson.map.ObjectMapper r1 = new org.codehaus.jackson.map.ObjectMapper     // Catch:{ IOException -> 0x007d }
                r1.<init>()     // Catch:{ IOException -> 0x007d }
                java.lang.Class<org.codehaus.jackson.JsonNode> r2 = org.codehaus.jackson.JsonNode.class
                java.lang.Object r0 = r1.readValue((java.lang.String) r0, r2)     // Catch:{ IOException -> 0x007d }
                org.codehaus.jackson.JsonNode r0 = (org.codehaus.jackson.JsonNode) r0     // Catch:{ IOException -> 0x007d }
                r6.put((java.lang.String) r7, (org.codehaus.jackson.JsonNode) r0)     // Catch:{ IOException -> 0x007d }
                goto L_0x0084
            L_0x007d:
                r6 = move-exception
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                r7.<init>(r6)
                throw r7
            L_0x0084:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ser.StdSerializers.SerializableSerializer.getSchema(org.codehaus.jackson.map.SerializerProvider, java.lang.reflect.Type):org.codehaus.jackson.JsonNode");
        }
    }

    @JacksonStdImpl
    public static final class SerializableWithTypeSerializer extends SerializerBase<JsonSerializableWithType> {
        protected static final SerializableWithTypeSerializer instance = new SerializableWithTypeSerializer();

        private SerializableWithTypeSerializer() {
            super(JsonSerializableWithType.class);
        }

        public void serialize(JsonSerializableWithType jsonSerializableWithType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonSerializableWithType.serialize(jsonGenerator, serializerProvider);
        }

        public final void serializeWithType(JsonSerializableWithType jsonSerializableWithType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            jsonSerializableWithType.serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.codehaus.jackson.JsonNode getSchema(org.codehaus.jackson.map.SerializerProvider r6, java.lang.reflect.Type r7) throws org.codehaus.jackson.map.JsonMappingException {
            /*
                r5 = this;
                org.codehaus.jackson.node.ObjectNode r6 = r5.createObjectNode()
                r0 = 0
                if (r7 == 0) goto L_0x0040
                java.lang.Class r7 = org.codehaus.jackson.map.type.TypeFactory.rawClass(r7)
                java.lang.Class<org.codehaus.jackson.schema.JsonSerializableSchema> r1 = org.codehaus.jackson.schema.JsonSerializableSchema.class
                boolean r1 = r7.isAnnotationPresent(r1)
                if (r1 == 0) goto L_0x0040
                java.lang.Class<org.codehaus.jackson.schema.JsonSerializableSchema> r1 = org.codehaus.jackson.schema.JsonSerializableSchema.class
                java.lang.annotation.Annotation r7 = r7.getAnnotation(r1)
                org.codehaus.jackson.schema.JsonSerializableSchema r7 = (org.codehaus.jackson.schema.JsonSerializableSchema) r7
                java.lang.String r1 = r7.schemaType()
                java.lang.String r2 = r7.schemaObjectPropertiesDefinition()
                java.lang.String r3 = "##irrelevant"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L_0x0030
                java.lang.String r2 = r7.schemaObjectPropertiesDefinition()
                goto L_0x0031
            L_0x0030:
                r2 = r0
            L_0x0031:
                java.lang.String r4 = r7.schemaItemDefinition()
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x0043
                java.lang.String r0 = r7.schemaItemDefinition()
                goto L_0x0043
            L_0x0040:
                java.lang.String r1 = "any"
                r2 = r0
            L_0x0043:
                java.lang.String r7 = "type"
                r6.put((java.lang.String) r7, (java.lang.String) r1)
                if (r2 == 0) goto L_0x0064
                java.lang.String r7 = "properties"
                org.codehaus.jackson.map.ObjectMapper r1 = new org.codehaus.jackson.map.ObjectMapper     // Catch:{ IOException -> 0x005d }
                r1.<init>()     // Catch:{ IOException -> 0x005d }
                java.lang.Class<org.codehaus.jackson.JsonNode> r3 = org.codehaus.jackson.JsonNode.class
                java.lang.Object r1 = r1.readValue((java.lang.String) r2, r3)     // Catch:{ IOException -> 0x005d }
                org.codehaus.jackson.JsonNode r1 = (org.codehaus.jackson.JsonNode) r1     // Catch:{ IOException -> 0x005d }
                r6.put((java.lang.String) r7, (org.codehaus.jackson.JsonNode) r1)     // Catch:{ IOException -> 0x005d }
                goto L_0x0064
            L_0x005d:
                r6 = move-exception
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                r7.<init>(r6)
                throw r7
            L_0x0064:
                if (r0 == 0) goto L_0x0080
                java.lang.String r7 = "items"
                org.codehaus.jackson.map.ObjectMapper r1 = new org.codehaus.jackson.map.ObjectMapper     // Catch:{ IOException -> 0x0079 }
                r1.<init>()     // Catch:{ IOException -> 0x0079 }
                java.lang.Class<org.codehaus.jackson.JsonNode> r2 = org.codehaus.jackson.JsonNode.class
                java.lang.Object r0 = r1.readValue((java.lang.String) r0, r2)     // Catch:{ IOException -> 0x0079 }
                org.codehaus.jackson.JsonNode r0 = (org.codehaus.jackson.JsonNode) r0     // Catch:{ IOException -> 0x0079 }
                r6.put((java.lang.String) r7, (org.codehaus.jackson.JsonNode) r0)     // Catch:{ IOException -> 0x0079 }
                goto L_0x0080
            L_0x0079:
                r6 = move-exception
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                r7.<init>(r6)
                throw r7
            L_0x0080:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ser.StdSerializers.SerializableWithTypeSerializer.getSchema(org.codehaus.jackson.map.SerializerProvider, java.lang.reflect.Type):org.codehaus.jackson.JsonNode");
        }
    }

    @JacksonStdImpl
    public static final class TokenBufferSerializer extends SerializerBase<TokenBuffer> {
        public TokenBufferSerializer() {
            super(TokenBuffer.class);
        }

        public void serialize(TokenBuffer tokenBuffer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            tokenBuffer.serialize(jsonGenerator);
        }

        public final void serializeWithType(TokenBuffer tokenBuffer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            typeSerializer.writeTypePrefixForScalar(tokenBuffer, jsonGenerator);
            serialize(tokenBuffer, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffixForScalar(tokenBuffer, jsonGenerator);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("any", true);
        }
    }
}
