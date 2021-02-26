package org.codehaus.jackson.map.deser;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lowagie.text.pdf.PdfBoolean;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.p063io.NumberInput;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

public abstract class StdDeserializer<T> extends JsonDeserializer<T> {
    protected final Class<?> _valueClass;

    public JavaType getValueType() {
        return null;
    }

    protected StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    protected StdDeserializer(JavaType javaType) {
        Class<?> cls;
        if (javaType == null) {
            cls = null;
        } else {
            cls = javaType.getRawClass();
        }
        this._valueClass = cls;
    }

    public Class<?> getValueClass() {
        return this._valueClass;
    }

    /* access modifiers changed from: protected */
    public boolean isDefaultSerializer(JsonDeserializer<?> jsonDeserializer) {
        return (jsonDeserializer == null || jsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) == null) ? false : true;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (currentToken == JsonToken.VALUE_FALSE || currentToken == JsonToken.VALUE_NULL) {
            return false;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.getIntValue() != 0) {
                return true;
            }
            return false;
        } else if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if ("true".equals(trim)) {
                return true;
            }
            if (PdfBoolean.FALSE.equals(trim) || trim.length() == 0) {
                return Boolean.FALSE.booleanValue();
            }
            throw deserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final Boolean _parseBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (currentToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            return jsonParser.getIntValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if ("true".equals(trim)) {
                return Boolean.TRUE;
            }
            if (PdfBoolean.FALSE.equals(trim) || trim.length() == 0) {
                return Boolean.FALSE;
            }
            throw deserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
        }
        throw deserializationContext.mappingException(this._valueClass);
    }

    /* access modifiers changed from: protected */
    public final Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Short.valueOf(jsonParser.getShortValue());
        }
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_parseIntPrimitive >= -32768 && _parseIntPrimitive <= 32767) {
            return Short.valueOf((short) _parseIntPrimitive);
        }
        throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }

    /* access modifiers changed from: protected */
    public final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_parseIntPrimitive >= -32768 && _parseIntPrimitive <= 32767) {
            return (short) _parseIntPrimitive;
        }
        throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }

    /* access modifiers changed from: protected */
    public final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getIntValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return (int) parseLong;
                    }
                    Class<?> cls = this._valueClass;
                    throw deserializationContext.weirdStringException(cls, "Overflow: numeric value (" + trim + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                } else if (length == 0) {
                    return 0;
                } else {
                    return NumberInput.parseInt(trim);
                }
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid int value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final Integer _parseInteger(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Integer.valueOf(jsonParser.getIntValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return Integer.valueOf((int) parseLong);
                    }
                    Class<?> cls = this._valueClass;
                    throw deserializationContext.weirdStringException(cls, "Overflow: numeric value (" + trim + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                } else if (length == 0) {
                    return null;
                } else {
                    return Integer.valueOf(NumberInput.parseInt(trim));
                }
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid Integer value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final Long _parseLong(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Long.valueOf(jsonParser.getLongValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return Long.valueOf(NumberInput.parseLong(trim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid Long value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getLongValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return 0;
            }
            try {
                return NumberInput.parseLong(trim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid long value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.getFloatValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Float.valueOf(Float.NaN);
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid Float value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getFloatValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return 0.0f;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Float.NaN;
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.POSITIVE_INFINITY;
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                return Float.parseFloat(trim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid float value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return 0.0f;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.getDoubleValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Double.valueOf(Double.NaN);
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            try {
                return Double.valueOf(parseDouble(trim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid Double value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getDoubleValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Double.NaN;
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.POSITIVE_INFINITY;
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                return parseDouble(trim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid double value");
            }
        } else if (currentToken == JsonToken.VALUE_NULL) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        try {
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return new Date(jsonParser.getLongValue());
            }
            if (currentToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return null;
                }
                return deserializationContext.parseDate(trim);
            }
            throw deserializationContext.mappingException(this._valueClass);
        } catch (IllegalArgumentException e) {
            Class<?> cls = this._valueClass;
            throw deserializationContext.weirdStringException(cls, "not a valid representation (error: " + e.getMessage() + ")");
        }
    }

    protected static final double parseDouble(String str) throws NumberFormatException {
        if (NumberInput.NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(str);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return deserializerProvider.findValueDeserializer(deserializationConfig, javaType, beanProperty);
    }

    /* access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        if (obj == null) {
            obj = getValueClass();
        }
        if (!deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            reportUnknownProperty(deserializationContext, obj, str);
            jsonParser.skipChildren();
        }
    }

    /* access modifiers changed from: protected */
    public void reportUnknownProperty(DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw deserializationContext.unknownFieldException(obj, str);
        }
    }

    protected static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        final T _nullValue;

        protected PrimitiveOrWrapperDeserializer(Class<T> cls, T t) {
            super(cls);
            this._nullValue = t;
        }

        public final T getNullValue() {
            return this._nullValue;
        }
    }

    @JacksonStdImpl
    public static final class StringDeserializer extends StdScalarDeserializer<String> {
        public StringDeserializer() {
            super(String.class);
        }

        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                return jsonParser.getText();
            }
            if (currentToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object embeddedObject = jsonParser.getEmbeddedObject();
                if (embeddedObject == null) {
                    return null;
                }
                if (embeddedObject instanceof byte[]) {
                    return Base64Variants.getDefaultVariant().encode((byte[]) embeddedObject, false);
                }
                return embeddedObject.toString();
            } else if (currentToken.isScalarValue()) {
                return jsonParser.getText();
            } else {
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }

        public String deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            return deserialize(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class ClassDeserializer extends StdScalarDeserializer<Class<?>> {
        public ClassDeserializer() {
            super(Class.class);
        }

        public Class<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                if (text.indexOf(46) < 0) {
                    if ("int".equals(text)) {
                        return Integer.TYPE;
                    }
                    if ("long".equals(text)) {
                        return Long.TYPE;
                    }
                    if ("float".equals(text)) {
                        return Float.TYPE;
                    }
                    if ("double".equals(text)) {
                        return Double.TYPE;
                    }
                    if ("boolean".equals(text)) {
                        return Boolean.TYPE;
                    }
                    if ("byte".equals(text)) {
                        return Byte.TYPE;
                    }
                    if ("char".equals(text)) {
                        return Character.TYPE;
                    }
                    if ("short".equals(text)) {
                        return Short.TYPE;
                    }
                    if ("void".equals(text)) {
                        return Void.TYPE;
                    }
                }
                try {
                    return Class.forName(jsonParser.getText());
                } catch (ClassNotFoundException e) {
                    throw deserializationContext.instantiationException((Class<?>) this._valueClass, (Throwable) e);
                }
            } else {
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, bool);
        }

        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseBoolean(jsonParser, deserializationContext);
        }

        public Boolean deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            return _parseBoolean(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        public ByteDeserializer(Class<Byte> cls, Byte b) {
            super(cls, b);
        }

        public Byte deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
            if (_parseIntPrimitive >= -128 && _parseIntPrimitive <= 127) {
                return Byte.valueOf((byte) _parseIntPrimitive);
            }
            throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 8-bit value");
        }
    }

    @JacksonStdImpl
    public static final class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, sh);
        }

        public Short deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseShort(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, ch);
        }

        public Character deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                int intValue = jsonParser.getIntValue();
                if (intValue >= 0 && intValue <= 65535) {
                    return Character.valueOf((char) intValue);
                }
            } else if (currentToken == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                if (text.length() == 1) {
                    return Character.valueOf(text.charAt(0));
                }
            }
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    @JacksonStdImpl
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, num);
        }

        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseInteger(jsonParser, deserializationContext);
        }

        public Integer deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            return _parseInteger(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        public LongDeserializer(Class<Long> cls, Long l) {
            super(cls, l);
        }

        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseLong(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        public FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, f);
        }

        public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseFloat(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        public DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, d);
        }

        public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseDouble(jsonParser, deserializationContext);
        }

        public Double deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            return _parseDouble(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    public static final class NumberDeserializer extends StdScalarDeserializer<Number> {
        public NumberDeserializer() {
            super(Number.class);
        }

        public Number deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.getBigIntegerValue();
                }
                return jsonParser.getNumberValue();
            } else if (currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.getDecimalValue();
                }
                return Double.valueOf(jsonParser.getDoubleValue());
            } else if (currentToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                try {
                    if (trim.indexOf(46) >= 0) {
                        if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return new BigDecimal(trim);
                        }
                        return new Double(trim);
                    } else if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
                        return new BigInteger(trim);
                    } else {
                        long parseLong = Long.parseLong(trim);
                        if (parseLong > 2147483647L || parseLong < -2147483648L) {
                            return Long.valueOf(parseLong);
                        }
                        return Integer.valueOf((int) parseLong);
                    }
                } catch (IllegalArgumentException unused) {
                    throw deserializationContext.weirdStringException(this._valueClass, "not a valid number");
                }
            } else {
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            int i = C49161.$SwitchMap$org$codehaus$jackson$JsonToken[jsonParser.getCurrentToken().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return deserialize(jsonParser, deserializationContext);
            }
            return typeDeserializer.deserializeTypedFromScalar(jsonParser, deserializationContext);
        }
    }

    public static final class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
        public AtomicBooleanDeserializer() {
            super(AtomicBoolean.class);
        }

        public AtomicBoolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return new AtomicBoolean(_parseBooleanPrimitive(jsonParser, deserializationContext));
        }
    }

    public static class AtomicReferenceDeserializer extends StdScalarDeserializer<AtomicReference<?>> implements ResolvableDeserializer {
        protected final BeanProperty _property;
        protected final JavaType _referencedType;
        protected JsonDeserializer<?> _valueDeserializer;

        public AtomicReferenceDeserializer(JavaType javaType, BeanProperty beanProperty) {
            super(AtomicReference.class);
            this._referencedType = javaType;
            this._property = beanProperty;
        }

        public AtomicReference<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return new AtomicReference<>(this._valueDeserializer.deserialize(jsonParser, deserializationContext));
        }

        public void resolve(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider) throws JsonMappingException {
            this._valueDeserializer = deserializerProvider.findValueDeserializer(deserializationConfig, this._referencedType, this._property);
        }
    }

    @JacksonStdImpl
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.getDecimalValue();
            }
            if (currentToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return null;
                }
                try {
                    return new BigDecimal(trim);
                } catch (IllegalArgumentException unused) {
                    throw deserializationContext.weirdStringException(this._valueClass, "not a valid representation");
                }
            } else {
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                int i = C49161.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
                if (i == 1 || i == 2) {
                    return BigInteger.valueOf(jsonParser.getLongValue());
                }
            } else if (currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.getDecimalValue().toBigInteger();
            } else {
                if (currentToken != JsonToken.VALUE_STRING) {
                    throw deserializationContext.mappingException((Class<?>) this._valueClass);
                }
            }
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid representation");
            }
        }
    }

    /* renamed from: org.codehaus.jackson.map.deser.StdDeserializer$1 */
    static /* synthetic */ class C49161 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = new int[JsonParser.NumberType.values().length];
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|5|6|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        static {
            /*
                org.codehaus.jackson.JsonParser$NumberType[] r0 = org.codehaus.jackson.JsonParser.NumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = r0
                r0 = 1
                int[] r1 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonParser$NumberType r2 = org.codehaus.jackson.JsonParser.NumberType.INT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonParser$NumberType r3 = org.codehaus.jackson.JsonParser.NumberType.LONG     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                org.codehaus.jackson.JsonToken[] r2 = org.codehaus.jackson.JsonToken.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$codehaus$jackson$JsonToken = r2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0032 }
                org.codehaus.jackson.JsonToken r3 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x003c }
                org.codehaus.jackson.JsonToken r2 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0047 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.deser.StdDeserializer.C49161.<clinit>():void");
        }
    }

    @JacksonStdImpl
    public static class CalendarDeserializer extends StdScalarDeserializer<Calendar> {
        Class<? extends Calendar> _calendarClass;

        public CalendarDeserializer() {
            this((Class<? extends Calendar>) null);
        }

        public CalendarDeserializer(Class<? extends Calendar> cls) {
            super(Calendar.class);
            this._calendarClass = cls;
        }

        public Calendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            Class<? extends Calendar> cls = this._calendarClass;
            if (cls == null) {
                return deserializationContext.constructCalendar(_parseDate);
            }
            try {
                Calendar calendar = (Calendar) cls.newInstance();
                calendar.setTimeInMillis(_parseDate.getTime());
                return calendar;
            } catch (Exception e) {
                throw deserializationContext.instantiationException((Class<?>) this._calendarClass, (Throwable) e);
            }
        }
    }

    public static class SqlDateDeserializer extends StdScalarDeserializer<java.sql.Date> {
        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        public java.sql.Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            return new java.sql.Date(_parseDate.getTime());
        }
    }

    public static class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
        public StackTraceElementDeserializer() {
            super(StackTraceElement.class);
        }

        public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                String str = "";
                String str2 = str;
                String str3 = str2;
                int i = -1;
                while (true) {
                    JsonToken nextValue = jsonParser.nextValue();
                    if (nextValue == JsonToken.END_OBJECT) {
                        return new StackTraceElement(str, str2, str3, i);
                    }
                    String currentName = jsonParser.getCurrentName();
                    if ("className".equals(currentName)) {
                        str = jsonParser.getText();
                    } else if ("fileName".equals(currentName)) {
                        str3 = jsonParser.getText();
                    } else if ("lineNumber".equals(currentName)) {
                        if (nextValue.isNumeric()) {
                            i = jsonParser.getIntValue();
                        } else {
                            throw JsonMappingException.from(jsonParser, "Non-numeric token (" + nextValue + ") for property 'lineNumber'");
                        }
                    } else if ("methodName".equals(currentName)) {
                        str2 = jsonParser.getText();
                    } else if (!"nativeMethod".equals(currentName)) {
                        handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, currentName);
                    }
                }
            } else {
                throw deserializationContext.mappingException((Class<?>) this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    public static class TokenBufferDeserializer extends StdScalarDeserializer<TokenBuffer> {
        public TokenBufferDeserializer() {
            super(TokenBuffer.class);
        }

        public TokenBuffer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.getCodec());
            tokenBuffer.copyCurrentStructure(jsonParser);
            return tokenBuffer;
        }
    }
}
