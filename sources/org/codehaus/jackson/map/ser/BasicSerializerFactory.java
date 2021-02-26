package org.codehaus.jackson.map.ser;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.TimeZone;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualSerializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ext.OptionalHandlerFactory;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.ser.ArraySerializers;
import org.codehaus.jackson.map.ser.StdSerializers;
import org.codehaus.jackson.map.ser.impl.IndexedStringListSerializer;
import org.codehaus.jackson.map.ser.impl.InetAddressSerializer;
import org.codehaus.jackson.map.ser.impl.ObjectArraySerializer;
import org.codehaus.jackson.map.ser.impl.StringCollectionSerializer;
import org.codehaus.jackson.map.ser.impl.TimeZoneSerializer;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.EnumValues;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

public abstract class BasicSerializerFactory extends SerializerFactory {
    protected static final HashMap<String, JsonSerializer<?>> _arraySerializers = new HashMap<>();
    protected static final HashMap<String, JsonSerializer<?>> _concrete = new HashMap<>();
    protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy = new HashMap<>();
    protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;

    public abstract JsonSerializer<Object> createSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract Iterable<Serializers> customSerializers();

    static {
        _concrete.put(String.class.getName(), new StdSerializers.StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        _concrete.put(StringBuffer.class.getName(), toStringSerializer);
        _concrete.put(StringBuilder.class.getName(), toStringSerializer);
        _concrete.put(Character.class.getName(), toStringSerializer);
        _concrete.put(Character.TYPE.getName(), toStringSerializer);
        _concrete.put(Boolean.TYPE.getName(), new StdSerializers.BooleanSerializer(true));
        _concrete.put(Boolean.class.getName(), new StdSerializers.BooleanSerializer(false));
        StdSerializers.IntegerSerializer integerSerializer = new StdSerializers.IntegerSerializer();
        _concrete.put(Integer.class.getName(), integerSerializer);
        _concrete.put(Integer.TYPE.getName(), integerSerializer);
        _concrete.put(Long.class.getName(), StdSerializers.LongSerializer.instance);
        _concrete.put(Long.TYPE.getName(), StdSerializers.LongSerializer.instance);
        _concrete.put(Byte.class.getName(), StdSerializers.IntLikeSerializer.instance);
        _concrete.put(Byte.TYPE.getName(), StdSerializers.IntLikeSerializer.instance);
        _concrete.put(Short.class.getName(), StdSerializers.IntLikeSerializer.instance);
        _concrete.put(Short.TYPE.getName(), StdSerializers.IntLikeSerializer.instance);
        _concrete.put(Float.class.getName(), StdSerializers.FloatSerializer.instance);
        _concrete.put(Float.TYPE.getName(), StdSerializers.FloatSerializer.instance);
        _concrete.put(Double.class.getName(), StdSerializers.DoubleSerializer.instance);
        _concrete.put(Double.TYPE.getName(), StdSerializers.DoubleSerializer.instance);
        StdSerializers.NumberSerializer numberSerializer = new StdSerializers.NumberSerializer();
        _concrete.put(BigInteger.class.getName(), numberSerializer);
        _concrete.put(BigDecimal.class.getName(), numberSerializer);
        _concrete.put(Calendar.class.getName(), StdSerializers.CalendarSerializer.instance);
        _concrete.put(Date.class.getName(), StdSerializers.UtilDateSerializer.instance);
        _concrete.put(java.sql.Date.class.getName(), new StdSerializers.SqlDateSerializer());
        _concrete.put(Time.class.getName(), new StdSerializers.SqlTimeSerializer());
        _concrete.put(Timestamp.class.getName(), StdSerializers.UtilDateSerializer.instance);
        for (Map.Entry next : new JdkSerializers().provide()) {
            Object value = next.getValue();
            if (value instanceof JsonSerializer) {
                _concrete.put(((Class) next.getKey()).getName(), (JsonSerializer) value);
            } else if (value instanceof Class) {
                _concreteLazy.put(((Class) next.getKey()).getName(), (Class) value);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + next.getClass().getName());
            }
        }
        _concreteLazy.put(TokenBuffer.class.getName(), StdSerializers.TokenBufferSerializer.class);
        _arraySerializers.put(boolean[].class.getName(), new ArraySerializers.BooleanArraySerializer());
        _arraySerializers.put(byte[].class.getName(), new ArraySerializers.ByteArraySerializer());
        _arraySerializers.put(char[].class.getName(), new ArraySerializers.CharArraySerializer());
        _arraySerializers.put(short[].class.getName(), new ArraySerializers.ShortArraySerializer());
        _arraySerializers.put(int[].class.getName(), new ArraySerializers.IntArraySerializer());
        _arraySerializers.put(long[].class.getName(), new ArraySerializers.LongArraySerializer());
        _arraySerializers.put(float[].class.getName(), new ArraySerializers.FloatArraySerializer());
        _arraySerializers.put(double[].class.getName(), new ArraySerializers.DoubleArraySerializer());
    }

