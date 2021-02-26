package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanDeserializerFactory extends BasicDeserializerFactory {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory((DeserializerFactory.Config) null);
    protected final DeserializerFactory.Config _factoryConfig;

    public static class ConfigImpl extends DeserializerFactory.Config {
        protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
        protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
        protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
        protected final AbstractTypeResolver[] _abstractTypeResolvers;
        protected final Deserializers[] _additionalDeserializers;
        protected final KeyDeserializers[] _additionalKeyDeserializers;
        protected final BeanDeserializerModifier[] _modifiers;

        public ConfigImpl() {
            this((Deserializers[]) null, (KeyDeserializers[]) null, (BeanDeserializerModifier[]) null, (AbstractTypeResolver[]) null);
        }

        protected ConfigImpl(Deserializers[] deserializersArr, KeyDeserializers[] keyDeserializersArr, BeanDeserializerModifier[] beanDeserializerModifierArr, AbstractTypeResolver[] abstractTypeResolverArr) {
            this._additionalDeserializers = deserializersArr == null ? BeanDeserializerFactory.NO_DESERIALIZERS : deserializersArr;
            this._additionalKeyDeserializers = keyDeserializersArr == null ? NO_KEY_DESERIALIZERS : keyDeserializersArr;
            this._modifiers = beanDeserializerModifierArr == null ? NO_MODIFIERS : beanDeserializerModifierArr;
            this._abstractTypeResolvers = abstractTypeResolverArr == null ? NO_ABSTRACT_TYPE_RESOLVERS : abstractTypeResolverArr;
        }

        public DeserializerFactory.Config withAdditionalDeserializers(Deserializers deserializers) {
            if (deserializers != null) {
                return new ConfigImpl((Deserializers[]) ArrayBuilders.insertInListNoDup(this._additionalDeserializers, deserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers);
            }
            throw new IllegalArgumentException("Can not pass null Deserializers");
        }

        public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
            if (keyDeserializers != null) {
                return new ConfigImpl(this._additionalDeserializers, (KeyDeserializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, keyDeserializers), this._modifiers, this._abstractTypeResolvers);
            }
            throw new IllegalArgumentException("Can not pass null KeyDeserializers");
        }

        public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
            if (beanDeserializerModifier != null) {
                return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, (BeanDeserializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, beanDeserializerModifier), this._abstractTypeResolvers);
            }
            throw new IllegalArgumentException("Can not pass null modifier");
        }

        public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
            if (abstractTypeResolver != null) {
                return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, (AbstractTypeResolver[]) ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, abstractTypeResolver));
            }
            throw new IllegalArgumentException("Can not pass null resolver");
        }

        public boolean hasDeserializers() {
            return this._additionalDeserializers.length > 0;
        }

        public boolean hasKeyDeserializers() {
            return this._additionalKeyDeserializers.length > 0;
        }

        public boolean hasDeserializerModifiers() {
            return this._modifiers.length > 0;
        }

        public boolean hasAbstractTypeResolvers() {
            return this._abstractTypeResolvers.length > 0;
        }

        public Iterable<Deserializers> deserializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalDeserializers);
        }

        public Iterable<KeyDeserializers> keyDeserializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
        }

        public Iterable<BeanDeserializerModifier> deserializerModifiers() {
            return ArrayBuilders.arrayAsIterable(this._modifiers);
        }

        public Iterable<AbstractTypeResolver> abstractTypeResolvers() {
            return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
        }
    }

    @Deprecated
    public BeanDeserializerFactory() {
        this((DeserializerFactory.Config) null);
    }

    public BeanDeserializerFactory(DeserializerFactory.Config config) {
        this._factoryConfig = config == null ? new ConfigImpl() : config;
    }

    public final DeserializerFactory.Config getConfig() {
        return this._factoryConfig;
    }

    public DeserializerFactory withConfig(DeserializerFactory.Config config) {
        if (this._factoryConfig == config) {
            return this;
        }
        if (getClass() == BeanDeserializerFactory.class) {
            return new BeanDeserializerFactory(config);
        }
        throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
    }

    public KeyDeserializer createKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (!this._factoryConfig.hasKeyDeserializers()) {
            return null;
        }
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspectClassAnnotations(javaType.getRawClass());
        for (KeyDeserializers findKeyDeserializer : this._factoryConfig.keyDeserializers()) {
            KeyDeserializer findKeyDeserializer2 = findKeyDeserializer.findKeyDeserializer(javaType, deserializationConfig, basicBeanDescription, beanProperty);
            if (findKeyDeserializer2 != null) {
                return findKeyDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findArrayDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findArrayDeserializer2 = findArrayDeserializer.findArrayDeserializer(arrayType, deserializationConfig, deserializerProvider, beanProperty, typeDeserializer, jsonDeserializer);
            if (findArrayDeserializer2 != null) {
                return findArrayDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findCollectionDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionDeserializer2 = findCollectionDeserializer.findCollectionDeserializer(collectionType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer, jsonDeserializer);
            if (findCollectionDeserializer2 != null) {
                return findCollectionDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findCollectionLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionLikeDeserializer2 = findCollectionLikeDeserializer.findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer, jsonDeserializer);
            if (findCollectionLikeDeserializer2 != null) {
                return findCollectionLikeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        for (Deserializers findEnumDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findEnumDeserializer2 = findEnumDeserializer.findEnumDeserializer(cls, deserializationConfig, basicBeanDescription, beanProperty);
            if (findEnumDeserializer2 != null) {
                return findEnumDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findMapDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapDeserializer2 = findMapDeserializer.findMapDeserializer(mapType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapDeserializer2 != null) {
                return findMapDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findMapLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapLikeDeserializer2 = findMapLikeDeserializer.findMapLikeDeserializer(mapLikeType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapLikeDeserializer2 != null) {
                return findMapLikeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanProperty beanProperty) throws JsonMappingException {
        for (Deserializers findTreeNodeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findTreeNodeDeserializer2 = findTreeNodeDeserializer.findTreeNodeDeserializer(cls, deserializationConfig, beanProperty);
            if (findTreeNodeDeserializer2 != null) {
                return findTreeNodeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        for (Deserializers findBeanDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findBeanDeserializer2 = findBeanDeserializer.findBeanDeserializer(javaType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty);
            if (findBeanDeserializer2 != null) {
                return findBeanDeserializer2;
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r12v3, types: [org.codehaus.jackson.map.BeanDescription] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.JsonDeserializer<java.lang.Object> createBeanDeserializer(org.codehaus.jackson.map.DeserializationConfig r10, org.codehaus.jackson.map.DeserializerProvider r11, org.codehaus.jackson.type.JavaType r12, org.codehaus.jackson.map.BeanProperty r13) throws org.codehaus.jackson.map.JsonMappingException {
        /*
            r9 = this;
            boolean r0 = r12.isAbstract()
            if (r0 == 0) goto L_0x000a
            org.codehaus.jackson.type.JavaType r12 = r9.mapAbstractType(r10, r12)
        L_0x000a:
            org.codehaus.jackson.map.BeanDescription r0 = r10.introspect(r12)
            org.codehaus.jackson.map.introspect.BasicBeanDescription r0 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r0
            org.codehaus.jackson.map.introspect.AnnotatedClass r1 = r0.getClassInfo()
            org.codehaus.jackson.map.JsonDeserializer r1 = r9.findDeserializerFromAnnotation(r10, r1, r13)
            if (r1 == 0) goto L_0x001b
            return r1
        L_0x001b:
            org.codehaus.jackson.map.introspect.AnnotatedClass r1 = r0.getClassInfo()
            r2 = 0
            org.codehaus.jackson.type.JavaType r1 = r9.modifyTypeByAnnotation(r10, r1, r12, r2)
            java.lang.Class r3 = r1.getRawClass()
            java.lang.Class r4 = r12.getRawClass()
            if (r3 == r4) goto L_0x0036
            org.codehaus.jackson.map.BeanDescription r12 = r10.introspect(r1)
            r0 = r12
            org.codehaus.jackson.map.introspect.BasicBeanDescription r0 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r0
            r12 = r1
        L_0x0036:
            r3 = r9
            r4 = r12
            r5 = r10
            r6 = r11
            r7 = r0
            r8 = r13
            org.codehaus.jackson.map.JsonDeserializer r1 = r3._findCustomBeanDeserializer(r4, r5, r6, r7, r8)
            if (r1 == 0) goto L_0x0043
            return r1
        L_0x0043:
            boolean r1 = r12.isThrowable()
            if (r1 == 0) goto L_0x004e
            org.codehaus.jackson.map.JsonDeserializer r10 = r9.buildThrowableDeserializer(r10, r12, r0, r13)
            return r10
        L_0x004e:
            boolean r1 = r12.isAbstract()
            if (r1 == 0) goto L_0x0065
            org.codehaus.jackson.type.JavaType r1 = r9.materializeAbstractType(r10, r0)
            if (r1 == 0) goto L_0x0065
            org.codehaus.jackson.map.BeanDescription r11 = r10.introspect(r1)
            org.codehaus.jackson.map.introspect.BasicBeanDescription r11 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r11
            org.codehaus.jackson.map.JsonDeserializer r10 = r9.buildBeanDeserializer(r10, r1, r11, r13)
            return r10
        L_0x0065:
            org.codehaus.jackson.map.JsonDeserializer r11 = r9.findStdBeanDeserializer(r10, r11, r12, r13)
            if (r11 == 0) goto L_0x006c
            return r11
        L_0x006c:
            java.lang.Class r11 = r12.getRawClass()
            boolean r11 = r9.isPotentialBeanType(r11)
            if (r11 != 0) goto L_0x0077
            return r2
        L_0x0077:
            org.codehaus.jackson.map.JsonDeserializer r10 = r9.buildBeanDeserializer(r10, r12, r0, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.deser.BeanDeserializerFactory.createBeanDeserializer(org.codehaus.jackson.map.DeserializationConfig, org.codehaus.jackson.map.DeserializerProvider, org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.BeanProperty):org.codehaus.jackson.map.JsonDeserializer");
    }

    /* access modifiers changed from: protected */
    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType _mapAbstractType2;
        while (true) {
            _mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = _mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
            } else {
                javaType = _mapAbstractType2;
            }
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + _mapAbstractType2 + ": latter is not a subtype of former");
    }

    /* access modifiers changed from: protected */
    public JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType findTypeMapping;
        Class<?> rawClass = javaType.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver findTypeMapping2 : this._factoryConfig.abstractTypeResolvers()) {
                JavaType findTypeMapping3 = findTypeMapping2.findTypeMapping(deserializationConfig, javaType);
                if (findTypeMapping3 != null && findTypeMapping3.getRawClass() != rawClass) {
                    return findTypeMapping3;
                }
            }
        }
        AbstractTypeResolver abstractTypeResolver = deserializationConfig.getAbstractTypeResolver();
        if (abstractTypeResolver == null || (findTypeMapping = abstractTypeResolver.findTypeMapping(deserializationConfig, javaType)) == null || findTypeMapping.getRawClass() == rawClass) {
            return null;
        }
        return findTypeMapping;
    }

    /* access modifiers changed from: protected */
    public JavaType materializeAbstractType(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription) throws JsonMappingException {
        JavaType resolveAbstractType;
        AbstractTypeResolver abstractTypeResolver = deserializationConfig.getAbstractTypeResolver();
        if (abstractTypeResolver == null && !this._factoryConfig.hasAbstractTypeResolvers()) {
            return null;
        }
        JavaType type = basicBeanDescription.getType();
        if (deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, basicBeanDescription.getClassInfo(), type) != null) {
            return null;
        }
        if (abstractTypeResolver != null && (resolveAbstractType = abstractTypeResolver.resolveAbstractType(deserializationConfig, type)) != null) {
            return resolveAbstractType;
        }
        for (AbstractTypeResolver resolveAbstractType2 : this._factoryConfig.abstractTypeResolvers()) {
            JavaType resolveAbstractType3 = resolveAbstractType2.resolveAbstractType(deserializationConfig, type);
            if (resolveAbstractType3 != null) {
                return resolveAbstractType3;
            }
        }
        return null;
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType.isAbstract()) {
            return new AbstractDeserializer(javaType);
        }
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(basicBeanDescription);
        constructBeanDeserializerBuilder.setCreators(findDeserializerCreators(deserializationConfig, basicBeanDescription));
        addBeanProps(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        addReferenceProperties(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier updateBuilder : this._factoryConfig.deserializerModifiers()) {
                constructBeanDeserializerBuilder = updateBuilder.updateBuilder(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> build = constructBeanDeserializerBuilder.build(beanProperty);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                build = modifyDeserializer.modifyDeserializer(deserializationConfig, basicBeanDescription, build);
            }
        }
        return build;
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        SettableBeanProperty constructSettableProperty;
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(basicBeanDescription);
        constructBeanDeserializerBuilder.setCreators(findDeserializerCreators(deserializationConfig, basicBeanDescription));
        addBeanProps(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        AnnotatedMethod findMethod = basicBeanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (!(findMethod == null || (constructSettableProperty = constructSettableProperty(deserializationConfig, basicBeanDescription, "cause", findMethod)) == null)) {
            constructBeanDeserializerBuilder.addProperty(constructSettableProperty);
        }
        constructBeanDeserializerBuilder.addIgnorable("localizedMessage");
        constructBeanDeserializerBuilder.addIgnorable("message");
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier updateBuilder : this._factoryConfig.deserializerModifiers()) {
                constructBeanDeserializerBuilder = updateBuilder.updateBuilder(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> build = constructBeanDeserializerBuilder.build(beanProperty);
        if (build instanceof BeanDeserializer) {
            build = new ThrowableDeserializer((BeanDeserializer) build);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                build = modifyDeserializer.modifyDeserializer(deserializationConfig, basicBeanDescription, build);
            }
        }
        return build;
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBuilder constructBeanDeserializerBuilder(BasicBeanDescription basicBeanDescription) {
        return new BeanDeserializerBuilder(basicBeanDescription);
    }

    /* access modifiers changed from: protected */
    public CreatorContainer findDeserializerCreators(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription) throws JsonMappingException {
        Constructor<?> findDefaultConstructor;
        boolean isEnabled = deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
        CreatorContainer creatorContainer = new CreatorContainer(basicBeanDescription, isEnabled);
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        if (basicBeanDescription.getType().isConcrete() && (findDefaultConstructor = basicBeanDescription.findDefaultConstructor()) != null) {
            if (isEnabled) {
                ClassUtil.checkAndFixAccess(findDefaultConstructor);
            }
            creatorContainer.setDefaultConstructor(findDefaultConstructor);
        }
        VisibilityChecker defaultVisibilityChecker = deserializationConfig.getDefaultVisibilityChecker();
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_CREATORS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withCreatorVisibility(JsonAutoDetect.Visibility.NONE);
        }
        DeserializationConfig deserializationConfig2 = deserializationConfig;
        BasicBeanDescription basicBeanDescription2 = basicBeanDescription;
        VisibilityChecker<?> findAutoDetectVisibility = deserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(basicBeanDescription.getClassInfo(), defaultVisibilityChecker);
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        CreatorContainer creatorContainer2 = creatorContainer;
        _addDeserializerConstructors(deserializationConfig2, basicBeanDescription2, findAutoDetectVisibility, annotationIntrospector2, creatorContainer2);
        _addDeserializerFactoryMethods(deserializationConfig2, basicBeanDescription2, findAutoDetectVisibility, annotationIntrospector2, creatorContainer2);
        return creatorContainer;
    }

    /* access modifiers changed from: protected */
    public void _addDeserializerConstructors(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorContainer creatorContainer) throws JsonMappingException {
        String str;
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        CreatorContainer creatorContainer2 = creatorContainer;
        for (AnnotatedConstructor next : basicBeanDescription.getConstructors()) {
            int parameterCount = next.getParameterCount();
            if (parameterCount >= 1) {
                boolean hasCreatorAnnotation = annotationIntrospector2.hasCreatorAnnotation(next);
                boolean isCreatorVisible = visibilityChecker.isCreatorVisible((AnnotatedMember) next);
                if (parameterCount == 1) {
                    AnnotatedParameter parameter = next.getParameter(0);
                    String findPropertyNameForParam = annotationIntrospector2.findPropertyNameForParam(parameter);
                    if (findPropertyNameForParam == null || findPropertyNameForParam.length() == 0) {
                        Class<?> parameterClass = next.getParameterClass(0);
                        if (parameterClass == String.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer2.addStringConstructor(next);
                            }
                        } else if (parameterClass == Integer.TYPE || parameterClass == Integer.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer2.addIntConstructor(next);
                            }
                        } else if (parameterClass == Long.TYPE || parameterClass == Long.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer2.addLongConstructor(next);
                            }
                        } else if (hasCreatorAnnotation) {
                            creatorContainer2.addDelegatingConstructor(next);
                        }
                    } else {
                        creatorContainer2.addPropertyConstructor(next, new SettableBeanProperty[]{constructCreatorProperty(deserializationConfig, basicBeanDescription, findPropertyNameForParam, 0, parameter)});
                    }
                } else if (hasCreatorAnnotation || isCreatorVisible) {
                    SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                    boolean z = false;
                    boolean z2 = false;
                    int i = 0;
                    while (i < parameterCount) {
                        AnnotatedParameter parameter2 = next.getParameter(i);
                        if (parameter2 == null) {
                            str = null;
                        } else {
                            str = annotationIntrospector2.findPropertyNameForParam(parameter2);
                        }
                        String str2 = str;
                        boolean z3 = z2 | (str2 == null || str2.length() == 0);
                        boolean z4 = z | (!z3);
                        if (!z3 || (!z4 && !hasCreatorAnnotation)) {
                            int i2 = i;
                            settableBeanPropertyArr[i2] = constructCreatorProperty(deserializationConfig, basicBeanDescription, str2, i, parameter2);
                            i = i2 + 1;
                            z2 = z3;
                            z = z4;
                        } else {
                            throw new IllegalArgumentException("Argument #" + i + " of constructor " + next + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                        }
                    }
                    if (z) {
                        creatorContainer2.addPropertyConstructor(next, settableBeanPropertyArr);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addDeserializerFactoryMethods(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorContainer creatorContainer) throws JsonMappingException {
        VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        CreatorContainer creatorContainer2 = creatorContainer;
        for (AnnotatedMethod next : basicBeanDescription.getFactoryMethods()) {
            int parameterCount = next.getParameterCount();
            if (parameterCount >= 1) {
                boolean hasCreatorAnnotation = annotationIntrospector2.hasCreatorAnnotation(next);
                if (parameterCount == 1) {
                    String findPropertyNameForParam = annotationIntrospector2.findPropertyNameForParam(next.getParameter(0));
                    if (findPropertyNameForParam == null || findPropertyNameForParam.length() == 0) {
                        Class<?> parameterClass = next.getParameterClass(0);
                        if (parameterClass == String.class) {
                            if (hasCreatorAnnotation || visibilityChecker2.isCreatorVisible((AnnotatedMember) next)) {
                                creatorContainer2.addStringFactory(next);
                            }
                        } else if (parameterClass == Integer.TYPE || parameterClass == Integer.class) {
                            if (hasCreatorAnnotation || visibilityChecker2.isCreatorVisible((AnnotatedMember) next)) {
                                creatorContainer2.addIntFactory(next);
                            }
                        } else if (parameterClass == Long.TYPE || parameterClass == Long.class) {
                            if (hasCreatorAnnotation || visibilityChecker2.isCreatorVisible((AnnotatedMember) next)) {
                                creatorContainer2.addLongFactory(next);
                            }
                        } else if (annotationIntrospector2.hasCreatorAnnotation(next)) {
                            creatorContainer2.addDelegatingFactory(next);
                        }
                    }
                } else if (!annotationIntrospector2.hasCreatorAnnotation(next)) {
                    continue;
                }
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                for (int i = 0; i < parameterCount; i++) {
                    AnnotatedParameter parameter = next.getParameter(i);
                    String findPropertyNameForParam2 = annotationIntrospector2.findPropertyNameForParam(parameter);
                    if (findPropertyNameForParam2 == null || findPropertyNameForParam2.length() == 0) {
                        throw new IllegalArgumentException("Argument #" + i + " of factory method " + next + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
                    }
                    settableBeanPropertyArr[i] = constructCreatorProperty(deserializationConfig, basicBeanDescription, findPropertyNameForParam2, i, parameter);
                }
                creatorContainer2.addPropertyFactory(next, settableBeanPropertyArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addBeanProps(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        VisibilityChecker defaultVisibilityChecker = deserializationConfig.getDefaultVisibilityChecker();
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_SETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withSetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_FIELDS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> findAutoDetectVisibility = deserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(basicBeanDescription.getClassInfo(), defaultVisibilityChecker);
        LinkedHashMap<String, AnnotatedMethod> findSetters = basicBeanDescription.findSetters(findAutoDetectVisibility);
        AnnotatedMethod findAnySetter = basicBeanDescription.findAnySetter();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Boolean findIgnoreUnknownProperties = annotationIntrospector.findIgnoreUnknownProperties(basicBeanDescription.getClassInfo());
        if (findIgnoreUnknownProperties != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(findIgnoreUnknownProperties.booleanValue());
        }
        HashSet arrayToSet = ArrayBuilders.arrayToSet(annotationIntrospector.findPropertiesToIgnore(basicBeanDescription.getClassInfo()));
        Iterator it = arrayToSet.iterator();
        while (it.hasNext()) {
            beanDeserializerBuilder.addIgnorable((String) it.next());
        }
        AnnotatedClass classInfo = basicBeanDescription.getClassInfo();
        for (AnnotatedMethod okNameForSetter : classInfo.ignoredMemberMethods()) {
            String okNameForSetter2 = basicBeanDescription.okNameForSetter(okNameForSetter);
            if (okNameForSetter2 != null) {
                beanDeserializerBuilder.addIgnorable(okNameForSetter2);
            }
        }
        for (AnnotatedField name : classInfo.ignoredFields()) {
            beanDeserializerBuilder.addIgnorable(name.getName());
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : findSetters.entrySet()) {
            String str = (String) next.getKey();
            if (!arrayToSet.contains(str)) {
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) next.getValue();
                if (isIgnorableType(deserializationConfig, basicBeanDescription, annotatedMethod.getParameterClass(0), hashMap)) {
                    beanDeserializerBuilder.addIgnorable(str);
                } else {
                    SettableBeanProperty constructSettableProperty = constructSettableProperty(deserializationConfig, basicBeanDescription, str, annotatedMethod);
                    if (constructSettableProperty != null) {
                        beanDeserializerBuilder.addProperty(constructSettableProperty);
                    }
                }
            }
        }
        if (findAnySetter != null) {
            beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationConfig, basicBeanDescription, findAnySetter));
        }
        HashSet hashSet = new HashSet(findSetters.keySet());
        for (Map.Entry next2 : basicBeanDescription.findDeserializableFields(findAutoDetectVisibility, hashSet).entrySet()) {
            String str2 = (String) next2.getKey();
            if (!arrayToSet.contains(str2) && !beanDeserializerBuilder.hasProperty(str2)) {
                AnnotatedField annotatedField = (AnnotatedField) next2.getValue();
                if (isIgnorableType(deserializationConfig, basicBeanDescription, annotatedField.getRawType(), hashMap)) {
                    beanDeserializerBuilder.addIgnorable(str2);
                } else {
                    SettableBeanProperty constructSettableProperty2 = constructSettableProperty(deserializationConfig, basicBeanDescription, str2, annotatedField);
                    if (constructSettableProperty2 != null) {
                        beanDeserializerBuilder.addProperty(constructSettableProperty2);
                        hashSet.add(str2);
                    }
                }
            }
        }
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS)) {
            for (Map.Entry next3 : basicBeanDescription.findGetters(findAutoDetectVisibility, hashSet).entrySet()) {
                AnnotatedMethod annotatedMethod2 = (AnnotatedMethod) next3.getValue();
                Class<?> rawType = annotatedMethod2.getRawType();
                if (Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType)) {
                    String str3 = (String) next3.getKey();
                    if (!arrayToSet.contains(str3) && !beanDeserializerBuilder.hasProperty(str3)) {
                        beanDeserializerBuilder.addProperty(constructSetterlessProperty(deserializationConfig, basicBeanDescription, str3, annotatedMethod2));
                        hashSet.add(str3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addReferenceProperties(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Map<String, AnnotatedMember> findBackReferenceProperties = basicBeanDescription.findBackReferenceProperties();
        if (findBackReferenceProperties != null) {
            for (Map.Entry next : findBackReferenceProperties.entrySet()) {
                String str = (String) next.getKey();
                AnnotatedMember annotatedMember = (AnnotatedMember) next.getValue();
                if (annotatedMember instanceof AnnotatedMethod) {
                    beanDeserializerBuilder.addBackReferenceProperty(str, constructSettableProperty(deserializationConfig, basicBeanDescription, annotatedMember.getName(), (AnnotatedMethod) annotatedMember));
                } else {
                    beanDeserializerBuilder.addBackReferenceProperty(str, constructSettableProperty(deserializationConfig, basicBeanDescription, annotatedMember.getName(), (AnnotatedField) annotatedMember));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public SettableAnyProperty constructAnySetter(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, AnnotatedMethod annotatedMethod) throws JsonMappingException {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedMethod.getParameterType(1));
        BeanProperty.Std std = new BeanProperty.Std(annotatedMethod.getName(), resolveType, basicBeanDescription.getClassAnnotations(), annotatedMethod);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedMethod, std);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, std);
        if (findDeserializerFromAnnotation == null) {
            return new SettableAnyProperty(std, annotatedMethod, modifyTypeByAnnotation(deserializationConfig, annotatedMethod, resolveType2, std.getName()));
        }
        SettableAnyProperty settableAnyProperty = new SettableAnyProperty(std, annotatedMethod, resolveType2);
        settableAnyProperty.setValueDeserializer(findDeserializerFromAnnotation);
        return settableAnyProperty;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedMethod annotatedMethod) throws JsonMappingException {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedMethod.getParameterType(0));
        BeanProperty.Std std = new BeanProperty.Std(str, resolveType, basicBeanDescription.getClassAnnotations(), annotatedMethod);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedMethod, std);
        if (resolveType2 != resolveType) {
            std = std.withType(resolveType2);
        }
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, std);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedMethod, resolveType2, str);
        SettableBeanProperty.MethodProperty methodProperty = new SettableBeanProperty.MethodProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedMethod);
        if (findDeserializerFromAnnotation != null) {
            methodProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        AnnotationIntrospector.ReferenceProperty findReferenceType = deserializationConfig.getAnnotationIntrospector().findReferenceType(annotatedMethod);
        if (findReferenceType != null && findReferenceType.isManagedReference()) {
            methodProperty.setManagedReferenceName(findReferenceType.getName());
        }
        return methodProperty;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedField annotatedField) throws JsonMappingException {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedField.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedField.getGenericType());
        BeanProperty.Std std = new BeanProperty.Std(str, resolveType, basicBeanDescription.getClassAnnotations(), annotatedField);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedField, std);
        if (resolveType2 != resolveType) {
            std = std.withType(resolveType2);
        }
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedField, std);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedField, resolveType2, str);
        SettableBeanProperty.FieldProperty fieldProperty = new SettableBeanProperty.FieldProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedField);
        if (findDeserializerFromAnnotation != null) {
            fieldProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        AnnotationIntrospector.ReferenceProperty findReferenceType = deserializationConfig.getAnnotationIntrospector().findReferenceType(annotatedField);
        if (findReferenceType != null && findReferenceType.isManagedReference()) {
            fieldProperty.setManagedReferenceName(findReferenceType.getName());
        }
        return fieldProperty;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSetterlessProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedMethod annotatedMethod) throws JsonMappingException {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType type = annotatedMethod.getType(basicBeanDescription.bindingsForBeanType());
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, new BeanProperty.Std(str, type, basicBeanDescription.getClassAnnotations(), annotatedMethod));
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedMethod, type, str);
        SettableBeanProperty.SetterlessProperty setterlessProperty = new SettableBeanProperty.SetterlessProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedMethod);
        if (findDeserializerFromAnnotation != null) {
            setterlessProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        return setterlessProperty;
    }

    /* access modifiers changed from: protected */
    public boolean isPotentialBeanType(Class<?> cls) {
        String canBeABeanType = ClassUtil.canBeABeanType(cls);
        if (canBeABeanType != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + canBeABeanType + ") as a Bean");
        } else if (!ClassUtil.isProxyType(cls)) {
            String isLocalType = ClassUtil.isLocalType(cls);
            if (isLocalType == null) {
                return true;
            }
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + isLocalType + ") as a Bean");
        } else {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isIgnorableType(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = map.get(cls);
        if (bool == null && (bool = deserializationConfig.getAnnotationIntrospector().isIgnorableType(((BasicBeanDescription) deserializationConfig.introspectClassAnnotations(cls)).getClassInfo())) == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }
}
