package org.codehaus.jackson.map;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.type.JavaType;

public abstract class SerializerProvider {
    protected static final JavaType TYPE_OBJECT = TypeFactory.defaultInstance().uncheckedSimpleType(Object.class);
    protected final SerializationConfig _config;
    protected final Class<?> _serializationView;

    public abstract int cachedSerializersCount();

    public abstract void defaultSerializeDateValue(long j, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException;

    public abstract void defaultSerializeDateValue(Date date, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException;

    public abstract JsonSerializer<Object> findKeySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException;

    public abstract JsonSerializer<Object> findTypedValueSerializer(Class<?> cls, boolean z, BeanProperty beanProperty) throws JsonMappingException;

    public abstract JsonSerializer<Object> findTypedValueSerializer(JavaType javaType, boolean z, BeanProperty beanProperty) throws JsonMappingException;

    public abstract JsonSerializer<Object> findValueSerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException;

    public abstract JsonSerializer<Object> findValueSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException;

    public abstract void flushCachedSerializers();

    public abstract JsonSchema generateJsonSchema(Class<?> cls, SerializationConfig serializationConfig, SerializerFactory serializerFactory) throws JsonMappingException;

    public abstract JsonSerializer<Object> getNullKeySerializer();

    public abstract JsonSerializer<Object> getNullValueSerializer();

    public abstract JsonSerializer<Object> getUnknownTypeSerializer(Class<?> cls);

    public abstract boolean hasSerializerFor(SerializationConfig serializationConfig, Class<?> cls, SerializerFactory serializerFactory);

    public abstract void serializeValue(SerializationConfig serializationConfig, JsonGenerator jsonGenerator, Object obj, SerializerFactory serializerFactory) throws IOException, JsonGenerationException;

    public abstract void serializeValue(SerializationConfig serializationConfig, JsonGenerator jsonGenerator, Object obj, JavaType javaType, SerializerFactory serializerFactory) throws IOException, JsonGenerationException;

    public abstract void setDefaultKeySerializer(JsonSerializer<Object> jsonSerializer);

    public abstract void setNullKeySerializer(JsonSerializer<Object> jsonSerializer);

    public abstract void setNullValueSerializer(JsonSerializer<Object> jsonSerializer);

    protected SerializerProvider(SerializationConfig serializationConfig) {
        Class<?> cls;
        this._config = serializationConfig;
        if (serializationConfig == null) {
            cls = null;
        } else {
            cls = this._config.getSerializationView();
        }
        this._serializationView = cls;
    }

    public final SerializationConfig getConfig() {
        return this._config;
    }

    public final boolean isEnabled(SerializationConfig.Feature feature) {
        return this._config.isEnabled(feature);
    }

    public final Class<?> getSerializationView() {
        return this._serializationView;
    }

    public final FilterProvider getFilterProvider() {
        return this._config.getFilterProvider();
    }

    public JavaType constructType(Type type) {
        return this._config.getTypeFactory().constructType(type);
    }

    @Deprecated
    public final JsonSerializer<Object> findValueSerializer(Class<?> cls) throws JsonMappingException {
        return findValueSerializer(cls, (BeanProperty) null);
    }

    @Deprecated
    public final JsonSerializer<Object> findValueSerializer(JavaType javaType) throws JsonMappingException {
        return findValueSerializer(javaType, (BeanProperty) null);
    }

    @Deprecated
    public final JsonSerializer<Object> findTypedValueSerializer(Class<?> cls, boolean z) throws JsonMappingException {
        return findTypedValueSerializer(cls, z, (BeanProperty) null);
    }

    @Deprecated
    public final JsonSerializer<Object> findTypedValueSerializer(JavaType javaType, boolean z) throws JsonMappingException {
        return findTypedValueSerializer(javaType, z, (BeanProperty) null);
    }

    @Deprecated
    public final JsonSerializer<Object> getKeySerializer() throws JsonMappingException {
        return findKeySerializer(TYPE_OBJECT, (BeanProperty) null);
    }

    @Deprecated
    public final JsonSerializer<Object> getKeySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return findKeySerializer(javaType, beanProperty);
    }

    public final void defaultSerializeValue(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (obj == null) {
            getNullValueSerializer().serialize(null, jsonGenerator, this);
        } else {
            findTypedValueSerializer(obj.getClass(), true).serialize(obj, jsonGenerator, this);
        }
    }

    public final void defaultSerializeField(String str, Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeFieldName(str);
        if (obj == null) {
            getNullValueSerializer().serialize(null, jsonGenerator, this);
        } else {
            findTypedValueSerializer(obj.getClass(), true).serialize(obj, jsonGenerator, this);
        }
    }

    public final void defaultSerializeNull(JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        getNullValueSerializer().serialize(null, jsonGenerator, this);
    }
}