    protected BasicSerializerFactory() {
    }

    public TypeSerializer createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) {
        Collection<NamedType> collection;
        AnnotatedClass classInfo = ((BasicBeanDescription) serializationConfig.introspectClassAnnotations(javaType.getRawClass())).getClassInfo();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findTypeResolver = annotationIntrospector.findTypeResolver(serializationConfig, classInfo, javaType);
        if (findTypeResolver == null) {
            findTypeResolver = serializationConfig.getDefaultTyper(javaType);
            collection = null;
        } else {
            collection = serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(classInfo, (MapperConfig<?>) serializationConfig, annotationIntrospector);
        }
        if (findTypeResolver == null) {
            return null;
        }
        return findTypeResolver.buildTypeSerializer(serializationConfig, javaType, collection, beanProperty);
    }

    public final JsonSerializer<?> getNullSerializer() {
        return NullSerializer.instance;
    }

    public final JsonSerializer<?> findSerializerByLookup(JavaType javaType, SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) {
        String name = javaType.getRawClass().getName();
        JsonSerializer<?> jsonSerializer = _concrete.get(name);
        if (jsonSerializer != null) {
            return jsonSerializer;
        }
        Class cls = _concreteLazy.get(name);
        if (cls == null) {
            return null;
        }
        try {
            return (JsonSerializer) cls.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate standard serializer (of type " + cls.getName() + "): " + e.getMessage(), e);
        }
    }

    public final JsonSerializer<?> findSerializerByPrimaryType(JavaType javaType, SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (!JsonSerializable.class.isAssignableFrom(rawClass)) {
            AnnotatedMethod findJsonValueMethod = basicBeanDescription.findJsonValueMethod();
            if (findJsonValueMethod != null) {
                Method annotated = findJsonValueMethod.getAnnotated();
                if (serializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                    ClassUtil.checkAndFixAccess(annotated);
                }
                return new JsonValueSerializer(annotated, findSerializerFromAnnotation(serializationConfig, findJsonValueMethod, beanProperty), beanProperty);
            } else if (InetAddress.class.isAssignableFrom(rawClass)) {
                return InetAddressSerializer.instance;
            } else {
                if (TimeZone.class.isAssignableFrom(rawClass)) {
                    return TimeZoneSerializer.instance;
                }
                JsonSerializer<?> findSerializer = this.optionalHandlers.findSerializer(serializationConfig, javaType);
                if (findSerializer != null) {
                    return findSerializer;
                }
                if (Number.class.isAssignableFrom(rawClass)) {
                    return StdSerializers.NumberSerializer.instance;
                }
                if (Enum.class.isAssignableFrom(rawClass)) {
                    return EnumSerializer.construct(rawClass, serializationConfig, basicBeanDescription);
                }
                if (Calendar.class.isAssignableFrom(rawClass)) {
                    return StdSerializers.CalendarSerializer.instance;
                }
                if (Date.class.isAssignableFrom(rawClass)) {
                    return StdSerializers.UtilDateSerializer.instance;
                }
                return null;
            }
        } else if (JsonSerializableWithType.class.isAssignableFrom(rawClass)) {
            return StdSerializers.SerializableWithTypeSerializer.instance;
        } else {
            return StdSerializers.SerializableSerializer.instance;
        }
    }

    public final JsonSerializer<?> findSerializerByAddonType(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (Iterator.class.isAssignableFrom(rawClass)) {
            return buildIteratorSerializer(serializationConfig, javaType, basicBeanDescription, beanProperty, z);
        }
        if (Iterable.class.isAssignableFrom(rawClass)) {
            return buildIterableSerializer(serializationConfig, javaType, basicBeanDescription, beanProperty, z);
        }
        if (CharSequence.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> findSerializerFromAnnotation(SerializationConfig serializationConfig, Annotated annotated, BeanProperty beanProperty) throws JsonMappingException {
        Object findSerializer = serializationConfig.getAnnotationIntrospector().findSerializer(annotated);
        if (findSerializer == null) {
            return null;
        }
        if (findSerializer instanceof JsonSerializer) {
            JsonSerializer<Object> jsonSerializer = (JsonSerializer) findSerializer;
            return jsonSerializer instanceof ContextualSerializer ? ((ContextualSerializer) jsonSerializer).createContextual(serializationConfig, beanProperty) : jsonSerializer;
        } else if (findSerializer instanceof Class) {
            Class cls = (Class) findSerializer;
            if (JsonSerializer.class.isAssignableFrom(cls)) {
                JsonSerializer<Object> serializerInstance = serializationConfig.serializerInstance(annotated, cls);
                return serializerInstance instanceof ContextualSerializer ? ((ContextualSerializer) serializerInstance).createContextual(serializationConfig, beanProperty) : serializerInstance;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned value of type " + findSerializer.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
        }
    }

    public JsonSerializer<?> buildContainerSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) {
        boolean z2;
        TypeSerializer createTypeSerializer = createTypeSerializer(serializationConfig, javaType.getContentType(), beanProperty);
        if (createTypeSerializer != null) {
            z2 = false;
        } else {
            if (!z) {
                z = usesStaticTyping(serializationConfig, basicBeanDescription, createTypeSerializer, beanProperty);
            }
            z2 = z;
        }
        JsonSerializer<Object> findContentSerializer = findContentSerializer(serializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (javaType.isMapLikeType()) {
            MapLikeType mapLikeType = (MapLikeType) javaType;
            JsonSerializer<Object> findKeySerializer = findKeySerializer(serializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
            if (!mapLikeType.isTrueMapType()) {
                return buildMapLikeSerializer(serializationConfig, mapLikeType, basicBeanDescription, beanProperty, z2, findKeySerializer, createTypeSerializer, findContentSerializer);
            }
            return buildMapSerializer(serializationConfig, (MapType) mapLikeType, basicBeanDescription, beanProperty, z2, findKeySerializer, createTypeSerializer, findContentSerializer);
        } else if (javaType.isCollectionLikeType()) {
            CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
            if (!collectionLikeType.isTrueCollectionType()) {
                return buildCollectionLikeSerializer(serializationConfig, collectionLikeType, basicBeanDescription, beanProperty, z2, createTypeSerializer, findContentSerializer);
            }
            return buildCollectionSerializer(serializationConfig, (CollectionType) collectionLikeType, basicBeanDescription, beanProperty, z2, createTypeSerializer, findContentSerializer);
        } else if (!javaType.isArrayType()) {
            return null;
        } else {
            return buildArraySerializer(serializationConfig, (ArrayType) javaType, basicBeanDescription, beanProperty, z2, createTypeSerializer, findContentSerializer);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        for (Serializers findCollectionLikeSerializer : customSerializers()) {
            JsonSerializer<?> findCollectionLikeSerializer2 = findCollectionLikeSerializer.findCollectionLikeSerializer(serializationConfig, collectionLikeType, basicBeanDescription, beanProperty, typeSerializer, jsonSerializer);
            if (findCollectionLikeSerializer2 != null) {
                return findCollectionLikeSerializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        BeanProperty beanProperty2 = beanProperty;
        boolean z2 = z;
        TypeSerializer typeSerializer2 = typeSerializer;
        JsonSerializer<Object> jsonSerializer2 = jsonSerializer;
        for (Serializers findCollectionSerializer : customSerializers()) {
            JsonSerializer<?> findCollectionSerializer2 = findCollectionSerializer.findCollectionSerializer(serializationConfig, collectionType, basicBeanDescription, beanProperty, typeSerializer, jsonSerializer);
            if (findCollectionSerializer2 != null) {
                return findCollectionSerializer2;
            }
        }
        Class<?> rawClass = collectionType.getRawClass();
        if (EnumSet.class.isAssignableFrom(rawClass)) {
            return buildEnumSetSerializer(serializationConfig, collectionType, basicBeanDescription, beanProperty, z, typeSerializer, jsonSerializer);
        }
        Class<?> rawClass2 = collectionType.getContentType().getRawClass();
        if (isIndexedList(rawClass)) {
            if (rawClass2 == String.class) {
                return new IndexedStringListSerializer(beanProperty2);
            }
            return ContainerSerializers.indexedListSerializer(collectionType.getContentType(), z2, typeSerializer2, beanProperty2, jsonSerializer2);
        } else if (rawClass2 == String.class) {
            return new StringCollectionSerializer(beanProperty2);
        } else {
            return ContainerSerializers.collectionSerializer(collectionType.getContentType(), z2, typeSerializer2, beanProperty2, jsonSerializer2);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildEnumSetSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        JavaType contentType = javaType.getContentType();
        if (!contentType.isEnumType()) {
            contentType = null;
        }
        return ContainerSerializers.enumSetSerializer(contentType, beanProperty);
    }

    /* access modifiers changed from: protected */
    public boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        for (Serializers findMapLikeSerializer : customSerializers()) {
            JsonSerializer<?> findMapLikeSerializer2 = findMapLikeSerializer.findMapLikeSerializer(serializationConfig, mapLikeType, basicBeanDescription, beanProperty, jsonSerializer, typeSerializer, jsonSerializer2);
            if (findMapLikeSerializer2 != null) {
                return findMapLikeSerializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildMapSerializer(SerializationConfig serializationConfig, MapType mapType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        for (Serializers findMapSerializer : customSerializers()) {
            JsonSerializer<?> findMapSerializer2 = findMapSerializer.findMapSerializer(serializationConfig, mapType, basicBeanDescription, beanProperty, jsonSerializer, typeSerializer, jsonSerializer2);
            if (findMapSerializer2 != null) {
                return findMapSerializer2;
            }
        }
        if (EnumMap.class.isAssignableFrom(mapType.getRawClass())) {
            return buildEnumMapSerializer(serializationConfig, mapType, basicBeanDescription, beanProperty, z, typeSerializer, jsonSerializer2);
        }
        return MapSerializer.construct(serializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(basicBeanDescription.getClassInfo()), mapType, z, typeSerializer, beanProperty, jsonSerializer, jsonSerializer2);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildEnumMapSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        JavaType keyType = javaType.getKeyType();
        return new EnumMapSerializer(javaType.getContentType(), z, keyType.isEnumType() ? EnumValues.construct(keyType.getRawClass(), serializationConfig.getAnnotationIntrospector()) : null, typeSerializer, beanProperty, jsonSerializer);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        Class<?> rawClass = arrayType.getRawClass();
        if (String[].class == rawClass) {
            return new ArraySerializers.StringArraySerializer(beanProperty);
        }
        JsonSerializer<?> jsonSerializer2 = _arraySerializers.get(rawClass.getName());
        if (jsonSerializer2 != null) {
            return jsonSerializer2;
        }
        return new ObjectArraySerializer(arrayType.getContentType(), z, typeSerializer, beanProperty, jsonSerializer);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildIteratorSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) {
        JavaType containedType = javaType.containedType(0);
        if (containedType == null) {
            containedType = TypeFactory.unknownType();
        }
        TypeSerializer createTypeSerializer = createTypeSerializer(serializationConfig, containedType, beanProperty);
        return ContainerSerializers.iteratorSerializer(containedType, usesStaticTyping(serializationConfig, basicBeanDescription, createTypeSerializer, beanProperty), createTypeSerializer, beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildIterableSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, boolean z) {
        JavaType containedType = javaType.containedType(0);
        if (containedType == null) {
            containedType = TypeFactory.unknownType();
        }
        TypeSerializer createTypeSerializer = createTypeSerializer(serializationConfig, containedType, beanProperty);
        return ContainerSerializers.iterableSerializer(containedType, usesStaticTyping(serializationConfig, basicBeanDescription, createTypeSerializer, beanProperty), createTypeSerializer, beanProperty);
    }

    /* access modifiers changed from: protected */
    public <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig serializationConfig, Annotated annotated, T t) {
        Class<?> findSerializationType = serializationConfig.getAnnotationIntrospector().findSerializationType(annotated);
        if (findSerializationType != null) {
            try {
                t = t.widenBy(findSerializationType);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to widen type " + t + " with concrete-type annotation (value " + findSerializationType.getName() + "), method '" + annotated.getName() + "': " + e.getMessage());
            }
        }
        return modifySecondaryTypesByAnnotation(serializationConfig, annotated, t);
    }

    protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig serializationConfig, Annotated annotated, T t) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        if (!t.isContainerType()) {
            return t;
        }
        Class<?> findSerializationKeyType = annotationIntrospector.findSerializationKeyType(annotated, t.getKeyType());
        if (findSerializationKeyType != null) {
            if (t instanceof MapType) {
                try {
                    t = ((MapType) t).widenKey(findSerializationKeyType);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Failed to narrow key type " + t + " with key-type annotation (" + findSerializationKeyType.getName() + "): " + e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("Illegal key-type annotation: type " + t + " is not a Map type");
            }
        }
        Class<?> findSerializationContentType = annotationIntrospector.findSerializationContentType(annotated, t.getContentType());
        if (findSerializationContentType == null) {
            return t;
        }
        try {
            return t.widenContentsBy(findSerializationContentType);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Failed to narrow content type " + t + " with content-type annotation (" + findSerializationContentType.getName() + "): " + e2.getMessage());
        }
    }

    protected static JsonSerializer<Object> findKeySerializer(SerializationConfig serializationConfig, Annotated annotated, BeanProperty beanProperty) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        Class<? extends JsonSerializer<?>> findKeySerializer = annotationIntrospector.findKeySerializer(annotated);
        if ((findKeySerializer == null || findKeySerializer == JsonSerializer.None.class) && beanProperty != null) {
            findKeySerializer = annotationIntrospector.findKeySerializer(beanProperty.getMember());
        }
        if (findKeySerializer == null || findKeySerializer == JsonSerializer.None.class) {
            return null;
        }
        return serializationConfig.serializerInstance(annotated, findKeySerializer);
    }

    protected static JsonSerializer<Object> findContentSerializer(SerializationConfig serializationConfig, Annotated annotated, BeanProperty beanProperty) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        Class<? extends JsonSerializer<?>> findContentSerializer = annotationIntrospector.findContentSerializer(annotated);
        if ((findContentSerializer == null || findContentSerializer == JsonSerializer.None.class) && beanProperty != null) {
            findContentSerializer = annotationIntrospector.findContentSerializer(beanProperty.getMember());
        }
        if (findContentSerializer == null || findContentSerializer == JsonSerializer.None.class) {
            return null;
        }
        return serializationConfig.serializerInstance(annotated, findContentSerializer);
    }

    /* access modifiers changed from: protected */
    public boolean usesStaticTyping(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        if (typeSerializer != null) {
            return false;
        }
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        JsonSerialize.Typing findSerializationTyping = annotationIntrospector.findSerializationTyping(basicBeanDescription.getClassInfo());
        if (findSerializationTyping != null) {
            if (findSerializationTyping == JsonSerialize.Typing.STATIC) {
                return true;
            }
        } else if (serializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING)) {
            return true;
        }
        if (beanProperty != null) {
            JavaType type = beanProperty.getType();
            if (type.isContainerType()) {
                if (annotationIntrospector.findSerializationContentType(beanProperty.getMember(), beanProperty.getType()) != null) {
                    return true;
                }
                if (!(type instanceof MapType) || annotationIntrospector.findSerializationKeyType(beanProperty.getMember(), beanProperty.getType()) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
