package org.codehaus.jackson.map.deser;

import com.lowagie.text.pdf.PdfBoolean;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.p063io.NumberInput;

public abstract class StdKeyDeserializer extends KeyDeserializer {
    protected final Class<?> _keyClass;

    /* access modifiers changed from: protected */
    public abstract Object _parse(String str, DeserializationContext deserializationContext) throws Exception;

    protected StdKeyDeserializer(Class<?> cls) {
        this._keyClass = cls;
    }

    public final Object deserializeKey(String str, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (str == null) {
            return null;
        }
        try {
            Object _parse = _parse(str, deserializationContext);
            if (_parse != null) {
                return _parse;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation");
        } catch (Exception e) {
            Class<?> cls = this._keyClass;
            throw deserializationContext.weirdKeyException(cls, str, "not a valid representation: " + e.getMessage());
        }
    }

    public Class<?> getKeyClass() {
        return this._keyClass;
    }

    /* access modifiers changed from: protected */
    public int _parseInt(String str) throws IllegalArgumentException {
        return Integer.parseInt(str);
    }

    /* access modifiers changed from: protected */
    public long _parseLong(String str) throws IllegalArgumentException {
        return Long.parseLong(str);
    }

    /* access modifiers changed from: protected */
    public double _parseDouble(String str) throws IllegalArgumentException {
        return NumberInput.parseDouble(str);
    }

    static final class BoolKD extends StdKeyDeserializer {
        BoolKD() {
            super(Boolean.class);
        }

        public Boolean _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if (PdfBoolean.FALSE.equals(str)) {
                return Boolean.FALSE;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "value not 'true' or 'false'");
        }
    }

    static final class ByteKD extends StdKeyDeserializer {
        ByteKD() {
            super(Byte.class);
        }

        public Byte _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            int _parseInt = _parseInt(str);
            if (_parseInt >= -128 && _parseInt <= 127) {
                return Byte.valueOf((byte) _parseInt);
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 8-bit value");
        }
    }

    static final class ShortKD extends StdKeyDeserializer {
        ShortKD() {
            super(Integer.class);
        }

        public Short _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            int _parseInt = _parseInt(str);
            if (_parseInt >= -32768 && _parseInt <= 32767) {
                return Short.valueOf((short) _parseInt);
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 16-bit value");
        }
    }

    static final class CharKD extends StdKeyDeserializer {
        CharKD() {
            super(Character.class);
        }

        public Character _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "can only convert 1-character Strings");
        }
    }

    static final class IntKD extends StdKeyDeserializer {
        IntKD() {
            super(Integer.class);
        }

        public Integer _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            return Integer.valueOf(_parseInt(str));
        }
    }

    static final class LongKD extends StdKeyDeserializer {
        LongKD() {
            super(Long.class);
        }

        public Long _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            return Long.valueOf(_parseLong(str));
        }
    }

    static final class DoubleKD extends StdKeyDeserializer {
        DoubleKD() {
            super(Double.class);
        }

        public Double _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            return Double.valueOf(_parseDouble(str));
        }
    }

    static final class FloatKD extends StdKeyDeserializer {
        FloatKD() {
            super(Float.class);
        }

        public Float _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            return Float.valueOf((float) _parseDouble(str));
        }
    }

    static final class EnumKD extends StdKeyDeserializer {
        final EnumResolver<?> _resolver;

        EnumKD(EnumResolver<?> enumResolver) {
            super(enumResolver.getEnumClass());
            this._resolver = enumResolver;
        }

        public Enum<?> _parse(String str, DeserializationContext deserializationContext) throws JsonMappingException {
            Enum<?> findEnum = this._resolver.findEnum(str);
            if (findEnum != null) {
                return findEnum;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not one of values for Enum class");
        }
    }

    static final class StringCtorKeyDeserializer extends StdKeyDeserializer {
        final Constructor<?> _ctor;

        public StringCtorKeyDeserializer(Constructor<?> constructor) {
            super(constructor.getDeclaringClass());
            this._ctor = constructor;
        }

        public Object _parse(String str, DeserializationContext deserializationContext) throws Exception {
            return this._ctor.newInstance(new Object[]{str});
        }
    }

    static final class StringFactoryKeyDeserializer extends StdKeyDeserializer {
        final Method _factoryMethod;

        public StringFactoryKeyDeserializer(Method method) {
            super(method.getDeclaringClass());
            this._factoryMethod = method;
        }

        public Object _parse(String str, DeserializationContext deserializationContext) throws Exception {
            return this._factoryMethod.invoke((Object) null, new Object[]{str});
        }
    }
}
