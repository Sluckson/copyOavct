package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.ContextualKeyDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializerProvider extends DeserializerProvider {
    static final HashMap<JavaType, KeyDeserializer> _keyDeserializers = StdKeyDeserializers.constructAll();
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers;
    protected DeserializerFactory _factory;
    protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers;

    public StdDeserializerProvider() {
        this(BeanDeserializerFactory.instance);
    }

    public StdDeserializerProvider(DeserializerFactory deserializerFactory) {
        this._cachedDeserializers = new ConcurrentHashMap<>(64, 0.75f, 2);
        this._incompleteDeserializers = new HashMap<>(8);
        this._factory = deserializerFactory;
    }

    public DeserializerProvider withAdditionalDeserializers(Deserializers deserializers) {
        this._factory = this._factory.withAdditionalDeserializers(deserializers);
        return this;
    }

    public DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        this._factory = this._factory.withAdditionalKeyDeserializers(keyDeserializers);
        return this;
    }

    public DeserializerProvider withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        this._factory = this._factory.withDeserializerModifier(beanDeserializerModifier);
        return this;
    }

    public DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        this._factory = this._factory.withAbstractTypeResolver(abstractTypeResolver);
        return this;
    }

    public JsonDeserializer<Object> findValueDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonDeserializer<Object> _findCachedDeserializer = _findCachedDeserializer(javaType);
        if (_findCachedDeserializer != null) {
            return _findCachedDeserializer instanceof ContextualDeserializer ? ((ContextualDeserializer) _findCachedDeserializer).createContextual(deserializationConfig, beanProperty) : _findCachedDeserializer;
        }
        JsonDeserializer<Object> _createAndCacheValueDeserializer = _createAndCacheValueDeserializer(deserializationConfig, javaType, beanProperty);
        if (_createAndCacheValueDeserializer == null) {
            _createAndCacheValueDeserializer = _handleUnknownValueDeserializer(javaType);
        }
        return _createAndCacheValueDeserializer instanceof ContextualDeserializer ? ((ContextualDeserializer) _createAndCacheValueDeserializer).createContextual(deserializationConfig, beanProperty) : _createAndCacheValueDeserializer;
    }

    public JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonDeserializer<Object> findValueDeserializer = findValueDeserializer(deserializationConfig, javaType, beanProperty);
        TypeDeserializer findTypeDeserializer = this._factory.findTypeDeserializer(deserializationConfig, javaType, beanProperty);
        return findTypeDeserializer != null ? new WrappedDeserializer(findTypeDeserializer, findValueDeserializer) : findValueDeserializer;
    }

    public KeyDeserializer findKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        KeyDeserializer createKeyDeserializer = this._factory.createKeyDeserializer(deserializationConfig, javaType, beanProperty);
        if (createKeyDeserializer == null) {
            Class<?> rawClass = javaType.getRawClass();
            if (rawClass == String.class || rawClass == Object.class) {
                return null;
            }
            KeyDeserializer keyDeserializer = _keyDeserializers.get(javaType);
            if (keyDeserializer != null) {
                return keyDeserializer;
            }
            if (javaType.isEnumType()) {
                return StdKeyDeserializers.constructEnumKeyDeserializer(deserializationConfig, javaType);
            }
            KeyDeserializer findStringBasedKeyDeserializer = StdKeyDeserializers.findStringBasedKeyDeserializer(deserializationConfig, javaType);
            if (findStringBasedKeyDeserializer != null) {
                return findStringBasedKeyDeserializer;
            }
            if (createKeyDeserializer == null) {
                return _handleUnknownKeyDeserializer(javaType);
            }
        }
        return createKeyDeserializer instanceof ContextualKeyDeserializer ? ((ContextualKeyDeserializer) createKeyDeserializer).createContextual(deserializationConfig, beanProperty) : createKeyDeserializer;
    }

    public boolean hasValueDeserializerFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        JsonDeserializer<Object> _findCachedDeserializer = _findCachedDeserializer(javaType);
        if (_findCachedDeserializer == null) {
            try {
                _findCachedDeserializer = _createAndCacheValueDeserializer(deserializationConfig, javaType, (BeanProperty) null);
            } catch (Exception unused) {
                return false;
            }
        }
        if (_findCachedDeserializer != null) {
            return true;
        }
        return false;
    }

    public int cachedDeserializersCount() {
        return this._cachedDeserializers.size();
    }

    public void flushCachedDeserializers() {
        this._cachedDeserializers.clear();
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCachedDeserializer(JavaType javaType) {
        return this._cachedDeserializers.get(javaType);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.JsonDeserializer<java.lang.Object> _createAndCacheValueDeserializer(org.codehaus.jackson.map.DeserializationConfig r4, org.codehaus.jackson.type.JavaType r5, org.codehaus.jackson.map.BeanProperty r6) throws org.codehaus.jackson.map.JsonMappingException {
        /*
            r3 = this;
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r0 = r3._incompleteDeserializers
            monitor-enter(r0)
            org.codehaus.jackson.map.JsonDeserializer r1 = r3._findCachedDeserializer(r5)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r1
        L_0x000b:
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r1 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            int r1 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r1 <= 0) goto L_0x001f
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r2 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0045 }
            org.codehaus.jackson.map.JsonDeserializer r2 = (org.codehaus.jackson.map.JsonDeserializer) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r2
        L_0x001f:
            org.codehaus.jackson.map.JsonDeserializer r4 = r3._createAndCache2(r4, r5, r6)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r5 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            int r5 = r5.size()     // Catch:{ all -> 0x0045 }
            if (r5 <= 0) goto L_0x0032
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r5 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            r5.clear()     // Catch:{ all -> 0x0045 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r4
        L_0x0034:
            r4 = move-exception
            if (r1 != 0) goto L_0x0044
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r5 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            int r5 = r5.size()     // Catch:{ all -> 0x0045 }
            if (r5 <= 0) goto L_0x0044
            java.util.HashMap<org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.JsonDeserializer<java.lang.Object>> r5 = r3._incompleteDeserializers     // Catch:{ all -> 0x0045 }
            r5.clear()     // Catch:{ all -> 0x0045 }
        L_0x0044:
            throw r4     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.deser.StdDeserializerProvider._createAndCacheValueDeserializer(org.codehaus.jackson.map.DeserializationConfig, org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.BeanProperty):org.codehaus.jackson.map.JsonDeserializer");
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _createAndCache2(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        try {
            JsonDeserializer<Object> _createDeserializer = _createDeserializer(deserializationConfig, javaType, beanProperty);
            if (_createDeserializer == null) {
                return null;
            }
            boolean z = _createDeserializer instanceof ResolvableDeserializer;
            boolean z2 = _createDeserializer.getClass() == BeanDeserializer.class;
            if (!z2 && deserializationConfig.isEnabled(DeserializationConfig.Feature.USE_ANNOTATIONS)) {
                AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
                Boolean findCachability = annotationIntrospector.findCachability(AnnotatedClass.construct(_createDeserializer.getClass(), annotationIntrospector, (ClassIntrospector.MixInResolver) null));
                if (findCachability != null) {
                    z2 = findCachability.booleanValue();
                }
            }
            if (z) {
                this._incompleteDeserializers.put(javaType, _createDeserializer);
                _resolveDeserializer(deserializationConfig, (ResolvableDeserializer) _createDeserializer);
                this._incompleteDeserializers.remove(javaType);
            }
            if (z2) {
                this._cachedDeserializers.put(javaType, _createDeserializer);
            }
            return _createDeserializer;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), (JsonLocation) null, e);
        }
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _createDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType.isEnumType()) {
            return this._factory.createEnumDeserializer(deserializationConfig, this, javaType, beanProperty);
        }
        if (javaType.isContainerType()) {
            if (javaType.isArrayType()) {
                return this._factory.createArrayDeserializer(deserializationConfig, this, (ArrayType) javaType, beanProperty);
            }
            if (javaType.isMapLikeType()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                if (mapLikeType.isTrueMapType()) {
                    return this._factory.createMapDeserializer(deserializationConfig, this, (MapType) mapLikeType, beanProperty);
                }
                return this._factory.createMapLikeDeserializer(deserializationConfig, this, mapLikeType, beanProperty);
            } else if (javaType.isCollectionLikeType()) {
                CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                if (collectionLikeType.isTrueCollectionType()) {
                    return this._factory.createCollectionDeserializer(deserializationConfig, this, (CollectionType) collectionLikeType, beanProperty);
                }
                return this._factory.createCollectionLikeDeserializer(deserializationConfig, this, collectionLikeType, beanProperty);
            }
        }
        if (JsonNode.class.isAssignableFrom(javaType.getRawClass())) {
            return this._factory.createTreeDeserializer(deserializationConfig, this, javaType, beanProperty);
        }
        return this._factory.createBeanDeserializer(deserializationConfig, this, javaType, beanProperty);
    }

    /* access modifiers changed from: protected */
    public void _resolveDeserializer(DeserializationConfig deserializationConfig, ResolvableDeserializer resolvableDeserializer) throws JsonMappingException {
        resolvableDeserializer.resolve(deserializationConfig, this);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType javaType) throws JsonMappingException {
        if (!ClassUtil.isConcrete(javaType.getRawClass())) {
            throw new JsonMappingException("Can not find a Value deserializer for abstract type " + javaType);
        }
        throw new JsonMappingException("Can not find a Value deserializer for type " + javaType);
    }

    /* access modifiers changed from: protected */
    public KeyDeserializer _handleUnknownKeyDeserializer(JavaType javaType) throws JsonMappingException {
        throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + javaType);
    }

    protected static final class WrappedDeserializer extends JsonDeserializer<Object> {
        final JsonDeserializer<Object> _deserializer;
        final TypeDeserializer _typeDeserializer;

        public WrappedDeserializer(TypeDeserializer typeDeserializer, JsonDeserializer<Object> jsonDeserializer) {
            this._typeDeserializer = typeDeserializer;
            this._deserializer = jsonDeserializer;
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return this._deserializer.deserializeWithType(jsonParser, deserializationContext, this._typeDeserializer);
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
            throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
        }
    }
}
