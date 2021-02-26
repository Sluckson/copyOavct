package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.deser.impl.StringCollectionDeserializer;
import org.codehaus.jackson.map.ext.OptionalHandlerFactory;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public abstract class BasicDeserializerFactory extends DeserializerFactory {
    protected static final HashMap<JavaType, JsonDeserializer<Object>> _arrayDeserializers = ArrayDeserializers.getAll();
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks = new HashMap<>();
    static final HashMap<String, Class<? extends Map>> _mapFallbacks = new HashMap<>();
    static final HashMap<JavaType, JsonDeserializer<Object>> _simpleDeserializers = StdDeserializers.constructAll();
    protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanProperty beanProperty) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException;

    public abstract DeserializerFactory withConfig(DeserializerFactory.Config config);

    static {
        _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
        _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
        _mapFallbacks.put("java.util.NavigableMap", TreeMap.class);
        try {
            Class<?> cls = Class.forName("java.util.ConcurrentNavigableMap");
            _mapFallbacks.put(cls.getName(), Class.forName("java.util.ConcurrentSkipListMap"));
        } catch (ClassNotFoundException unused) {
        }
        _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
        _collectionFallbacks.put(List.class.getName(), ArrayList.class);
        _collectionFallbacks.put(Set.class.getName(), HashSet.class);
        _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
        _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
        _collectionFallbacks.put("java.util.Deque", LinkedList.class);
        _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory() {
    }

    public JsonDeserializer<?> createArrayDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, ArrayType arrayType, BeanProperty beanProperty) throws JsonMappingException {
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        if (jsonDeserializer == null) {
            JsonDeserializer<?> jsonDeserializer2 = _arrayDeserializers.get(contentType);
            if (jsonDeserializer2 != null) {
                JsonDeserializer<?> _findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, deserializationConfig, deserializerProvider, beanProperty, (TypeDeserializer) null, (JsonDeserializer<?>) null);
                return _findCustomArrayDeserializer != null ? _findCustomArrayDeserializer : jsonDeserializer2;
            } else if (contentType.isPrimitive()) {
                throw new IllegalArgumentException("Internal error: primitive type (" + arrayType + ") passed, no array deserializer found");
            }
        }
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(deserializationConfig, contentType, beanProperty);
        }
        TypeDeserializer typeDeserializer2 = typeDeserializer;
        JsonDeserializer<?> _findCustomArrayDeserializer2 = _findCustomArrayDeserializer(arrayType, deserializationConfig, deserializerProvider, beanProperty, typeDeserializer2, jsonDeserializer);
        if (_findCustomArrayDeserializer2 != null) {
            return _findCustomArrayDeserializer2;
        }
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializerProvider.findValueDeserializer(deserializationConfig, contentType, beanProperty);
        }
        return new ArrayDeserializer(arrayType, jsonDeserializer, typeDeserializer2);
    }

    public JsonDeserializer<?> createCollectionDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, CollectionType collectionType, BeanProperty beanProperty) throws JsonMappingException {
        DeserializationConfig deserializationConfig2 = deserializationConfig;
        BeanProperty beanProperty2 = beanProperty;
        CollectionType collectionType2 = (CollectionType) mapAbstractType(deserializationConfig2, collectionType);
        Class<?> rawClass = collectionType2.getRawClass();
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig2.introspectClassAnnotations(rawClass);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig2, basicBeanDescription.getClassInfo(), beanProperty2);
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        CollectionType collectionType3 = (CollectionType) modifyTypeByAnnotation(deserializationConfig2, basicBeanDescription.getClassInfo(), collectionType2, (String) null);
        JavaType contentType = collectionType3.getContentType();
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(deserializationConfig2, contentType, beanProperty2);
        }
        TypeDeserializer typeDeserializer2 = typeDeserializer;
        JsonDeserializer<?> _findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType3, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer2, jsonDeserializer);
        if (_findCustomCollectionDeserializer != null) {
            return _findCustomCollectionDeserializer;
        }
        if (jsonDeserializer == null) {
            if (EnumSet.class.isAssignableFrom(rawClass)) {
                return new EnumSetDeserializer(constructEnumResolver(contentType.getRawClass(), deserializationConfig2));
            }
            jsonDeserializer = deserializerProvider.findValueDeserializer(deserializationConfig2, contentType, beanProperty2);
        }
        if ((collectionType3.isInterface() || collectionType3.isAbstract()) && (rawClass = _collectionFallbacks.get(rawClass.getName())) == null) {
            throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + collectionType3);
        }
        Constructor<?> findConstructor = ClassUtil.findConstructor(rawClass, deserializationConfig2.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        if (contentType.getRawClass() == String.class) {
            return new StringCollectionDeserializer(collectionType3, jsonDeserializer, findConstructor);
        }
        return new CollectionDeserializer(collectionType3, jsonDeserializer, typeDeserializer2, findConstructor);
    }

    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, CollectionLikeType collectionLikeType, BeanProperty beanProperty) throws JsonMappingException {
        CollectionLikeType collectionLikeType2 = (CollectionLikeType) mapAbstractType(deserializationConfig, collectionLikeType);
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspectClassAnnotations(collectionLikeType2.getRawClass());
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        CollectionLikeType collectionLikeType3 = (CollectionLikeType) modifyTypeByAnnotation(deserializationConfig, basicBeanDescription.getClassInfo(), collectionLikeType2, (String) null);
        JavaType contentType = collectionLikeType3.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        return _findCustomCollectionLikeDeserializer(collectionLikeType3, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer == null ? findTypeDeserializer(deserializationConfig, contentType, beanProperty) : typeDeserializer, jsonDeserializer);
    }

    /* JADX WARNING: type inference failed for: r0v18, types: [org.codehaus.jackson.type.JavaType] */
    /* JADX WARNING: type inference failed for: r0v19, types: [org.codehaus.jackson.map.BeanDescription] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.JsonDeserializer<?> createMapDeserializer(org.codehaus.jackson.map.DeserializationConfig r20, org.codehaus.jackson.map.DeserializerProvider r21, org.codehaus.jackson.map.type.MapType r22, org.codehaus.jackson.map.BeanProperty r23) throws org.codehaus.jackson.map.JsonMappingException {
        /*
            r19 = this;
            r9 = r19
            r10 = r20
            r11 = r21
            r0 = r22
            r12 = r23
            org.codehaus.jackson.type.JavaType r0 = r9.mapAbstractType(r10, r0)
            org.codehaus.jackson.map.type.MapType r0 = (org.codehaus.jackson.map.type.MapType) r0
            org.codehaus.jackson.map.BeanDescription r1 = r10.introspectForCreation(r0)
            r13 = r1
            org.codehaus.jackson.map.introspect.BasicBeanDescription r13 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r13
            org.codehaus.jackson.map.introspect.AnnotatedClass r1 = r13.getClassInfo()
            org.codehaus.jackson.map.JsonDeserializer r1 = r9.findDeserializerFromAnnotation(r10, r1, r12)
            if (r1 == 0) goto L_0x0022
            return r1
        L_0x0022:
            org.codehaus.jackson.map.introspect.AnnotatedClass r1 = r13.getClassInfo()
            r2 = 0
            org.codehaus.jackson.type.JavaType r0 = r9.modifyTypeByAnnotation(r10, r1, r0, r2)
            r14 = r0
            org.codehaus.jackson.map.type.MapType r14 = (org.codehaus.jackson.map.type.MapType) r14
            org.codehaus.jackson.type.JavaType r15 = r14.getKeyType()
            org.codehaus.jackson.type.JavaType r8 = r14.getContentType()
            java.lang.Object r0 = r8.getValueHandler()
            r16 = r0
            org.codehaus.jackson.map.JsonDeserializer r16 = (org.codehaus.jackson.map.JsonDeserializer) r16
            java.lang.Object r0 = r15.getValueHandler()
            org.codehaus.jackson.map.KeyDeserializer r0 = (org.codehaus.jackson.map.KeyDeserializer) r0
            if (r0 != 0) goto L_0x004a
            org.codehaus.jackson.map.KeyDeserializer r0 = r11.findKeyDeserializer(r10, r15, r12)
        L_0x004a:
            r17 = r0
            java.lang.Object r0 = r8.getTypeHandler()
            org.codehaus.jackson.map.TypeDeserializer r0 = (org.codehaus.jackson.map.TypeDeserializer) r0
            if (r0 != 0) goto L_0x0058
            org.codehaus.jackson.map.TypeDeserializer r0 = r9.findTypeDeserializer(r10, r8, r12)
        L_0x0058:
            r18 = r0
            r0 = r19
            r1 = r14
            r2 = r20
            r3 = r21
            r4 = r13
            r5 = r23
            r6 = r17
            r7 = r18
            r22 = r13
            r13 = r8
            r8 = r16
            org.codehaus.jackson.map.JsonDeserializer r0 = r0._findCustomMapDeserializer(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x0074
            return r0
        L_0x0074:
            if (r16 != 0) goto L_0x007a
            org.codehaus.jackson.map.JsonDeserializer r16 = r11.findValueDeserializer(r10, r13, r12)
        L_0x007a:
            r5 = r16
            java.lang.Class r0 = r14.getRawClass()
            java.lang.Class<java.util.EnumMap> r1 = java.util.EnumMap.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x00a6
            java.lang.Class r0 = r15.getRawClass()
            if (r0 == 0) goto L_0x009e
            boolean r1 = r0.isEnum()
            if (r1 == 0) goto L_0x009e
            org.codehaus.jackson.map.deser.EnumMapDeserializer r1 = new org.codehaus.jackson.map.deser.EnumMapDeserializer
            org.codehaus.jackson.map.deser.EnumResolver r0 = r9.constructEnumResolver(r0, r10)
            r1.<init>(r0, r5)
            return r1
        L_0x009e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Can not construct EnumMap; generic (key) type not available"
            r0.<init>(r1)
            throw r0
        L_0x00a6:
            boolean r1 = r14.isInterface()
            if (r1 != 0) goto L_0x00b7
            boolean r1 = r14.isAbstract()
            if (r1 == 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            r13 = r22
        L_0x00b5:
            r2 = r14
            goto L_0x00d4
        L_0x00b7:
            java.util.HashMap<java.lang.String, java.lang.Class<? extends java.util.Map>> r1 = _mapFallbacks
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = r1.get(r0)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x0106
            org.codehaus.jackson.type.JavaType r0 = r14.forcedNarrowBy(r0)
            r14 = r0
            org.codehaus.jackson.map.type.MapType r14 = (org.codehaus.jackson.map.type.MapType) r14
            org.codehaus.jackson.map.BeanDescription r0 = r10.introspectForCreation(r14)
            r13 = r0
            org.codehaus.jackson.map.introspect.BasicBeanDescription r13 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r13
            goto L_0x00b5
        L_0x00d4:
            org.codehaus.jackson.map.DeserializationConfig$Feature r0 = org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r10.isEnabled(r0)
            java.lang.reflect.Constructor r3 = r13.findDefaultConstructor()
            if (r3 == 0) goto L_0x00e5
            if (r0 == 0) goto L_0x00e5
            org.codehaus.jackson.map.util.ClassUtil.checkAndFixAccess(r3)
        L_0x00e5:
            org.codehaus.jackson.map.deser.MapDeserializer r0 = new org.codehaus.jackson.map.deser.MapDeserializer
            r1 = r0
            r4 = r17
            r6 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            org.codehaus.jackson.map.AnnotationIntrospector r1 = r20.getAnnotationIntrospector()
            org.codehaus.jackson.map.introspect.AnnotatedClass r2 = r13.getClassInfo()
            java.lang.String[] r1 = r1.findPropertiesToIgnore(r2)
            r0.setIgnorableProperties(r1)
            org.codehaus.jackson.map.deser.CreatorContainer r1 = r9.findMapCreators(r10, r13)
            r0.setCreators(r1)
            return r0
        L_0x0106:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can not find a deserializer for non-concrete Map type "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.deser.BasicDeserializerFactory.createMapDeserializer(org.codehaus.jackson.map.DeserializationConfig, org.codehaus.jackson.map.DeserializerProvider, org.codehaus.jackson.map.type.MapType, org.codehaus.jackson.map.BeanProperty):org.codehaus.jackson.map.JsonDeserializer");
    }

    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, MapLikeType mapLikeType, BeanProperty beanProperty) throws JsonMappingException {
        MapLikeType mapLikeType2 = (MapLikeType) mapAbstractType(deserializationConfig, mapLikeType);
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspectForCreation(mapLikeType2);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        MapLikeType mapLikeType3 = (MapLikeType) modifyTypeByAnnotation(deserializationConfig, basicBeanDescription.getClassInfo(), mapLikeType2, (String) null);
        JavaType keyType = mapLikeType3.getKeyType();
        JavaType contentType = mapLikeType3.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        KeyDeserializer findKeyDeserializer = keyDeserializer == null ? deserializerProvider.findKeyDeserializer(deserializationConfig, keyType, beanProperty) : keyDeserializer;
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(deserializationConfig, contentType, beanProperty);
        }
        return _findCustomMapLikeDeserializer(mapLikeType3, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, findKeyDeserializer, typeDeserializer, jsonDeserializer);
    }

    public JsonDeserializer<?> createEnumDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspectForCreation(javaType);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> _findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, deserializationConfig, basicBeanDescription, beanProperty);
        if (_findCustomEnumDeserializer != null) {
            return _findCustomEnumDeserializer;
        }
        for (AnnotatedMethod next : basicBeanDescription.getFactoryMethods()) {
            if (deserializationConfig.getAnnotationIntrospector().hasCreatorAnnotation(next)) {
                if (next.getParameterCount() == 1 && next.getRawType().isAssignableFrom(rawClass)) {
                    return EnumDeserializer.deserializerForCreator(deserializationConfig, rawClass, next);
                }
                throw new IllegalArgumentException("Unsuitable method (" + next + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
            }
        }
        return new EnumDeserializer(constructEnumResolver(rawClass, deserializationConfig));
    }

    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> _findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanProperty);
        if (_findCustomTreeNodeDeserializer != null) {
            return _findCustomTreeNodeDeserializer;
        }
        return JsonNodeDeserializer.getDeserializer(rawClass);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findStdBeanDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JavaType javaType2;
        JsonDeserializer<Object> jsonDeserializer = _simpleDeserializers.get(javaType);
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == Class.class) {
            return new StdDeserializer.ClassDeserializer();
        }
        if (AtomicReference.class.isAssignableFrom(rawClass)) {
            JavaType[] findTypeParameters = deserializationConfig.getTypeFactory().findTypeParameters(javaType, (Class<?>) AtomicReference.class);
            if (findTypeParameters == null || findTypeParameters.length < 1) {
                javaType2 = TypeFactory.unknownType();
            } else {
                javaType2 = findTypeParameters[0];
            }
            return new StdDeserializer.AtomicReferenceDeserializer(javaType2, beanProperty);
        }
        JsonDeserializer<?> findDeserializer = this.optionalHandlers.findDeserializer(javaType, deserializationConfig, deserializerProvider);
        if (findDeserializer != null) {
            return findDeserializer;
        }
        return null;
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) {
        AnnotatedClass classInfo = ((BasicBeanDescription) deserializationConfig.introspectClassAnnotations(javaType.getRawClass())).getClassInfo();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findTypeResolver = annotationIntrospector.findTypeResolver(deserializationConfig, classInfo, javaType);
        Collection<NamedType> collection = null;
        if (findTypeResolver == null) {
            findTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            if (findTypeResolver == null) {
                return null;
            }
        } else {
            collection = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(classInfo, (MapperConfig<?>) deserializationConfig, annotationIntrospector);
        }
        return findTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collection, beanProperty);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember, BeanProperty beanProperty) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyTypeResolver = annotationIntrospector.findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType, beanProperty);
        }
        return findPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, (MapperConfig<?>) deserializationConfig, annotationIntrospector), beanProperty);
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember, BeanProperty beanProperty) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyContentTypeResolver = annotationIntrospector.findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        if (findPropertyContentTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, contentType, beanProperty);
        }
        return findPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, (MapperConfig<?>) deserializationConfig, annotationIntrospector), beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationConfig deserializationConfig, Annotated annotated, BeanProperty beanProperty) throws JsonMappingException {
        Object findDeserializer = deserializationConfig.getAnnotationIntrospector().findDeserializer(annotated);
        if (findDeserializer != null) {
            return _constructDeserializer(deserializationConfig, annotated, beanProperty, findDeserializer);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public JsonDeserializer<Object> _constructDeserializer(DeserializationConfig deserializationConfig, Annotated annotated, BeanProperty beanProperty, Object obj) throws JsonMappingException {
        if (obj instanceof JsonDeserializer) {
            JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) obj;
            return jsonDeserializer instanceof ContextualDeserializer ? ((ContextualDeserializer) jsonDeserializer).createContextual(deserializationConfig, beanProperty) : jsonDeserializer;
        } else if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (JsonDeserializer.class.isAssignableFrom(cls)) {
                JsonDeserializer<Object> deserializerInstance = deserializationConfig.deserializerInstance(annotated, cls);
                return deserializerInstance instanceof ContextualDeserializer ? ((ContextualDeserializer) deserializerInstance).createContextual(deserializationConfig, beanProperty) : deserializerInstance;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
        }
    }

    /* access modifiers changed from: protected */
    public <T extends JavaType> T modifyTypeByAnnotation(DeserializationConfig deserializationConfig, Annotated annotated, T t, String str) throws JsonMappingException {
        Class<? extends JsonDeserializer<?>> findContentDeserializer;
        Class<? extends KeyDeserializer> findKeyDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Class<?> findDeserializationType = annotationIntrospector.findDeserializationType(annotated, t, str);
        if (findDeserializationType != null) {
            try {
                t = t.narrowBy(findDeserializationType);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException("Failed to narrow type " + t + " with concrete-type annotation (value " + findDeserializationType.getName() + "), method '" + annotated.getName() + "': " + e.getMessage(), (JsonLocation) null, e);
            }
        }
        if (t.isContainerType()) {
            Class<?> findDeserializationKeyType = annotationIntrospector.findDeserializationKeyType(annotated, t.getKeyType(), str);
            if (findDeserializationKeyType != null) {
                if (t instanceof MapType) {
                    try {
                        t = ((MapType) t).narrowKey(findDeserializationKeyType);
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException("Failed to narrow key type " + t + " with key-type annotation (" + findDeserializationKeyType.getName() + "): " + e2.getMessage(), (JsonLocation) null, e2);
                    }
                } else {
                    throw new JsonMappingException("Illegal key-type annotation: type " + t + " is not a Map type");
                }
            }
            JavaType keyType = t.getKeyType();
            if (!(keyType == null || keyType.getValueHandler() != null || (findKeyDeserializer = annotationIntrospector.findKeyDeserializer(annotated)) == null || findKeyDeserializer == KeyDeserializer.None.class)) {
                keyType.setValueHandler(deserializationConfig.keyDeserializerInstance(annotated, findKeyDeserializer));
            }
            Class<?> findDeserializationContentType = annotationIntrospector.findDeserializationContentType(annotated, t.getContentType(), str);
            if (findDeserializationContentType != null) {
                try {
                    t = t.narrowContentsBy(findDeserializationContentType);
                } catch (IllegalArgumentException e3) {
                    throw new JsonMappingException("Failed to narrow content type " + t + " with content-type annotation (" + findDeserializationContentType.getName() + "): " + e3.getMessage(), (JsonLocation) null, e3);
                }
            }
            if (!(t.getContentType().getValueHandler() != null || (findContentDeserializer = annotationIntrospector.findContentDeserializer(annotated)) == null || findContentDeserializer == JsonDeserializer.None.class)) {
                t.getContentType().setValueHandler(deserializationConfig.deserializerInstance(annotated, findContentDeserializer));
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public JavaType resolveType(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, JavaType javaType, AnnotatedMember annotatedMember, BeanProperty beanProperty) {
        TypeDeserializer typeDeserializer;
        TypeDeserializer findPropertyContentTypeDeserializer;
        Class<? extends KeyDeserializer> findKeyDeserializer;
        if (javaType.isContainerType()) {
            AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
            JavaType keyType = javaType.getKeyType();
            if (!(keyType == null || (findKeyDeserializer = annotationIntrospector.findKeyDeserializer(annotatedMember)) == null || findKeyDeserializer == KeyDeserializer.None.class)) {
                keyType.setValueHandler(deserializationConfig.keyDeserializerInstance(annotatedMember, findKeyDeserializer));
            }
            Class<? extends JsonDeserializer<?>> findContentDeserializer = annotationIntrospector.findContentDeserializer(annotatedMember);
            if (!(findContentDeserializer == null || findContentDeserializer == JsonDeserializer.None.class)) {
                javaType.getContentType().setValueHandler(deserializationConfig.deserializerInstance(annotatedMember, findContentDeserializer));
            }
            if ((annotatedMember instanceof AnnotatedMember) && (findPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationConfig, javaType, annotatedMember, beanProperty)) != null) {
                javaType = javaType.withContentTypeHandler(findPropertyContentTypeDeserializer);
            }
        }
        if (annotatedMember instanceof AnnotatedMember) {
            typeDeserializer = findPropertyTypeDeserializer(deserializationConfig, javaType, annotatedMember, beanProperty);
        } else {
            typeDeserializer = findTypeDeserializer(deserializationConfig, javaType, (BeanProperty) null);
        }
        return typeDeserializer != null ? javaType.withTypeHandler(typeDeserializer) : javaType;
    }

    /* access modifiers changed from: protected */
    public EnumResolver<?> constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING)) {
            return EnumResolver.constructUnsafeUsingToString(cls);
        }
        return EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
    }

    /* access modifiers changed from: protected */
    public CreatorContainer findMapCreators(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription) throws JsonMappingException {
        String str;
        String str2;
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        BasicBeanDescription basicBeanDescription2 = basicBeanDescription;
        CreatorContainer creatorContainer = new CreatorContainer(basicBeanDescription2, deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        for (AnnotatedConstructor next : basicBeanDescription.getConstructors()) {
            int parameterCount = next.getParameterCount();
            if (parameterCount >= 1 && annotationIntrospector.hasCreatorAnnotation(next)) {
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                int i = 0;
                while (i < parameterCount) {
                    AnnotatedParameter parameter = next.getParameter(i);
                    if (parameter == null) {
                        str2 = null;
                    } else {
                        str2 = annotationIntrospector.findPropertyNameForParam(parameter);
                    }
                    if (str2 == null || str2.length() == 0) {
                        throw new IllegalArgumentException("Parameter #" + i + " of constructor " + next + " has no property name annotation: must have for @JsonCreator for a Map type");
                    }
                    AnnotatedParameter annotatedParameter = parameter;
                    String str3 = str2;
                    settableBeanPropertyArr[i] = constructCreatorProperty(deserializationConfig, basicBeanDescription, str3, i, annotatedParameter);
                    i++;
                    next = next;
                    parameterCount = parameterCount;
                }
                creatorContainer.addPropertyConstructor(next, settableBeanPropertyArr);
            }
        }
        for (AnnotatedMethod next2 : basicBeanDescription.getFactoryMethods()) {
            int parameterCount2 = next2.getParameterCount();
            if (parameterCount2 >= 1 && annotationIntrospector.hasCreatorAnnotation(next2)) {
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount2];
                int i2 = 0;
                while (i2 < parameterCount2) {
                    AnnotatedParameter parameter2 = next2.getParameter(i2);
                    if (parameter2 == null) {
                        str = null;
                    } else {
                        str = annotationIntrospector.findPropertyNameForParam(parameter2);
                    }
                    if (str == null || str.length() == 0) {
                        throw new IllegalArgumentException("Parameter #" + i2 + " of factory method " + next2 + " has no property name annotation: must have for @JsonCreator for a Map type");
                    }
                    int i3 = i2;
                    SettableBeanProperty[] settableBeanPropertyArr3 = settableBeanPropertyArr2;
                    int i4 = i3;
                    settableBeanPropertyArr3[i4] = constructCreatorProperty(deserializationConfig, basicBeanDescription, str, i3, parameter2);
                    i2 = i4 + 1;
                    settableBeanPropertyArr2 = settableBeanPropertyArr3;
                    parameterCount2 = parameterCount2;
                }
                creatorContainer.addPropertyFactory(next2, settableBeanPropertyArr2);
            }
        }
        return creatorContainer;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructCreatorProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, int i, AnnotatedParameter annotatedParameter) throws JsonMappingException {
        JavaType constructType = deserializationConfig.getTypeFactory().constructType(annotatedParameter.getParameterType(), basicBeanDescription.bindingsForBeanType());
        BeanProperty.Std std = new BeanProperty.Std(str, constructType, basicBeanDescription.getClassAnnotations(), annotatedParameter);
        JavaType resolveType = resolveType(deserializationConfig, basicBeanDescription, constructType, annotatedParameter, std);
        if (resolveType != constructType) {
            std = std.withType(resolveType);
        }
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedParameter, std);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedParameter, resolveType, str);
        SettableBeanProperty.CreatorProperty creatorProperty = new SettableBeanProperty.CreatorProperty(str, modifyTypeByAnnotation, findTypeDeserializer(deserializationConfig, modifyTypeByAnnotation, std), basicBeanDescription.getClassAnnotations(), annotatedParameter, i);
        if (findDeserializerFromAnnotation != null) {
            creatorProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        return creatorProperty;
    }
}
