package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.introspect.BasicClassIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdSubtypeResolver;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.map.ser.BeanSerializerFactory;
import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.type.TypeModifier;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.p063io.SegmentedStringWriter;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.TokenBuffer;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectMapper extends ObjectCodec implements Versioned {
    protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    protected static final ClassIntrospector<? extends BeanDescription> DEFAULT_INTROSPECTOR = BasicClassIntrospector.instance;
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
    protected static final VisibilityChecker<?> STD_VISIBILITY_CHECKER = VisibilityChecker.Std.defaultInstance();
    protected DeserializationConfig _deserializationConfig;
    protected DeserializerProvider _deserializerProvider;
    protected final JsonFactory _jsonFactory;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected SerializationConfig _serializationConfig;
    protected SerializerFactory _serializerFactory;
    protected SerializerProvider _serializerProvider;
    protected SubtypeResolver _subtypeResolver;
    protected TypeFactory _typeFactory;

    public enum DefaultTyping {
        JAVA_LANG_OBJECT,
        OBJECT_AND_NON_CONCRETE,
        NON_CONCRETE_AND_ARRAYS,
        NON_FINAL
    }

    public static class DefaultTypeResolverBuilder extends StdTypeResolverBuilder {
        protected final DefaultTyping _appliesFor;

        public DefaultTypeResolverBuilder(DefaultTyping defaultTyping) {
            this._appliesFor = defaultTyping;
        }

        public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection, BeanProperty beanProperty) {
            if (useForType(javaType)) {
                return super.buildTypeDeserializer(deserializationConfig, javaType, collection, beanProperty);
            }
            return null;
        }

        public TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection, BeanProperty beanProperty) {
            if (useForType(javaType)) {
                return super.buildTypeSerializer(serializationConfig, javaType, collection, beanProperty);
            }
            return null;
        }

        public boolean useForType(JavaType javaType) {
            int i = C49122.$SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[this._appliesFor.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (javaType.isArrayType()) {
                            javaType = javaType.getContentType();
                        }
                        return !javaType.isFinal();
                    } else if (javaType.getRawClass() == Object.class) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else if (javaType.isArrayType()) {
                javaType = javaType.getContentType();
            }
            if (javaType.getRawClass() == Object.class || !javaType.isConcrete()) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: org.codehaus.jackson.map.ObjectMapper$2 */
    static /* synthetic */ class C49122 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping = new int[DefaultTyping.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                org.codehaus.jackson.map.ObjectMapper$DefaultTyping[] r0 = org.codehaus.jackson.map.ObjectMapper.DefaultTyping.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping = r0
                int[] r0 = $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.map.ObjectMapper$DefaultTyping r1 = org.codehaus.jackson.map.ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.map.ObjectMapper$DefaultTyping r1 = org.codehaus.jackson.map.ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.map.ObjectMapper$DefaultTyping r1 = org.codehaus.jackson.map.ObjectMapper.DefaultTyping.NON_FINAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ObjectMapper.C49122.<clinit>():void");
        }
    }

    public ObjectMapper() {
        this((JsonFactory) null, (SerializerProvider) null, (DeserializerProvider) null);
    }

    public ObjectMapper(JsonFactory jsonFactory) {
        this(jsonFactory, (SerializerProvider) null, (DeserializerProvider) null);
    }

    @Deprecated
    public ObjectMapper(SerializerFactory serializerFactory) {
        this((JsonFactory) null, (SerializerProvider) null, (DeserializerProvider) null);
        setSerializerFactory(serializerFactory);
    }

    public ObjectMapper(JsonFactory jsonFactory, SerializerProvider serializerProvider, DeserializerProvider deserializerProvider) {
        this(jsonFactory, serializerProvider, deserializerProvider, (SerializationConfig) null, (DeserializationConfig) null);
    }

    public ObjectMapper(JsonFactory jsonFactory, SerializerProvider serializerProvider, DeserializerProvider deserializerProvider, SerializationConfig serializationConfig, DeserializationConfig deserializationConfig) {
        SerializationConfig serializationConfig2;
        DeserializationConfig deserializationConfig2;
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        this._jsonFactory = jsonFactory == null ? new MappingJsonFactory(this) : jsonFactory;
        this._typeFactory = TypeFactory.defaultInstance();
        if (serializationConfig != null) {
            serializationConfig2 = serializationConfig;
        } else {
            serializationConfig2 = new SerializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, (SubtypeResolver) null, (PropertyNamingStrategy) null, this._typeFactory, (HandlerInstantiator) null);
        }
        this._serializationConfig = serializationConfig2;
        if (deserializationConfig != null) {
            deserializationConfig2 = deserializationConfig;
        } else {
            deserializationConfig2 = new DeserializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, (SubtypeResolver) null, (PropertyNamingStrategy) null, this._typeFactory, (HandlerInstantiator) null);
        }
        this._deserializationConfig = deserializationConfig2;
        this._serializerProvider = serializerProvider == null ? new StdSerializerProvider() : serializerProvider;
        this._deserializerProvider = deserializerProvider == null ? new StdDeserializerProvider() : deserializerProvider;
        this._serializerFactory = BeanSerializerFactory.instance;
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public void registerModule(Module module) {
        if (module.getModuleName() == null) {
            throw new IllegalArgumentException("Module without defined name");
        } else if (module.version() != null) {
            module.setupModule(new Module.SetupContext() {
                public Version getMapperVersion() {
                    return ObjectMapper.this.version();
                }

                public DeserializationConfig getDeserializationConfig() {
                    return this.getDeserializationConfig();
                }

                public SerializationConfig getSerializationConfig() {
                    return this.getSerializationConfig();
                }

                public void addDeserializers(Deserializers deserializers) {
                    ObjectMapper objectMapper = this;
                    objectMapper._deserializerProvider = objectMapper._deserializerProvider.withAdditionalDeserializers(deserializers);
                }

                public void addKeyDeserializers(KeyDeserializers keyDeserializers) {
                    ObjectMapper objectMapper = this;
                    objectMapper._deserializerProvider = objectMapper._deserializerProvider.withAdditionalKeyDeserializers(keyDeserializers);
                }

                public void addSerializers(Serializers serializers) {
                    ObjectMapper objectMapper = this;
                    objectMapper._serializerFactory = objectMapper._serializerFactory.withAdditionalSerializers(serializers);
                }

                public void addKeySerializers(Serializers serializers) {
                    ObjectMapper objectMapper = this;
                    objectMapper._serializerFactory = objectMapper._serializerFactory.withAdditionalKeySerializers(serializers);
                }

                public void addBeanSerializerModifier(BeanSerializerModifier beanSerializerModifier) {
                    ObjectMapper objectMapper = this;
                    objectMapper._serializerFactory = objectMapper._serializerFactory.withSerializerModifier(beanSerializerModifier);
                }

                public void addBeanDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
                    ObjectMapper objectMapper = this;
                    objectMapper._deserializerProvider = objectMapper._deserializerProvider.withDeserializerModifier(beanDeserializerModifier);
                }

                public void addAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
                    ObjectMapper objectMapper = this;
                    objectMapper._deserializerProvider = objectMapper._deserializerProvider.withAbstractTypeResolver(abstractTypeResolver);
                }

                public void addTypeModifier(TypeModifier typeModifier) {
                    this.setTypeFactory(this._typeFactory.withModifier(typeModifier));
                }

                public void insertAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
                    this._deserializationConfig.insertAnnotationIntrospector(annotationIntrospector);
                    this._serializationConfig.insertAnnotationIntrospector(annotationIntrospector);
                }

                public void appendAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
                    this._deserializationConfig.appendAnnotationIntrospector(annotationIntrospector);
                    this._serializationConfig.appendAnnotationIntrospector(annotationIntrospector);
                }

                public void setMixInAnnotations(Class<?> cls, Class<?> cls2) {
                    this._deserializationConfig.addMixInAnnotations(cls, cls2);
                    this._serializationConfig.addMixInAnnotations(cls, cls2);
                }
            });
        } else {
            throw new IllegalArgumentException("Module without defined version");
        }
    }

    public ObjectMapper withModule(Module module) {
        registerModule(module);
        return this;
    }

    public SerializationConfig getSerializationConfig() {
        return this._serializationConfig;
    }

    public SerializationConfig copySerializationConfig() {
        return this._serializationConfig.createUnshared(this._subtypeResolver);
    }

    public ObjectMapper setSerializationConfig(SerializationConfig serializationConfig) {
        this._serializationConfig = serializationConfig;
        return this;
    }

    public DeserializationConfig getDeserializationConfig() {
        return this._deserializationConfig;
    }

    public DeserializationConfig copyDeserializationConfig() {
        return this._deserializationConfig.createUnshared(this._subtypeResolver);
    }

    public ObjectMapper setDeserializationConfig(DeserializationConfig deserializationConfig) {
        this._deserializationConfig = deserializationConfig;
        return this;
    }

    public ObjectMapper setSerializerFactory(SerializerFactory serializerFactory) {
        this._serializerFactory = serializerFactory;
        return this;
    }

    public ObjectMapper setSerializerProvider(SerializerProvider serializerProvider) {
        this._serializerProvider = serializerProvider;
        return this;
    }

    public SerializerProvider getSerializerProvider() {
        return this._serializerProvider;
    }

    public ObjectMapper setDeserializerProvider(DeserializerProvider deserializerProvider) {
        this._deserializerProvider = deserializerProvider;
        return this;
    }

    public DeserializerProvider getDeserializerProvider() {
        return this._deserializerProvider;
    }

    public VisibilityChecker<?> getVisibilityChecker() {
        return this._serializationConfig.getDefaultVisibilityChecker();
    }

    public void setVisibilityChecker(VisibilityChecker<?> visibilityChecker) {
        this._deserializationConfig = this._deserializationConfig.withVisibilityChecker(visibilityChecker);
        this._serializationConfig = this._serializationConfig.withVisibilityChecker((VisibilityChecker) visibilityChecker);
    }

    public SubtypeResolver getSubtypeResolver() {
        if (this._subtypeResolver == null) {
            this._subtypeResolver = new StdSubtypeResolver();
        }
        return this._subtypeResolver;
    }

    public void setSubtypeResolver(SubtypeResolver subtypeResolver) {
        this._subtypeResolver = subtypeResolver;
    }

    public ObjectMapper setAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        this._serializationConfig = this._serializationConfig.withAnnotationIntrospector(annotationIntrospector);
        this._deserializationConfig = this._deserializationConfig.withAnnotationIntrospector(annotationIntrospector);
        return this;
    }

    public ObjectMapper setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        this._serializationConfig = this._serializationConfig.withPropertyNamingStrategy(propertyNamingStrategy);
        this._deserializationConfig = this._deserializationConfig.withPropertyNamingStrategy(propertyNamingStrategy);
        return this;
    }

    public ObjectMapper enableDefaultTyping() {
        return enableDefaultTyping(DefaultTyping.OBJECT_AND_NON_CONCRETE);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaultTyping) {
        return enableDefaultTyping(defaultTyping, JsonTypeInfo.C4903As.WRAPPER_ARRAY);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaultTyping, JsonTypeInfo.C4903As as) {
        return setDefaultTyping(new DefaultTypeResolverBuilder(defaultTyping).init(JsonTypeInfo.C4904Id.CLASS, (TypeIdResolver) null).inclusion(as));
    }

    public ObjectMapper enableDefaultTypingAsProperty(DefaultTyping defaultTyping, String str) {
        return setDefaultTyping(new DefaultTypeResolverBuilder(defaultTyping).init(JsonTypeInfo.C4904Id.CLASS, (TypeIdResolver) null).inclusion(JsonTypeInfo.C4903As.PROPERTY).typeProperty(str));
    }

    public ObjectMapper disableDefaultTyping() {
        return setDefaultTyping((TypeResolverBuilder<?>) null);
    }

    public ObjectMapper setDefaultTyping(TypeResolverBuilder<?> typeResolverBuilder) {
        this._deserializationConfig = this._deserializationConfig.withTypeResolverBuilder(typeResolverBuilder);
        this._serializationConfig = this._serializationConfig.withTypeResolverBuilder((TypeResolverBuilder) typeResolverBuilder);
        return this;
    }

    public void registerSubtypes(Class<?>... clsArr) {
        getSubtypeResolver().registerSubtypes(clsArr);
    }

    public void registerSubtypes(NamedType... namedTypeArr) {
        getSubtypeResolver().registerSubtypes(namedTypeArr);
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public ObjectMapper setTypeFactory(TypeFactory typeFactory) {
        this._typeFactory = typeFactory;
        this._deserializationConfig = this._deserializationConfig.withTypeFactory(typeFactory);
        this._serializationConfig = this._serializationConfig.withTypeFactory(typeFactory);
        return this;
    }

    public JavaType constructType(Type type) {
        return this._typeFactory.constructType(type);
    }

    public ObjectMapper setNodeFactory(JsonNodeFactory jsonNodeFactory) {
        this._deserializationConfig = this._deserializationConfig.withNodeFactory(jsonNodeFactory);
        return this;
    }

    public void setFilters(FilterProvider filterProvider) {
        this._serializationConfig = this._serializationConfig.withFilters(filterProvider);
    }

    public JsonFactory getJsonFactory() {
        return this._jsonFactory;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this._deserializationConfig = this._deserializationConfig.withDateFormat(dateFormat);
        this._serializationConfig = this._serializationConfig.withDateFormat(dateFormat);
    }

    public void setHandlerInstantiator(HandlerInstantiator handlerInstantiator) {
        this._deserializationConfig = this._deserializationConfig.withHandlerInstantiator(handlerInstantiator);
        this._serializationConfig = this._serializationConfig.withHandlerInstantiator(handlerInstantiator);
    }

    public ObjectMapper configure(SerializationConfig.Feature feature, boolean z) {
        this._serializationConfig.set(feature, z);
        return this;
    }

    public ObjectMapper configure(DeserializationConfig.Feature feature, boolean z) {
        this._deserializationConfig.set(feature, z);
        return this;
    }

    public ObjectMapper configure(JsonParser.Feature feature, boolean z) {
        this._jsonFactory.configure(feature, z);
        return this;
    }

    public ObjectMapper configure(JsonGenerator.Feature feature, boolean z) {
        this._jsonFactory.configure(feature, z);
        return this;
    }

    public JsonNodeFactory getNodeFactory() {
        return this._deserializationConfig.getNodeFactory();
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls, DeserializationConfig deserializationConfig) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(deserializationConfig, jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), jsonParser, this._typeFactory.constructType(typeReference));
    }

    public <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference, DeserializationConfig deserializationConfig) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(deserializationConfig, jsonParser, this._typeFactory.constructType(typeReference));
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), jsonParser, javaType);
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType, DeserializationConfig deserializationConfig) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(deserializationConfig, jsonParser, javaType);
    }

    public JsonNode readTree(JsonParser jsonParser) throws IOException, JsonProcessingException {
        return readTree(jsonParser, copyDeserializationConfig());
    }

    public JsonNode readTree(JsonParser jsonParser, DeserializationConfig deserializationConfig) throws IOException, JsonProcessingException {
        JsonNode jsonNode = (JsonNode) _readValue(deserializationConfig, jsonParser, JSON_NODE_TYPE);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(InputStream inputStream) throws IOException, JsonProcessingException {
        JsonNode jsonNode = (JsonNode) readValue(inputStream, JSON_NODE_TYPE);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(Reader reader) throws IOException, JsonProcessingException {
        JsonNode jsonNode = (JsonNode) readValue(reader, JSON_NODE_TYPE);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(String str) throws IOException, JsonProcessingException {
        JsonNode jsonNode = (JsonNode) readValue(str, JSON_NODE_TYPE);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public <T> MappingIterator<T> readValues(JsonParser jsonParser, JavaType javaType) throws IOException, JsonProcessingException {
        DeserializationConfig copyDeserializationConfig = copyDeserializationConfig();
        return new MappingIterator<>(javaType, jsonParser, _createDeserializationContext(jsonParser, copyDeserializationConfig), _findRootDeserializer(copyDeserializationConfig, javaType));
    }

    public <T> MappingIterator<T> readValues(JsonParser jsonParser, Class<?> cls) throws IOException, JsonProcessingException {
        return readValues(jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> MappingIterator<T> readValues(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException, JsonProcessingException {
        return readValues(jsonParser, this._typeFactory.constructType(typeReference));
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        SerializationConfig copySerializationConfig = copySerializationConfig();
        if (!copySerializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            this._serializerProvider.serializeValue(copySerializationConfig, jsonGenerator, obj, this._serializerFactory);
            if (copySerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
                return;
            }
            return;
        }
        _writeCloseableValue(jsonGenerator, obj, copySerializationConfig);
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) throws IOException, JsonGenerationException, JsonMappingException {
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            this._serializerProvider.serializeValue(serializationConfig, jsonGenerator, obj, this._serializerFactory);
            if (serializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
                return;
            }
            return;
        }
        _writeCloseableValue(jsonGenerator, obj, serializationConfig);
    }

    public void writeTree(JsonGenerator jsonGenerator, JsonNode jsonNode) throws IOException, JsonProcessingException {
        SerializationConfig copySerializationConfig = copySerializationConfig();
        this._serializerProvider.serializeValue(copySerializationConfig, jsonGenerator, jsonNode, this._serializerFactory);
        if (copySerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public void writeTree(JsonGenerator jsonGenerator, JsonNode jsonNode, SerializationConfig serializationConfig) throws IOException, JsonProcessingException {
        this._serializerProvider.serializeValue(serializationConfig, jsonGenerator, jsonNode, this._serializerFactory);
        if (serializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public ObjectNode createObjectNode() {
        return this._deserializationConfig.getNodeFactory().objectNode();
    }

    public ArrayNode createArrayNode() {
        return this._deserializationConfig.getNodeFactory().arrayNode();
    }

    public JsonParser treeAsTokens(JsonNode jsonNode) {
        return new TreeTraversingParser(jsonNode, this);
    }

    public <T> T treeToValue(JsonNode jsonNode, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return readValue(treeAsTokens(jsonNode), cls);
    }

    public <T extends JsonNode> T valueToTree(Object obj) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        TokenBuffer tokenBuffer = new TokenBuffer(this);
        try {
            writeValue((JsonGenerator) tokenBuffer, obj);
            JsonParser asParser = tokenBuffer.asParser();
            T readTree = readTree(asParser);
            asParser.close();
            return readTree;
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public boolean canSerialize(Class<?> cls) {
        return this._serializerProvider.hasSerializerFor(copySerializationConfig(), cls, this._serializerFactory);
    }

    public boolean canDeserialize(JavaType javaType) {
        return this._deserializerProvider.hasValueDeserializerFor(copyDeserializationConfig(), javaType);
    }

    public <T> T readValue(File file, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(file), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(File file, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(file), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(File file, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(file), javaType);
    }

    public <T> T readValue(URL url, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(url), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(URL url, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(url), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(URL url, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(url), javaType);
    }

    public <T> T readValue(String str, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(str), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(String str, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(str), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(String str, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(str), javaType);
    }

    public <T> T readValue(Reader reader, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(reader), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(Reader reader, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(reader), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(Reader reader, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(reader), javaType);
    }

    public <T> T readValue(InputStream inputStream, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(inputStream), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(InputStream inputStream, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(inputStream), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(InputStream inputStream, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(inputStream), javaType);
    }

    public <T> T readValue(byte[] bArr, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(byte[] bArr, int i, int i2, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr, i, i2), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(byte[] bArr, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(byte[] bArr, int i, int i2, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr, i, i2), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(byte[] bArr, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr), javaType);
    }

    public <T> T readValue(byte[] bArr, int i, int i2, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createJsonParser(bArr, i, i2), javaType);
    }

    public <T> T readValue(JsonNode jsonNode, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), treeAsTokens(jsonNode), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(JsonNode jsonNode, TypeReference typeReference) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), treeAsTokens(jsonNode), this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T readValue(JsonNode jsonNode, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(copyDeserializationConfig(), treeAsTokens(jsonNode), javaType);
    }

    public void writeValue(File file, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(outputStream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(writer), obj);
    }

    public String writeValueAsString(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
        _configAndWriteValue(this._jsonFactory.createJsonGenerator((Writer) segmentedStringWriter), obj);
        return segmentedStringWriter.getAndClear();
    }

    public byte[] writeValueAsBytes(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(this._jsonFactory._getBufferRecycler());
        _configAndWriteValue(this._jsonFactory.createJsonGenerator((OutputStream) byteArrayBuilder, JsonEncoding.UTF8), obj);
        byte[] byteArray = byteArrayBuilder.toByteArray();
        byteArrayBuilder.release();
        return byteArray;
    }

    @Deprecated
    public void writeValueUsingView(JsonGenerator jsonGenerator, Object obj, Class<?> cls) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(jsonGenerator, obj, cls);
    }

    @Deprecated
    public void writeValueUsingView(Writer writer, Object obj, Class<?> cls) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(writer), obj, cls);
    }

    @Deprecated
    public void writeValueUsingView(OutputStream outputStream, Object obj, Class<?> cls) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(outputStream, JsonEncoding.UTF8), obj, cls);
    }

    public ObjectWriter writer() {
        return new ObjectWriter(this, copySerializationConfig());
    }

    public ObjectWriter viewWriter(Class<?> cls) {
        return new ObjectWriter(this, copySerializationConfig().withView(cls));
    }

    public ObjectWriter typedWriter(Class<?> cls) {
        return new ObjectWriter(this, copySerializationConfig(), cls == null ? null : this._typeFactory.constructType((Type) cls), (PrettyPrinter) null);
    }

    public ObjectWriter typedWriter(JavaType javaType) {
        return new ObjectWriter(this, copySerializationConfig(), javaType, (PrettyPrinter) null);
    }

    public ObjectWriter typedWriter(TypeReference<?> typeReference) {
        return new ObjectWriter(this, copySerializationConfig(), typeReference == null ? null : this._typeFactory.constructType(typeReference), (PrettyPrinter) null);
    }

    public ObjectWriter prettyPrintingWriter(PrettyPrinter prettyPrinter) {
        if (prettyPrinter == null) {
            prettyPrinter = ObjectWriter.NULL_PRETTY_PRINTER;
        }
        return new ObjectWriter(this, copySerializationConfig(), (JavaType) null, prettyPrinter);
    }

    public ObjectWriter defaultPrettyPrintingWriter() {
        return new ObjectWriter(this, copySerializationConfig(), (JavaType) null, _defaultPrettyPrinter());
    }

    public ObjectWriter filteredWriter(FilterProvider filterProvider) {
        return new ObjectWriter(this, copySerializationConfig().withFilters(filterProvider));
    }

    public ObjectWriter schemaBasedWriter(FormatSchema formatSchema) {
        return new ObjectWriter(this, copySerializationConfig(), formatSchema);
    }

    public ObjectReader reader() {
        return new ObjectReader(this, copyDeserializationConfig());
    }

    public ObjectReader updatingReader(Object obj) {
        return new ObjectReader(this, copyDeserializationConfig(), this._typeFactory.constructType((Type) obj.getClass()), obj, (FormatSchema) null);
    }

    public ObjectReader reader(JavaType javaType) {
        return new ObjectReader(this, copyDeserializationConfig(), javaType, (Object) null, (FormatSchema) null);
    }

    public ObjectReader reader(Class<?> cls) {
        return reader(this._typeFactory.constructType((Type) cls));
    }

    public ObjectReader reader(TypeReference<?> typeReference) {
        return reader(this._typeFactory.constructType(typeReference));
    }

    public ObjectReader reader(JsonNodeFactory jsonNodeFactory) {
        return new ObjectReader(this, copyDeserializationConfig()).withNodeFactory(jsonNodeFactory);
    }

    public ObjectReader schemaBasedReader(FormatSchema formatSchema) {
        return new ObjectReader(this, copyDeserializationConfig(), (JavaType) null, (Object) null, formatSchema);
    }

    public <T> T convertValue(Object obj, Class<T> cls) throws IllegalArgumentException {
        return _convert(obj, this._typeFactory.constructType((Type) cls));
    }

    public <T> T convertValue(Object obj, TypeReference typeReference) throws IllegalArgumentException {
        return _convert(obj, this._typeFactory.constructType((TypeReference<?>) typeReference));
    }

    public <T> T convertValue(Object obj, JavaType javaType) throws IllegalArgumentException {
        return _convert(obj, javaType);
    }

    /* access modifiers changed from: protected */
    public Object _convert(Object obj, JavaType javaType) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        TokenBuffer tokenBuffer = new TokenBuffer(this);
        try {
            writeValue((JsonGenerator) tokenBuffer, obj);
            JsonParser asParser = tokenBuffer.asParser();
            Object readValue = readValue(asParser, javaType);
            asParser.close();
            return readValue;
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public JsonSchema generateJsonSchema(Class<?> cls) throws JsonMappingException {
        return generateJsonSchema(cls, copySerializationConfig());
    }

    public JsonSchema generateJsonSchema(Class<?> cls, SerializationConfig serializationConfig) throws JsonMappingException {
        return this._serializerProvider.generateJsonSchema(cls, serializationConfig, this._serializerFactory);
    }

    /* access modifiers changed from: protected */
    public PrettyPrinter _defaultPrettyPrinter() {
        return new DefaultPrettyPrinter();
    }

    /* access modifiers changed from: protected */
    public final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        SerializationConfig copySerializationConfig = copySerializationConfig();
        if (copySerializationConfig.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }
        if (!copySerializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            boolean z = false;
            try {
                this._serializerProvider.serializeValue(copySerializationConfig, jsonGenerator, obj, this._serializerFactory);
                z = true;
                jsonGenerator.close();
            } catch (Throwable th) {
                if (!z) {
                    try {
                        jsonGenerator.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } else {
            _configAndWriteCloseable(jsonGenerator, obj, copySerializationConfig);
        }
    }

    /* access modifiers changed from: protected */
    public final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj, Class<?> cls) throws IOException, JsonGenerationException, JsonMappingException {
        SerializationConfig withView = copySerializationConfig().withView(cls);
        if (withView.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }
        if (!withView.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            boolean z = false;
            try {
                this._serializerProvider.serializeValue(withView, jsonGenerator, obj, this._serializerFactory);
                z = true;
                jsonGenerator.close();
            } catch (Throwable th) {
                if (!z) {
                    try {
                        jsonGenerator.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } else {
            _configAndWriteCloseable(jsonGenerator, obj, withView);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e A[SYNTHETIC, Splitter:B:14:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[SYNTHETIC, Splitter:B:18:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void _configAndWriteCloseable(org.codehaus.jackson.JsonGenerator r5, java.lang.Object r6, org.codehaus.jackson.map.SerializationConfig r7) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException, org.codehaus.jackson.map.JsonMappingException {
        /*
            r4 = this;
            r0 = r6
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            org.codehaus.jackson.map.SerializerProvider r2 = r4._serializerProvider     // Catch:{ all -> 0x001b }
            org.codehaus.jackson.map.SerializerFactory r3 = r4._serializerFactory     // Catch:{ all -> 0x001b }
            r2.serializeValue(r7, r5, r6, r3)     // Catch:{ all -> 0x001b }
            r5.close()     // Catch:{ all -> 0x0017 }
            r0.close()     // Catch:{ all -> 0x0012 }
            return
        L_0x0012:
            r5 = move-exception
            r6 = r5
            r5 = r1
            r0 = r5
            goto L_0x001c
        L_0x0017:
            r5 = move-exception
            r6 = r5
            r5 = r1
            goto L_0x001c
        L_0x001b:
            r6 = move-exception
        L_0x001c:
            if (r5 == 0) goto L_0x0023
            r5.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0023
        L_0x0022:
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ObjectMapper._configAndWriteCloseable(org.codehaus.jackson.JsonGenerator, java.lang.Object, org.codehaus.jackson.map.SerializationConfig):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void _writeCloseableValue(org.codehaus.jackson.JsonGenerator r4, java.lang.Object r5, org.codehaus.jackson.map.SerializationConfig r6) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException, org.codehaus.jackson.map.JsonMappingException {
        /*
            r3 = this;
            r0 = r5
            java.io.Closeable r0 = (java.io.Closeable) r0
            org.codehaus.jackson.map.SerializerProvider r1 = r3._serializerProvider     // Catch:{ all -> 0x001e }
            org.codehaus.jackson.map.SerializerFactory r2 = r3._serializerFactory     // Catch:{ all -> 0x001e }
            r1.serializeValue(r6, r4, r5, r2)     // Catch:{ all -> 0x001e }
            org.codehaus.jackson.map.SerializationConfig$Feature r5 = org.codehaus.jackson.map.SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE     // Catch:{ all -> 0x001e }
            boolean r5 = r6.isEnabled(r5)     // Catch:{ all -> 0x001e }
            if (r5 == 0) goto L_0x0015
            r4.flush()     // Catch:{ all -> 0x001e }
        L_0x0015:
            r4 = 0
            r0.close()     // Catch:{ all -> 0x001a }
            return
        L_0x001a:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x001f
        L_0x001e:
            r4 = move-exception
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ObjectMapper._writeCloseableValue(org.codehaus.jackson.JsonGenerator, java.lang.Object, org.codehaus.jackson.map.SerializationConfig):void");
    }

    /* access modifiers changed from: protected */
    public Object _readValue(DeserializationConfig deserializationConfig, JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        Object obj;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            obj = null;
        } else {
            obj = _findRootDeserializer(deserializationConfig, javaType).deserialize(jsonParser, _createDeserializationContext(jsonParser, deserializationConfig));
        }
        jsonParser.clearCurrentToken();
        return obj;
    }

    /* access modifiers changed from: protected */
    public Object _readMapAndClose(JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        Object obj;
        try {
            JsonToken _initForReading = _initForReading(jsonParser);
            if (!(_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY)) {
                if (_initForReading != JsonToken.END_OBJECT) {
                    DeserializationConfig copyDeserializationConfig = copyDeserializationConfig();
                    obj = _findRootDeserializer(copyDeserializationConfig, javaType).deserialize(jsonParser, _createDeserializationContext(jsonParser, copyDeserializationConfig));
                    jsonParser.clearCurrentToken();
                    return obj;
                }
            }
            obj = null;
            jsonParser.clearCurrentToken();
            return obj;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public JsonToken _initForReading(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken != null || (currentToken = jsonParser.nextToken()) != null) {
            return currentToken;
        }
        throw new EOFException("No content to map to Object due to end of input");
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findRootDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JsonDeserializer<Object> jsonDeserializer = this._rootDeserializers.get(javaType);
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        JsonDeserializer<Object> findTypedValueDeserializer = this._deserializerProvider.findTypedValueDeserializer(deserializationConfig, javaType, (BeanProperty) null);
        if (findTypedValueDeserializer != null) {
            this._rootDeserializers.put(javaType, findTypedValueDeserializer);
            return findTypedValueDeserializer;
        }
        throw new JsonMappingException("Can not find a deserializer for type " + javaType);
    }

    /* access modifiers changed from: protected */
    public DeserializationContext _createDeserializationContext(JsonParser jsonParser, DeserializationConfig deserializationConfig) {
        return new StdDeserializationContext(deserializationConfig, jsonParser, this._deserializerProvider);
    }
}
