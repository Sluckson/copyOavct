package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualSerializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.ser.impl.ReadOnlyClassToSerializerMap;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.RootNameLookup;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public class StdSerializerProvider extends SerializerProvider {
    static final boolean CACHE_UNKNOWN_MAPPINGS = false;
    public static final JsonSerializer<Object> DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
    public static final JsonSerializer<Object> DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final JsonSerializer<Object> DEFAULT_UNKNOWN_SERIALIZER = new SerializerBase<Object>(Object.class) {
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
            return null;
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonMappingException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS)) {
                failForEmpty(obj);
            }
            jsonGenerator.writeStartObject();
            jsonGenerator.writeEndObject();
        }

        public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS)) {
                failForEmpty(obj);
            }
            typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
            typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
        }

        /* access modifiers changed from: protected */
        public void failForEmpty(Object obj) throws JsonMappingException {
            throw new JsonMappingException("No serializer found for class " + obj.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )");
        }
    };
    protected DateFormat _dateFormat;
    protected JsonSerializer<Object> _keySerializer;
    protected final ReadOnlyClassToSerializerMap _knownSerializers;
    protected JsonSerializer<Object> _nullKeySerializer;
    protected JsonSerializer<Object> _nullValueSerializer;
    protected final RootNameLookup _rootNames;
    protected final SerializerCache _serializerCache;
    protected final SerializerFactory _serializerFactory;
    protected JsonSerializer<Object> _unknownTypeSerializer;

    public StdSerializerProvider() {
        super((SerializationConfig) null);
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._keySerializer = DEFAULT_KEY_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._serializerFactory = null;
        this._serializerCache = new SerializerCache();
        this._knownSerializers = null;
        this._rootNames = new RootNameLookup();
    }

    protected StdSerializerProvider(SerializationConfig serializationConfig, StdSerializerProvider stdSerializerProvider, SerializerFactory serializerFactory) {
        super(serializationConfig);
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._keySerializer = DEFAULT_KEY_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        if (serializationConfig != null) {
            this._serializerFactory = serializerFactory;
            this._serializerCache = stdSerializerProvider._serializerCache;
            this._unknownTypeSerializer = stdSerializerProvider._unknownTypeSerializer;
            this._keySerializer = stdSerializerProvider._keySerializer;
            this._nullValueSerializer = stdSerializerProvider._nullValueSerializer;
            this._nullKeySerializer = stdSerializerProvider._nullKeySerializer;
            this._rootNames = stdSerializerProvider._rootNames;
            this._knownSerializers = this._serializerCache.getReadOnlyLookupMap();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public StdSerializerProvider createInstance(SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        return new StdSerializerProvider(serializationConfig, this, serializerFactory);
    }

    public void setDefaultKeySerializer(JsonSerializer<Object> jsonSerializer) {
        if (jsonSerializer != null) {
            this._keySerializer = jsonSerializer;
            return;
        }
        throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }

    public void setNullValueSerializer(JsonSerializer<Object> jsonSerializer) {
        if (jsonSerializer != null) {
            this._nullValueSerializer = jsonSerializer;
            return;
        }
        throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }

    public void setNullKeySerializer(JsonSerializer<Object> jsonSerializer) {
        if (jsonSerializer != null) {
            this._nullKeySerializer = jsonSerializer;
            return;
        }
        throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }

    public final void serializeValue(SerializationConfig serializationConfig, JsonGenerator jsonGenerator, Object obj, SerializerFactory serializerFactory) throws IOException, JsonGenerationException {
        if (serializerFactory != null) {
            StdSerializerProvider createInstance = createInstance(serializationConfig, serializerFactory);
            if (createInstance.getClass() == getClass()) {
                createInstance._serializeValue(jsonGenerator, obj);
                return;
            }
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + createInstance.getClass() + "; blueprint of type " + getClass());
        }
        throw new IllegalArgumentException("Can not pass null serializerFactory");
    }

    public final void serializeValue(SerializationConfig serializationConfig, JsonGenerator jsonGenerator, Object obj, JavaType javaType, SerializerFactory serializerFactory) throws IOException, JsonGenerationException {
        if (serializerFactory != null) {
            StdSerializerProvider createInstance = createInstance(serializationConfig, serializerFactory);
            if (createInstance.getClass() == getClass()) {
                createInstance._serializeValue(jsonGenerator, obj, javaType);
                return;
            }
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + createInstance.getClass() + "; blueprint of type " + getClass());
        }
        throw new IllegalArgumentException("Can not pass null serializerFactory");
    }

    public JsonSchema generateJsonSchema(Class<?> cls, SerializationConfig serializationConfig, SerializerFactory serializerFactory) throws JsonMappingException {
        if (cls != null) {
            StdSerializerProvider createInstance = createInstance(serializationConfig, serializerFactory);
            if (createInstance.getClass() == getClass()) {
                JsonSerializer<Object> findValueSerializer = createInstance.findValueSerializer(cls, (BeanProperty) null);
                JsonNode schema = findValueSerializer instanceof SchemaAware ? ((SchemaAware) findValueSerializer).getSchema(createInstance, (Type) null) : JsonSchema.getDefaultSchemaNode();
                if (schema instanceof ObjectNode) {
                    return new JsonSchema((ObjectNode) schema);
                }
                throw new IllegalArgumentException("Class " + cls.getName() + " would not be serialized as a JSON object and therefore has no schema");
            }
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + createInstance.getClass() + "; blueprint of type " + getClass());
        }
        throw new IllegalArgumentException("A class must be provided");
    }

    public boolean hasSerializerFor(SerializationConfig serializationConfig, Class<?> cls, SerializerFactory serializerFactory) {
        return createInstance(serializationConfig, serializerFactory)._findExplicitUntypedSerializer(cls, (BeanProperty) null) != null;
    }

    public int cachedSerializersCount() {
        return this._serializerCache.size();
    }

    public void flushCachedSerializers() {
        this._serializerCache.flush();
    }

    public JsonSerializer<Object> findValueSerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> untypedValueSerializer = this._knownSerializers.untypedValueSerializer(cls);
        if (untypedValueSerializer == null && (untypedValueSerializer = this._serializerCache.untypedValueSerializer(cls)) == null && (untypedValueSerializer = this._serializerCache.untypedValueSerializer(this._config.constructType(cls))) == null && (untypedValueSerializer = _createAndCacheUntypedSerializer(cls, beanProperty)) == null) {
            return getUnknownTypeSerializer(cls);
        }
        return _handleContextualResolvable(untypedValueSerializer, beanProperty);
    }

    public JsonSerializer<Object> findValueSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> untypedValueSerializer = this._knownSerializers.untypedValueSerializer(javaType);
        if (untypedValueSerializer == null && (untypedValueSerializer = this._serializerCache.untypedValueSerializer(javaType)) == null && (untypedValueSerializer = _createAndCacheUntypedSerializer(javaType, beanProperty)) == null) {
            return getUnknownTypeSerializer(javaType.getRawClass());
        }
        return _handleContextualResolvable(untypedValueSerializer, beanProperty);
    }

    public JsonSerializer<Object> findTypedValueSerializer(Class<?> cls, boolean z, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> typedValueSerializer = this._knownSerializers.typedValueSerializer(cls);
        if (typedValueSerializer != null) {
            return typedValueSerializer;
        }
        JsonSerializer<Object> typedValueSerializer2 = this._serializerCache.typedValueSerializer(cls);
        if (typedValueSerializer2 != null) {
            return typedValueSerializer2;
        }
        JsonSerializer<Object> findValueSerializer = findValueSerializer(cls, beanProperty);
        TypeSerializer createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, this._config.constructType(cls), beanProperty);
        if (createTypeSerializer != null) {
            findValueSerializer = new WrappedSerializer(createTypeSerializer, findValueSerializer);
        }
        if (z) {
            this._serializerCache.addTypedSerializer(cls, findValueSerializer);
        }
        return findValueSerializer;
    }

    public JsonSerializer<Object> findTypedValueSerializer(JavaType javaType, boolean z, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> typedValueSerializer = this._knownSerializers.typedValueSerializer(javaType);
        if (typedValueSerializer != null) {
            return typedValueSerializer;
        }
        JsonSerializer<Object> typedValueSerializer2 = this._serializerCache.typedValueSerializer(javaType);
        if (typedValueSerializer2 != null) {
            return typedValueSerializer2;
        }
        JsonSerializer<Object> findValueSerializer = findValueSerializer(javaType, beanProperty);
        TypeSerializer createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, javaType, beanProperty);
        if (createTypeSerializer != null) {
            findValueSerializer = new WrappedSerializer(createTypeSerializer, findValueSerializer);
        }
        if (z) {
            this._serializerCache.addTypedSerializer(javaType, findValueSerializer);
        }
        return findValueSerializer;
    }

    public JsonSerializer<Object> findKeySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> createKeySerializer = this._serializerFactory.createKeySerializer(this._config, javaType, beanProperty);
        if (createKeySerializer == null) {
            createKeySerializer = this._keySerializer;
        }
        return createKeySerializer instanceof ContextualSerializer ? ((ContextualSerializer) createKeySerializer).createContextual(this._config, beanProperty) : createKeySerializer;
    }

    public JsonSerializer<Object> getNullKeySerializer() {
        return this._nullKeySerializer;
    }

    public JsonSerializer<Object> getNullValueSerializer() {
        return this._nullValueSerializer;
    }

    public JsonSerializer<Object> getUnknownTypeSerializer(Class<?> cls) {
        return this._unknownTypeSerializer;
    }

    public final void defaultSerializeDateValue(long j, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.writeNumber(j);
            return;
        }
        if (this._dateFormat == null) {
            this._dateFormat = (DateFormat) this._config.getDateFormat().clone();
        }
        jsonGenerator.writeString(this._dateFormat.format(new Date(j)));
    }

    public final void defaultSerializeDateValue(Date date, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.writeNumber(date.getTime());
            return;
        }
        if (this._dateFormat == null) {
            this._dateFormat = (DateFormat) this._config.getDateFormat().clone();
        }
        jsonGenerator.writeString(this._dateFormat.format(date));
    }

    /* access modifiers changed from: protected */
    public void _serializeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonProcessingException {
        boolean z;
        JsonSerializer<Object> jsonSerializer;
        if (obj == null) {
            jsonSerializer = getNullValueSerializer();
            z = false;
        } else {
            jsonSerializer = findTypedValueSerializer(obj.getClass(), true, (BeanProperty) null);
            z = this._config.isEnabled(SerializationConfig.Feature.WRAP_ROOT_VALUE);
            if (z) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName(this._rootNames.findRootName(obj.getClass(), (MapperConfig<?>) this._config));
            }
        }
        try {
            jsonSerializer.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.writeEndObject();
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "[no message for " + e2.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, (Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void _serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType) throws IOException, JsonProcessingException {
        JsonSerializer<Object> jsonSerializer;
        boolean z;
        if (obj == null) {
            jsonSerializer = getNullValueSerializer();
            z = false;
        } else {
            if (!javaType.getRawClass().isAssignableFrom(obj.getClass())) {
                _reportIncompatibleRootType(obj, javaType);
            }
            JsonSerializer<Object> findTypedValueSerializer = findTypedValueSerializer(javaType, true, (BeanProperty) null);
            boolean isEnabled = this._config.isEnabled(SerializationConfig.Feature.WRAP_ROOT_VALUE);
            if (isEnabled) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName(this._rootNames.findRootName(javaType, (MapperConfig<?>) this._config));
            }
            jsonSerializer = findTypedValueSerializer;
            z = isEnabled;
        }
        try {
            jsonSerializer.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.writeEndObject();
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "[no message for " + e2.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, (Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void _reportIncompatibleRootType(Object obj, JavaType javaType) throws IOException, JsonProcessingException {
        if (!javaType.isPrimitive() || !ClassUtil.wrapperType(javaType.getRawClass()).isAssignableFrom(obj.getClass())) {
            throw new JsonMappingException("Incompatible types: declared root type (" + javaType + ") vs " + obj.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _findExplicitUntypedSerializer(Class<?> cls, BeanProperty beanProperty) {
        JsonSerializer<Object> untypedValueSerializer = this._knownSerializers.untypedValueSerializer(cls);
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        JsonSerializer<Object> untypedValueSerializer2 = this._serializerCache.untypedValueSerializer(cls);
        if (untypedValueSerializer2 != null) {
            return untypedValueSerializer2;
        }
        try {
            return _createAndCacheUntypedSerializer(cls, beanProperty);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _createAndCacheUntypedSerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        try {
            JsonSerializer<Object> _createUntypedSerializer = _createUntypedSerializer(this._config.constructType(cls), beanProperty);
            if (_createUntypedSerializer != null) {
                this._serializerCache.addAndResolveNonTypedSerializer(cls, _createUntypedSerializer, (SerializerProvider) this);
            }
            return _createUntypedSerializer;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), (JsonLocation) null, e);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _createAndCacheUntypedSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        try {
            JsonSerializer<Object> _createUntypedSerializer = _createUntypedSerializer(javaType, beanProperty);
            if (_createUntypedSerializer != null) {
                this._serializerCache.addAndResolveNonTypedSerializer(javaType, _createUntypedSerializer, (SerializerProvider) this);
            }
            return _createUntypedSerializer;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), (JsonLocation) null, e);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _createUntypedSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return this._serializerFactory.createSerializer(this._config, javaType, beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _handleContextualResolvable(JsonSerializer<Object> jsonSerializer, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> createContextual;
        if (!(jsonSerializer instanceof ContextualSerializer) || (createContextual = ((ContextualSerializer) jsonSerializer).createContextual(this._config, beanProperty)) == jsonSerializer) {
            return jsonSerializer;
        }
        if (createContextual instanceof ResolvableSerializer) {
            ((ResolvableSerializer) createContextual).resolve(this);
        }
        return createContextual;
    }

    private static final class WrappedSerializer extends JsonSerializer<Object> {
        protected final JsonSerializer<Object> _serializer;
        protected final TypeSerializer _typeSerializer;

        public WrappedSerializer(TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
            this._typeSerializer = typeSerializer;
            this._serializer = jsonSerializer;
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            this._serializer.serializeWithType(obj, jsonGenerator, serializerProvider, this._typeSerializer);
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
            this._serializer.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
        }

        public Class<Object> handledType() {
            return Object.class;
        }
    }
}
