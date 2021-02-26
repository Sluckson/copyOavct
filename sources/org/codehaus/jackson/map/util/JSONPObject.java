package org.codehaus.jackson.map.util;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

public class JSONPObject implements JsonSerializableWithType {
    protected final String _function;
    protected final JavaType _serializationType;
    protected final Object _value;

    public JSONPObject(String str, Object obj) {
        this(str, obj, (JavaType) null);
    }

    public JSONPObject(String str, Object obj, JavaType javaType) {
        this._function = str;
        this._value = obj;
        this._serializationType = javaType;
    }

    @Deprecated
    public JSONPObject(String str, Object obj, Class<?> cls) {
        JavaType javaType;
        this._function = str;
        this._value = obj;
        if (cls == null) {
            javaType = null;
        } else {
            javaType = TypeFactory.defaultInstance().constructType((Type) cls);
        }
        this._serializationType = javaType;
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        serialize(jsonGenerator, serializerProvider);
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeRaw(this._function);
        jsonGenerator.writeRaw('(');
        Object obj = this._value;
        if (obj == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
        } else {
            JavaType javaType = this._serializationType;
            if (javaType != null) {
                serializerProvider.findTypedValueSerializer(javaType, true, (BeanProperty) null).serialize(this._value, jsonGenerator, serializerProvider);
            } else {
                serializerProvider.findTypedValueSerializer(obj.getClass(), true, (BeanProperty) null).serialize(this._value, jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeRaw(')');
    }

    public String getFunction() {
        return this._function;
    }

    public Object getValue() {
        return this._value;
    }

    public JavaType getSerializationType() {
        return this._serializationType;
    }
}
