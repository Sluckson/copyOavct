package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.LinkedNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.type.JavaType;

public class DeserializationConfig extends MapperConfig<DeserializationConfig> {
    protected static final int DEFAULT_FEATURE_FLAGS = Feature.collectDefaults();
    protected AbstractTypeResolver _abstractTypeResolver;
    protected int _featureFlags;
    protected JsonNodeFactory _nodeFactory;
    protected LinkedNode<DeserializationProblemHandler> _problemHandlers;

    public enum Feature {
        USE_ANNOTATIONS(true),
        AUTO_DETECT_SETTERS(true),
        AUTO_DETECT_CREATORS(true),
        AUTO_DETECT_FIELDS(true),
        USE_GETTERS_AS_SETTERS(true),
        CAN_OVERRIDE_ACCESS_MODIFIERS(true),
        USE_BIG_DECIMAL_FOR_FLOATS(false),
        USE_BIG_INTEGER_FOR_INTS(false),
        READ_ENUMS_USING_TO_STRING(false),
        FAIL_ON_UNKNOWN_PROPERTIES(true),
        FAIL_ON_NULL_FOR_PRIMITIVES(false),
        FAIL_ON_NUMBERS_FOR_ENUMS(false),
        WRAP_EXCEPTIONS(true),
        WRAP_ROOT_VALUE(false),
        ACCEPT_EMPTY_STRING_AS_NULL_OBJECT(false),
        ACCEPT_SINGLE_VALUE_AS_ARRAY(false);
        
        final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public DeserializationConfig(ClassIntrospector<? extends BeanDescription> classIntrospector, AnnotationIntrospector annotationIntrospector, VisibilityChecker<?> visibilityChecker, SubtypeResolver subtypeResolver, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, HandlerInstantiator handlerInstantiator) {
        super(classIntrospector, annotationIntrospector, visibilityChecker, subtypeResolver, propertyNamingStrategy, typeFactory, handlerInstantiator);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._nodeFactory = JsonNodeFactory.instance;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig) {
        this(deserializationConfig, deserializationConfig._base);
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, HashMap<ClassKey, Class<?>> hashMap, SubtypeResolver subtypeResolver) {
        this(deserializationConfig, deserializationConfig._base);
        this._mixInAnnotations = hashMap;
        this._subtypeResolver = subtypeResolver;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, MapperConfig.Base base) {
        super(deserializationConfig, base, deserializationConfig._subtypeResolver);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._featureFlags = deserializationConfig._featureFlags;
        this._abstractTypeResolver = deserializationConfig._abstractTypeResolver;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, JsonNodeFactory jsonNodeFactory) {
        super(deserializationConfig);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._featureFlags = deserializationConfig._featureFlags;
        this._abstractTypeResolver = deserializationConfig._abstractTypeResolver;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = jsonNodeFactory;
    }

    public DeserializationConfig withClassIntrospector(ClassIntrospector<? extends BeanDescription> classIntrospector) {
        return new DeserializationConfig(this, this._base.withClassIntrospector(classIntrospector));
    }

    public DeserializationConfig withAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return new DeserializationConfig(this, this._base.withAnnotationIntrospector(annotationIntrospector));
    }

    public DeserializationConfig withVisibilityChecker(VisibilityChecker<?> visibilityChecker) {
        return new DeserializationConfig(this, this._base.withVisibilityChecker(visibilityChecker));
    }

    public DeserializationConfig withTypeResolverBuilder(TypeResolverBuilder<?> typeResolverBuilder) {
        return new DeserializationConfig(this, this._base.withTypeResolverBuilder(typeResolverBuilder));
    }

    public DeserializationConfig withSubtypeResolver(SubtypeResolver subtypeResolver) {
        DeserializationConfig deserializationConfig = new DeserializationConfig(this);
        deserializationConfig._subtypeResolver = subtypeResolver;
        return deserializationConfig;
    }

    public DeserializationConfig withPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        return new DeserializationConfig(this, this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    public DeserializationConfig withTypeFactory(TypeFactory typeFactory) {
        return typeFactory == this._base.getTypeFactory() ? this : new DeserializationConfig(this, this._base.withTypeFactory(typeFactory));
    }

    public DeserializationConfig withDateFormat(DateFormat dateFormat) {
        return dateFormat == this._base.getDateFormat() ? this : new DeserializationConfig(this, this._base.withDateFormat(dateFormat));
    }

    public DeserializationConfig withHandlerInstantiator(HandlerInstantiator handlerInstantiator) {
        return handlerInstantiator == this._base.getHandlerInstantiator() ? this : new DeserializationConfig(this, this._base.withHandlerInstantiator(handlerInstantiator));
    }

    public DeserializationConfig withNodeFactory(JsonNodeFactory jsonNodeFactory) {
        return new DeserializationConfig(this, jsonNodeFactory);
    }

    public void enable(Feature feature) {
        this._featureFlags = feature.getMask() | this._featureFlags;
    }

    public void disable(Feature feature) {
        this._featureFlags = (~feature.getMask()) & this._featureFlags;
    }

    public void set(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._featureFlags) != 0;
    }

