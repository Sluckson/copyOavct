package org.codehaus.jackson.map.ser;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public final class ContainerSerializers {
    private ContainerSerializers() {
    }

    public static ContainerSerializerBase<?> indexedListSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        return new IndexedListSerializer(javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    public static ContainerSerializerBase<?> collectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        return new CollectionSerializer(javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    public static ContainerSerializerBase<?> iteratorSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        return new IteratorSerializer(javaType, z, typeSerializer, beanProperty);
    }

    public static ContainerSerializerBase<?> iterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        return new IterableSerializer(javaType, z, typeSerializer, beanProperty);
    }

    public static JsonSerializer<?> enumSetSerializer(JavaType javaType, BeanProperty beanProperty) {
        return new EnumSetSerializer(javaType, beanProperty);
    }

    public static abstract class AsArraySerializer<T> extends ContainerSerializerBase<T> implements ResolvableSerializer {
        protected PropertySerializerMap _dynamicSerializers;
        protected JsonSerializer<Object> _elementSerializer;
        protected final JavaType _elementType;
        protected final BeanProperty _property;
        protected final boolean _staticTyping;
        protected final TypeSerializer _valueTypeSerializer;

        /* access modifiers changed from: protected */
        public abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException;

        @Deprecated
        protected AsArraySerializer(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            this(cls, javaType, z, typeSerializer, beanProperty, (JsonSerializer<Object>) null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected AsArraySerializer(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(cls, false);
            boolean z2 = false;
            this._elementType = javaType;
            if (z || (javaType != null && javaType.isFinal())) {
                z2 = true;
            }
            this._staticTyping = z2;
            this._valueTypeSerializer = typeSerializer;
            this._property = beanProperty;
            this._elementSerializer = jsonSerializer;
            this._dynamicSerializers = PropertySerializerMap.emptyMap();
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

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
            JavaType javaType;
            JavaType javaType2;
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            JsonNode jsonNode = null;
            if (type != null) {
                JavaType contentType = serializerProvider.constructType(type).getContentType();
                if (contentType == null && (type instanceof ParameterizedType)) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    if (actualTypeArguments.length == 1) {
                        javaType = serializerProvider.constructType(actualTypeArguments[0]);
                    }
                }
                javaType = contentType;
            } else {
                javaType = null;
            }
            if (javaType == null && (javaType2 = this._elementType) != null) {
                javaType = javaType2;
            }
            if (javaType != null) {
                if (javaType.getRawClass() != Object.class) {
                    JsonSerializer<Object> findValueSerializer = serializerProvider.findValueSerializer(javaType, this._property);
                    if (findValueSerializer instanceof SchemaAware) {
                        jsonNode = ((SchemaAware) findValueSerializer).getSchema(serializerProvider, (Type) null);
                    }
                }
                if (jsonNode == null) {
                    jsonNode = JsonSchema.getDefaultSchemaNode();
                }
                createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, jsonNode);
            }
            return createSchemaNode;
        }

        public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
            JavaType javaType;
            if (this._staticTyping && (javaType = this._elementType) != null && this._elementSerializer == null) {
                this._elementSerializer = serializerProvider.findValueSerializer(javaType, this._property);
            }
        }

        /* access modifiers changed from: protected */
        public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
            PropertySerializerMap.SerializerAndMapResult findAndAddSerializer = propertySerializerMap.findAndAddSerializer(cls, serializerProvider, this._property);
            if (propertySerializerMap != findAndAddSerializer.map) {
                this._dynamicSerializers = findAndAddSerializer.map;
            }
            return findAndAddSerializer.serializer;
        }

        /* access modifiers changed from: protected */
        public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
            PropertySerializerMap.SerializerAndMapResult findAndAddSerializer = propertySerializerMap.findAndAddSerializer(javaType, serializerProvider, this._property);
            if (propertySerializerMap != findAndAddSerializer.map) {
                this._dynamicSerializers = findAndAddSerializer.map;
            }
            return findAndAddSerializer.serializer;
        }
    }

    @JacksonStdImpl
    public static class IndexedListSerializer extends AsArraySerializer<List<?>> {
        public IndexedListSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(List.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IndexedListSerializer(this._elementType, this._staticTyping, typeSerializer, this._property, this._elementSerializer);
        }

        public void serializeContents(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            JsonSerializer<Object> jsonSerializer;
            if (this._elementSerializer != null) {
                serializeContentsUsing(list, jsonGenerator, serializerProvider, this._elementSerializer);
            } else if (this._valueTypeSerializer != null) {
                serializeTypedContents(list, jsonGenerator, serializerProvider);
            } else {
                int size = list.size();
                if (size != 0) {
                    try {
                        PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                        for (int i = 0; i < size; i++) {
                            Object obj = list.get(i);
                            if (obj == null) {
                                serializerProvider.defaultSerializeNull(jsonGenerator);
                            } else {
                                Class<?> cls = obj.getClass();
                                JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                                if (serializerFor == null) {
                                    if (this._elementType.hasGenericTypes()) {
                                        jsonSerializer = _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider);
                                    } else {
                                        jsonSerializer = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                                    }
                                    serializerFor = jsonSerializer;
                                    propertySerializerMap = this._dynamicSerializers;
                                }
                                serializerFor.serialize(obj, jsonGenerator, serializerProvider);
                            }
                        }
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) list, 0);
                    }
                }
            }
        }

        public void serializeContentsUsing(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException, JsonGenerationException {
            int size = list.size();
            if (size != 0) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                for (int i = 0; i < size; i++) {
                    Object obj = list.get(i);
                    if (obj == null) {
                        try {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } catch (Exception e) {
                            wrapAndThrow(serializerProvider, (Throwable) e, (Object) list, i);
                        }
                    } else if (typeSerializer == null) {
                        jsonSerializer.serialize(obj, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                    }
                }
            }
        }

        public void serializeTypedContents(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            JsonSerializer<Object> jsonSerializer;
            int size = list.size();
            if (size != 0) {
                try {
                    TypeSerializer typeSerializer = this._valueTypeSerializer;
                    PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                    for (int i = 0; i < size; i++) {
                        Object obj = list.get(i);
                        if (obj == null) {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class<?> cls = obj.getClass();
                            JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                            if (serializerFor == null) {
                                if (this._elementType.hasGenericTypes()) {
                                    jsonSerializer = _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider);
                                } else {
                                    jsonSerializer = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                                }
                                serializerFor = jsonSerializer;
                                propertySerializerMap = this._dynamicSerializers;
                            }
                            serializerFor.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) list, 0);
                }
            }
        }
    }

    @JacksonStdImpl
    public static class CollectionSerializer extends AsArraySerializer<Collection<?>> {
        @Deprecated
        public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            this(javaType, z, typeSerializer, beanProperty, (JsonSerializer<Object>) null);
        }

        public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(Collection.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new CollectionSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            JsonSerializer<Object> jsonSerializer;
            if (this._elementSerializer != null) {
                serializeContentsUsing(collection, jsonGenerator, serializerProvider, this._elementSerializer);
                return;
            }
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                int i = 0;
                do {
                    try {
                        Object next = it.next();
                        if (next == null) {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class<?> cls = next.getClass();
                            JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                            if (serializerFor == null) {
                                if (this._elementType.hasGenericTypes()) {
                                    jsonSerializer = _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider);
                                } else {
                                    jsonSerializer = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                                }
                                serializerFor = jsonSerializer;
                                propertySerializerMap = this._dynamicSerializers;
                            }
                            if (typeSerializer == null) {
                                serializerFor.serialize(next, jsonGenerator, serializerProvider);
                            } else {
                                serializerFor.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                            }
                        }
                        i++;
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, i);
                        return;
                    }
                } while (it.hasNext());
            }
        }

        public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException, JsonGenerationException {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                int i = 0;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } catch (Exception e) {
                            wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, i);
                        }
                    } else if (typeSerializer == null) {
                        jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } while (it.hasNext());
            }
        }
    }

    @JacksonStdImpl
    public static class IteratorSerializer extends AsArraySerializer<Iterator<?>> {
        public IteratorSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            super(Iterator.class, javaType, z, typeSerializer, beanProperty);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IteratorSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        public void serializeContents(Iterator<?> it, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (it.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                Class<?> cls = null;
                JsonSerializer<Object> jsonSerializer = null;
                do {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            jsonSerializer = serializerProvider.findValueSerializer(cls2, this._property);
                            cls = cls2;
                        }
                        if (typeSerializer == null) {
                            jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                } while (it.hasNext());
            }
        }
    }

    @JacksonStdImpl
    public static class IterableSerializer extends AsArraySerializer<Iterable<?>> {
        public IterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            super(Iterable.class, javaType, z, typeSerializer, beanProperty);
        }

        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IterableSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        public void serializeContents(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            Iterator<?> it = iterable.iterator();
            if (it.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                Class<?> cls = null;
                JsonSerializer<Object> jsonSerializer = null;
                do {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            jsonSerializer = serializerProvider.findValueSerializer(cls2, this._property);
                            cls = cls2;
                        }
                        if (typeSerializer == null) {
                            jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                } while (it.hasNext());
            }
        }
    }

    public static class EnumSetSerializer extends AsArraySerializer<EnumSet<? extends Enum<?>>> {
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        public EnumSetSerializer(JavaType javaType, BeanProperty beanProperty) {
            super(EnumSet.class, javaType, true, (TypeSerializer) null, beanProperty);
        }

        public void serializeContents(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            JsonSerializer<Object> jsonSerializer = this._elementSerializer;
            Iterator it = enumSet.iterator();
            while (it.hasNext()) {
                Enum enumR = (Enum) it.next();
                if (jsonSerializer == null) {
                    jsonSerializer = serializerProvider.findValueSerializer((Class<?>) enumR.getDeclaringClass(), this._property);
                }
                jsonSerializer.serialize(enumR, jsonGenerator, serializerProvider);
            }
        }
    }
}
