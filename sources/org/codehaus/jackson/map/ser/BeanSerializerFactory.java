package org.codehaus.jackson.map.ser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializerFactory extends BasicSerializerFactory {
    public static final BeanSerializerFactory instance = new BeanSerializerFactory((SerializerFactory.Config) null);
    protected final SerializerFactory.Config _factoryConfig;

    public static class ConfigImpl extends SerializerFactory.Config {
        protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
        protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
        protected final Serializers[] _additionalKeySerializers;
        protected final Serializers[] _additionalSerializers;
        protected final BeanSerializerModifier[] _modifiers;

        public ConfigImpl() {
            this((Serializers[]) null, (Serializers[]) null, (BeanSerializerModifier[]) null);
        }

        protected ConfigImpl(Serializers[] serializersArr, Serializers[] serializersArr2, BeanSerializerModifier[] beanSerializerModifierArr) {
            this._additionalSerializers = serializersArr == null ? NO_SERIALIZERS : serializersArr;
            this._additionalKeySerializers = serializersArr2 == null ? NO_SERIALIZERS : serializersArr2;
            this._modifiers = beanSerializerModifierArr == null ? NO_MODIFIERS : beanSerializerModifierArr;
        }

        public SerializerFactory.Config withAdditionalSerializers(Serializers serializers) {
            if (serializers != null) {
                return new ConfigImpl((Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalSerializers, serializers), this._additionalKeySerializers, this._modifiers);
            }
            throw new IllegalArgumentException("Can not pass null Serializers");
        }

        public SerializerFactory.Config withAdditionalKeySerializers(Serializers serializers) {
            if (serializers != null) {
                return new ConfigImpl(this._additionalSerializers, (Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeySerializers, serializers), this._modifiers);
            }
            throw new IllegalArgumentException("Can not pass null Serializers");
        }

        public SerializerFactory.Config withSerializerModifier(BeanSerializerModifier beanSerializerModifier) {
            if (beanSerializerModifier != null) {
                return new ConfigImpl(this._additionalSerializers, this._additionalKeySerializers, (BeanSerializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, beanSerializerModifier));
            }
            throw new IllegalArgumentException("Can not pass null modifier");
        }

        public boolean hasSerializers() {
            return this._additionalSerializers.length > 0;
        }

        public boolean hasKeySerializers() {
            return this._additionalKeySerializers.length > 0;
        }

        public boolean hasSerializerModifiers() {
            return this._modifiers.length > 0;
        }

        public Iterable<Serializers> serializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalSerializers);
        }

        public Iterable<Serializers> keySerializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalKeySerializers);
        }

        public Iterable<BeanSerializerModifier> serializerModifiers() {
            return ArrayBuilders.arrayAsIterable(this._modifiers);
        }
    }

    @Deprecated
    protected BeanSerializerFactory() {
        this((SerializerFactory.Config) null);
    }

    protected BeanSerializerFactory(SerializerFactory.Config config) {
        this._factoryConfig = config == null ? new ConfigImpl() : config;
    }

    public SerializerFactory.Config getConfig() {
        return this._factoryConfig;
    }

    public SerializerFactory withConfig(SerializerFactory.Config config) {
        if (this._factoryConfig == config) {
            return this;
        }
        if (getClass() == BeanSerializerFactory.class) {
            return new BeanSerializerFactory(config);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }

    /* access modifiers changed from: protected */
    public Iterable<Serializers> customSerializers() {
        return this._factoryConfig.serializers();
    }

    public JsonSerializer<Object> createSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) serializationConfig.introspect(javaType);
        JsonSerializer<Object> findSerializerFromAnnotation = findSerializerFromAnnotation(serializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (findSerializerFromAnnotation != null) {
            return findSerializerFromAnnotation;
        }
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(serializationConfig, basicBeanDescription.getClassInfo(), javaType);
        boolean z = modifyTypeByAnnotation != javaType;
        if (javaType.isContainerType()) {
            return buildContainerSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty, z);
        }
        for (Serializers findSerializer : this._factoryConfig.serializers()) {
            JsonSerializer<?> findSerializer2 = findSerializer.findSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
            if (findSerializer2 != null) {
                return findSerializer2;
            }
        }
        JsonSerializer<?> findSerializerByLookup = findSerializerByLookup(modifyTypeByAnnotation, serializationConfig, basicBeanDescription, beanProperty, z);
        if (findSerializerByLookup != null) {
            return findSerializerByLookup;
        }
        JsonSerializer<?> findSerializerByPrimaryType = findSerializerByPrimaryType(modifyTypeByAnnotation, serializationConfig, basicBeanDescription, beanProperty, z);
        if (findSerializerByPrimaryType != null) {
            return findSerializerByPrimaryType;
        }
        JsonSerializer<Object> findBeanSerializer = findBeanSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
        return findBeanSerializer == null ? super.findSerializerByAddonType(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty, z) : findBeanSerializer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[LOOP:0: B:4:0x001e->B:7:0x002e, LOOP_START, PHI: r1 
      PHI: (r1v1 org.codehaus.jackson.map.JsonSerializer<?>) = (r1v0 org.codehaus.jackson.map.JsonSerializer<?>), (r1v5 org.codehaus.jackson.map.JsonSerializer<?>) binds: [B:3:0x000a, B:7:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.JsonSerializer<java.lang.Object> createKeySerializer(org.codehaus.jackson.map.SerializationConfig r5, org.codehaus.jackson.type.JavaType r6, org.codehaus.jackson.map.BeanProperty r7) {
        /*
            r4 = this;
            org.codehaus.jackson.map.SerializerFactory$Config r0 = r4._factoryConfig
            boolean r0 = r0.hasKeySerializers()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Class r0 = r6.getRawClass()
            org.codehaus.jackson.map.BeanDescription r0 = r5.introspectClassAnnotations(r0)
            org.codehaus.jackson.map.introspect.BasicBeanDescription r0 = (org.codehaus.jackson.map.introspect.BasicBeanDescription) r0
            org.codehaus.jackson.map.SerializerFactory$Config r2 = r4._factoryConfig
            java.lang.Iterable r2 = r2.keySerializers()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0030
            java.lang.Object r1 = r2.next()
            org.codehaus.jackson.map.Serializers r1 = (org.codehaus.jackson.map.Serializers) r1
            org.codehaus.jackson.map.JsonSerializer r1 = r1.findSerializer(r5, r6, r0, r7)
            if (r1 == 0) goto L_0x001e
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ser.BeanSerializerFactory.createKeySerializer(org.codehaus.jackson.map.SerializationConfig, org.codehaus.jackson.type.JavaType, org.codehaus.jackson.map.BeanProperty):org.codehaus.jackson.map.JsonSerializer");
    }

    public JsonSerializer<Object> findBeanSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        if (!isPotentialBeanType(javaType.getRawClass())) {
            return null;
        }
        JsonSerializer constructBeanSerializer = constructBeanSerializer(serializationConfig, basicBeanDescription, beanProperty);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier modifySerializer : this._factoryConfig.serializerModifiers()) {
                constructBeanSerializer = modifySerializer.modifySerializer(serializationConfig, basicBeanDescription, constructBeanSerializer);
            }
        }
        return constructBeanSerializer;
    }

    public TypeSerializer findPropertyTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember, BeanProperty beanProperty) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyTypeResolver = annotationIntrospector.findPropertyTypeResolver(serializationConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return createTypeSerializer(serializationConfig, javaType, beanProperty);
        }
        return findPropertyTypeResolver.buildTypeSerializer(serializationConfig, javaType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, (MapperConfig<?>) serializationConfig, annotationIntrospector), beanProperty);
    }

    public TypeSerializer findPropertyContentTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember, BeanProperty beanProperty) throws JsonMappingException {
        JavaType contentType = javaType.getContentType();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyContentTypeResolver = annotationIntrospector.findPropertyContentTypeResolver(serializationConfig, annotatedMember, javaType);
        if (findPropertyContentTypeResolver == null) {
            return createTypeSerializer(serializationConfig, contentType, beanProperty);
        }
        return findPropertyContentTypeResolver.buildTypeSerializer(serializationConfig, contentType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, (MapperConfig<?>) serializationConfig, annotationIntrospector), beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> constructBeanSerializer(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) throws JsonMappingException {
        List<BeanPropertyWriter> list;
        if (basicBeanDescription.getBeanClass() != Object.class) {
            BeanSerializerBuilder constructBeanSerializerBuilder = constructBeanSerializerBuilder(basicBeanDescription);
            List<BeanPropertyWriter> findBeanProperties = findBeanProperties(serializationConfig, basicBeanDescription);
            AnnotatedMethod findAnyGetter = basicBeanDescription.findAnyGetter();
            if (this._factoryConfig.hasSerializerModifiers()) {
                if (findBeanProperties == null) {
                    findBeanProperties = new ArrayList<>();
                }
                for (BeanSerializerModifier changeProperties : this._factoryConfig.serializerModifiers()) {
                    findBeanProperties = changeProperties.changeProperties(serializationConfig, basicBeanDescription, findBeanProperties);
                }
            }
            if (findBeanProperties != null && findBeanProperties.size() != 0) {
                list = sortBeanProperties(serializationConfig, basicBeanDescription, filterBeanProperties(serializationConfig, basicBeanDescription, findBeanProperties));
            } else if (findAnyGetter != null) {
                list = Collections.emptyList();
            } else if (basicBeanDescription.hasKnownClassAnnotations()) {
                return constructBeanSerializerBuilder.createDummy();
            } else {
                return null;
            }
            if (this._factoryConfig.hasSerializerModifiers()) {
                for (BeanSerializerModifier orderProperties : this._factoryConfig.serializerModifiers()) {
                    list = orderProperties.orderProperties(serializationConfig, basicBeanDescription, list);
                }
            }
            constructBeanSerializerBuilder.setProperties(list);
            constructBeanSerializerBuilder.setFilterId(findFilterId(serializationConfig, basicBeanDescription));
            if (findAnyGetter != null) {
                JavaType type = findAnyGetter.getType(basicBeanDescription.bindingsForBeanType());
                constructBeanSerializerBuilder.setAnyGetter(new AnyGetterWriter(findAnyGetter, MapSerializer.construct((String[]) null, type, serializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING), createTypeSerializer(serializationConfig, type.getContentType(), beanProperty), beanProperty, (JsonSerializer<Object>) null, (JsonSerializer<Object>) null)));
            }
            processViews(serializationConfig, constructBeanSerializerBuilder);
            if (this._factoryConfig.hasSerializerModifiers()) {
                for (BeanSerializerModifier updateBuilder : this._factoryConfig.serializerModifiers()) {
                    constructBeanSerializerBuilder = updateBuilder.updateBuilder(serializationConfig, basicBeanDescription, constructBeanSerializerBuilder);
                }
            }
            return constructBeanSerializerBuilder.build();
        }
        throw new IllegalArgumentException("Can not create bean serializer for Object.class");
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        return FilteredBeanPropertyWriter.constructViewBased(beanPropertyWriter, clsArr);
    }

    /* access modifiers changed from: protected */
    public PropertyBuilder constructPropertyBuilder(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        return new PropertyBuilder(serializationConfig, basicBeanDescription);
    }

    /* access modifiers changed from: protected */
    public BeanSerializerBuilder constructBeanSerializerBuilder(BasicBeanDescription basicBeanDescription) {
        return new BeanSerializerBuilder(basicBeanDescription);
    }

    /* access modifiers changed from: protected */
    public Object findFilterId(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        return serializationConfig.getAnnotationIntrospector().findFilterId(basicBeanDescription.getClassInfo());
    }

    /* access modifiers changed from: protected */
    public boolean isPotentialBeanType(Class<?> cls) {
        return ClassUtil.canBeABeanType(cls) == null && !ClassUtil.isProxyType(cls);
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> findBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) throws JsonMappingException {
        VisibilityChecker defaultVisibilityChecker = serializationConfig.getDefaultVisibilityChecker();
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_GETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_FIELDS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        VisibilityChecker<?> findAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(basicBeanDescription.getClassInfo(), defaultVisibilityChecker);
        LinkedHashMap<String, AnnotatedMethod> findGetters = basicBeanDescription.findGetters(findAutoDetectVisibility, (Collection<String>) null);
        LinkedHashMap<String, AnnotatedField> findSerializableFields = basicBeanDescription.findSerializableFields(findAutoDetectVisibility, findGetters.keySet());
        removeIgnorableTypes(serializationConfig, basicBeanDescription, findGetters);
        removeIgnorableTypes(serializationConfig, basicBeanDescription, findSerializableFields);
        if (findGetters.isEmpty() && findSerializableFields.isEmpty()) {
            return null;
        }
        boolean usesStaticTyping = usesStaticTyping(serializationConfig, basicBeanDescription, (TypeSerializer) null, (BeanProperty) null);
        PropertyBuilder constructPropertyBuilder = constructPropertyBuilder(serializationConfig, basicBeanDescription);
        ArrayList arrayList = new ArrayList(findGetters.size());
        TypeBindings bindingsForBeanType = basicBeanDescription.bindingsForBeanType();
        for (Map.Entry next : findSerializableFields.entrySet()) {
            AnnotationIntrospector.ReferenceProperty findReferenceType = annotationIntrospector.findReferenceType((AnnotatedMember) next.getValue());
            if (findReferenceType == null || !findReferenceType.isBackReference()) {
                arrayList.add(_constructWriter(serializationConfig, bindingsForBeanType, constructPropertyBuilder, usesStaticTyping, (String) next.getKey(), (AnnotatedMember) next.getValue()));
            }
        }
        for (Map.Entry next2 : findGetters.entrySet()) {
            AnnotationIntrospector.ReferenceProperty findReferenceType2 = annotationIntrospector.findReferenceType((AnnotatedMember) next2.getValue());
            if (findReferenceType2 == null || !findReferenceType2.isBackReference()) {
                arrayList.add(_constructWriter(serializationConfig, bindingsForBeanType, constructPropertyBuilder, usesStaticTyping, (String) next2.getKey(), (AnnotatedMember) next2.getValue()));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> filterBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, List<BeanPropertyWriter> list) {
        String[] findPropertiesToIgnore = serializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(basicBeanDescription.getClassInfo());
        if (findPropertiesToIgnore != null && findPropertiesToIgnore.length > 0) {
            HashSet arrayToSet = ArrayBuilders.arrayToSet(findPropertiesToIgnore);
            Iterator<BeanPropertyWriter> it = list.iterator();
            while (it.hasNext()) {
                if (arrayToSet.contains(it.next().getName())) {
                    it.remove();
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> sortBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, List<BeanPropertyWriter> list) {
        boolean z;
        List<String> findCreatorPropertyNames = basicBeanDescription.findCreatorPropertyNames();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        AnnotatedClass classInfo = basicBeanDescription.getClassInfo();
        String[] findSerializationPropertyOrder = annotationIntrospector.findSerializationPropertyOrder(classInfo);
        Boolean findSerializationSortAlphabetically = annotationIntrospector.findSerializationSortAlphabetically(classInfo);
        if (findSerializationSortAlphabetically == null) {
            z = serializationConfig.isEnabled(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            z = findSerializationSortAlphabetically.booleanValue();
        }
        return (z || !findCreatorPropertyNames.isEmpty() || findSerializationPropertyOrder != null) ? _sortBeanProperties(list, findCreatorPropertyNames, findSerializationPropertyOrder, z) : list;
    }

    /* access modifiers changed from: protected */
    public void processViews(SerializationConfig serializationConfig, BeanSerializerBuilder beanSerializerBuilder) {
        List<BeanPropertyWriter> properties = beanSerializerBuilder.getProperties();
        boolean isEnabled = serializationConfig.isEnabled(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
        int size = properties.size();
        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            BeanPropertyWriter beanPropertyWriter = properties.get(i2);
            Class[] views = beanPropertyWriter.getViews();
            if (views != null) {
                i++;
                beanPropertyWriterArr[i2] = constructFilteredBeanWriter(beanPropertyWriter, views);
            } else if (isEnabled) {
                beanPropertyWriterArr[i2] = beanPropertyWriter;
            }
        }
        if (!isEnabled || i != 0) {
            beanSerializerBuilder.setFilteredProperties(beanPropertyWriterArr);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends AnnotatedMember> void removeIgnorableTypes(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, Map<String, T> map) {
        if (!map.isEmpty()) {
            AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
            Iterator<Map.Entry<String, T>> it = map.entrySet().iterator();
            HashMap hashMap = new HashMap();
            while (it.hasNext()) {
                Class<?> rawType = ((AnnotatedMember) it.next().getValue()).getRawType();
                Boolean bool = (Boolean) hashMap.get(rawType);
                if (bool == null) {
                    bool = annotationIntrospector.isIgnorableType(((BasicBeanDescription) serializationConfig.introspectClassAnnotations(rawType)).getClassInfo());
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(rawType, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter _constructWriter(SerializationConfig serializationConfig, TypeBindings typeBindings, PropertyBuilder propertyBuilder, boolean z, String str, AnnotatedMember annotatedMember) throws JsonMappingException {
        if (serializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMember.fixAccess();
        }
        JavaType type = annotatedMember.getType(typeBindings);
        BeanProperty.Std std = new BeanProperty.Std(str, type, propertyBuilder.getClassAnnotations(), annotatedMember);
        JsonSerializer<Object> findSerializerFromAnnotation = findSerializerFromAnnotation(serializationConfig, annotatedMember, std);
        TypeSerializer typeSerializer = null;
        if (ClassUtil.isCollectionMapOrArray(type.getRawClass())) {
            typeSerializer = findPropertyContentTypeSerializer(type, serializationConfig, annotatedMember, std);
        }
        PropertyBuilder propertyBuilder2 = propertyBuilder;
        String str2 = str;
        BeanPropertyWriter buildWriter = propertyBuilder2.buildWriter(str2, type, findSerializerFromAnnotation, findPropertyTypeSerializer(type, serializationConfig, annotatedMember, std), typeSerializer, annotatedMember, z);
        buildWriter.setViews(serializationConfig.getAnnotationIntrospector().findSerializationViews(annotatedMember));
        return buildWriter;
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> _sortBeanProperties(List<BeanPropertyWriter> list, List<String> list2, String[] strArr, boolean z) {
        Map map;
        int size = list.size();
        if (z) {
            map = new TreeMap();
        } else {
            map = new LinkedHashMap(size * 2);
        }
        for (BeanPropertyWriter next : list) {
            map.put(next.getName(), next);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(size * 2);
        if (strArr != null) {
            for (String str : strArr) {
                BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) map.get(str);
                if (beanPropertyWriter != null) {
                    linkedHashMap.put(str, beanPropertyWriter);
                }
            }
        }
        for (String next2 : list2) {
            BeanPropertyWriter beanPropertyWriter2 = (BeanPropertyWriter) map.get(next2);
            if (beanPropertyWriter2 != null) {
                linkedHashMap.put(next2, beanPropertyWriter2);
            }
        }
        linkedHashMap.putAll(map);
        return new ArrayList(linkedHashMap.values());
    }
}