    public void fromAnnotations(Class<?> cls) {
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        this._base = this._base.withVisibilityChecker(annotationIntrospector.findAutoDetectVisibility(AnnotatedClass.construct(cls, annotationIntrospector, (ClassIntrospector.MixInResolver) null), getDefaultVisibilityChecker()));
    }

    public DeserializationConfig createUnshared(SubtypeResolver subtypeResolver) {
        HashMap hashMap = this._mixInAnnotations;
        this._mixInAnnotationsShared = true;
        return new DeserializationConfig(this, hashMap, subtypeResolver);
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        if (isEnabled(Feature.USE_ANNOTATIONS)) {
            return super.getAnnotationIntrospector();
        }
        return NopAnnotationIntrospector.instance;
    }

    public <T extends BeanDescription> T introspectClassAnnotations(Class<?> cls) {
        return getClassIntrospector().forClassAnnotations(this, cls, this);
    }

    public <T extends BeanDescription> T introspectDirectClassAnnotations(Class<?> cls) {
        return getClassIntrospector().forDirectClassAnnotations(this, cls, this);
    }

    public boolean isAnnotationProcessingEnabled() {
        return isEnabled(Feature.USE_ANNOTATIONS);
    }

    public boolean canOverrideAccessModifiers() {
        return isEnabled(Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public LinkedNode<DeserializationProblemHandler> getProblemHandlers() {
        return this._problemHandlers;
    }

    public void addHandler(DeserializationProblemHandler deserializationProblemHandler) {
        if (!LinkedNode.contains(this._problemHandlers, deserializationProblemHandler)) {
            this._problemHandlers = new LinkedNode<>(deserializationProblemHandler, this._problemHandlers);
        }
    }

    public void clearHandlers() {
        this._problemHandlers = null;
    }

    public Base64Variant getBase64Variant() {
        return Base64Variants.getDefaultVariant();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._nodeFactory;
    }

    public <T extends BeanDescription> T introspect(JavaType javaType) {
        return getClassIntrospector().forDeserialization(this, javaType, this);
    }

    public <T extends BeanDescription> T introspectForCreation(JavaType javaType) {
        return getClassIntrospector().forCreation(this, javaType, this);
    }

    public JsonDeserializer<Object> deserializerInstance(Annotated annotated, Class<? extends JsonDeserializer<?>> cls) {
        JsonDeserializer<?> deserializerInstance;
        HandlerInstantiator handlerInstantiator = getHandlerInstantiator();
        if (handlerInstantiator == null || (deserializerInstance = handlerInstantiator.deserializerInstance(this, annotated, cls)) == null) {
            return (JsonDeserializer) ClassUtil.createInstance(cls, canOverrideAccessModifiers());
        }
        return deserializerInstance;
    }

    public KeyDeserializer keyDeserializerInstance(Annotated annotated, Class<? extends KeyDeserializer> cls) {
        KeyDeserializer keyDeserializerInstance;
        HandlerInstantiator handlerInstantiator = getHandlerInstantiator();
        if (handlerInstantiator == null || (keyDeserializerInstance = handlerInstantiator.keyDeserializerInstance(this, annotated, cls)) == null) {
            return (KeyDeserializer) ClassUtil.createInstance(cls, canOverrideAccessModifiers());
        }
        return keyDeserializerInstance;
    }

    @Deprecated
    public DeserializationConfig createUnshared(TypeResolverBuilder<?> typeResolverBuilder, VisibilityChecker<?> visibilityChecker, SubtypeResolver subtypeResolver) {
        return createUnshared(subtypeResolver).withTypeResolverBuilder(typeResolverBuilder).withVisibilityChecker(visibilityChecker);
    }

    @Deprecated
    public void setNodeFactory(JsonNodeFactory jsonNodeFactory) {
        this._nodeFactory = jsonNodeFactory;
    }

    @Deprecated
    public AbstractTypeResolver getAbstractTypeResolver() {
        return this._abstractTypeResolver;
    }

    @Deprecated
    public void setAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        this._abstractTypeResolver = abstractTypeResolver;
    }
}
