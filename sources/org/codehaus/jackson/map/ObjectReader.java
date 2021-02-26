package org.codehaus.jackson.map;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectReader extends ObjectCodec implements Versioned {
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
    protected final DeserializationConfig _config;
    protected final JsonFactory _jsonFactory;
    protected final DeserializerProvider _provider;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected final FormatSchema _schema;
    protected final Object _valueToUpdate;
    protected final JavaType _valueType;

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig) {
        this(objectMapper, deserializationConfig, (JavaType) null, (Object) null, (FormatSchema) null);
    }

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig, JavaType javaType, Object obj, FormatSchema formatSchema) {
        this._config = deserializationConfig;
        this._rootDeserializers = objectMapper._rootDeserializers;
        this._provider = objectMapper._deserializerProvider;
        this._jsonFactory = objectMapper._jsonFactory;
        this._valueType = javaType;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = formatSchema;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, Object obj, FormatSchema formatSchema) {
        this._config = deserializationConfig;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._provider = objectReader._provider;
        this._jsonFactory = objectReader._jsonFactory;
        this._valueType = javaType;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = formatSchema;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public ObjectReader withType(JavaType javaType) {
        if (javaType == this._valueType) {
            return this;
        }
        return new ObjectReader(this, this._config, javaType, this._valueToUpdate, this._schema);
    }

    public ObjectReader withType(Class<?> cls) {
        return withType(this._config.constructType(cls));
    }

    public ObjectReader withType(Type type) {
        return withType(this._config.getTypeFactory().constructType(type));
    }

    public ObjectReader withType(TypeReference<?> typeReference) {
        return withType(this._config.getTypeFactory().constructType(typeReference.getType()));
    }

    public ObjectReader withNodeFactory(JsonNodeFactory jsonNodeFactory) {
        if (jsonNodeFactory == this._config.getNodeFactory()) {
            return this;
        }
        return new ObjectReader(this, this._config.withNodeFactory(jsonNodeFactory), this._valueType, this._valueToUpdate, this._schema);
    }

    public ObjectReader withValueToUpdate(Object obj) {
        if (obj == this._valueToUpdate) {
            return this;
        }
        if (obj != null) {
            return new ObjectReader(this, this._config, this._config.constructType(obj.getClass()), obj, this._schema);
        }
        throw new IllegalArgumentException("cat not update null value");
    }

    public ObjectReader withSchema(FormatSchema formatSchema) {
        if (this._schema == formatSchema) {
            return this;
        }
        return new ObjectReader(this, this._config, this._valueType, this._valueToUpdate, formatSchema);
    }

    public <T> T readValue(JsonParser jsonParser) throws IOException, JsonProcessingException {
        return _bind(jsonParser);
    }

    public JsonNode readTree(JsonParser jsonParser) throws IOException, JsonProcessingException {
        return _bindAsTree(jsonParser);
    }

    public <T> T readValue(InputStream inputStream) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(inputStream));
    }

    public <T> T readValue(Reader reader) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(reader));
    }

    public <T> T readValue(String str) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(str));
    }

    public <T> T readValue(byte[] bArr) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(bArr));
    }

    public <T> T readValue(byte[] bArr, int i, int i2) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(bArr, i, i2));
    }

    public <T> T readValue(File file) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(file));
    }

    public <T> T readValue(URL url) throws IOException, JsonProcessingException {
        return _bindAndClose(this._jsonFactory.createJsonParser(url));
    }

    public <T> T readValue(JsonNode jsonNode) throws IOException, JsonProcessingException {
        return _bindAndClose(treeAsTokens(jsonNode));
    }

    public JsonNode readTree(InputStream inputStream) throws IOException, JsonProcessingException {
        return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(inputStream));
    }

    public JsonNode readTree(Reader reader) throws IOException, JsonProcessingException {
        return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(reader));
    }

    public JsonNode readTree(String str) throws IOException, JsonProcessingException {
        return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(str));
    }

    public <T> MappingIterator<T> readValues(JsonParser jsonParser) throws IOException, JsonProcessingException {
        DeserializationContext _createDeserializationContext = _createDeserializationContext(jsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, jsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(InputStream inputStream) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(inputStream);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(Reader reader) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(reader);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(String str) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(str);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(byte[] bArr, int i, int i2) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(bArr, i, i2);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(File file) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(file);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    public <T> MappingIterator<T> readValues(URL url) throws IOException, JsonProcessingException {
        JsonParser createJsonParser = this._jsonFactory.createJsonParser(url);
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            createJsonParser.setSchema(formatSchema);
        }
        DeserializationContext _createDeserializationContext = _createDeserializationContext(createJsonParser, this._config);
        JavaType javaType = this._valueType;
        return new MappingIterator<>(javaType, createJsonParser, _createDeserializationContext, _findRootDeserializer(this._config, javaType));
    }

    /* access modifiers changed from: protected */
    public Object _bind(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
        Object obj;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            obj = this._valueToUpdate;
        } else {
            DeserializationContext _createDeserializationContext = _createDeserializationContext(jsonParser, this._config);
            if (this._valueToUpdate == null) {
                obj = _findRootDeserializer(this._config, this._valueType).deserialize(jsonParser, _createDeserializationContext);
            } else {
                _findRootDeserializer(this._config, this._valueType).deserialize(jsonParser, _createDeserializationContext, this._valueToUpdate);
                obj = this._valueToUpdate;
            }
        }
        jsonParser.clearCurrentToken();
        return obj;
    }

    /* access modifiers changed from: protected */
    public Object _bindAndClose(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
        Object obj;
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            jsonParser.setSchema(formatSchema);
        }
        try {
            JsonToken _initForReading = _initForReading(jsonParser);
            if (!(_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY)) {
                if (_initForReading != JsonToken.END_OBJECT) {
                    DeserializationContext _createDeserializationContext = _createDeserializationContext(jsonParser, this._config);
                    if (this._valueToUpdate == null) {
                        obj = _findRootDeserializer(this._config, this._valueType).deserialize(jsonParser, _createDeserializationContext);
                    } else {
                        _findRootDeserializer(this._config, this._valueType).deserialize(jsonParser, _createDeserializationContext, this._valueToUpdate);
                        obj = this._valueToUpdate;
                    }
                    return obj;
                }
            }
            obj = this._valueToUpdate;
            return obj;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public JsonNode _bindAsTree(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
        JsonNode jsonNode;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            jsonNode = NullNode.instance;
        } else {
            jsonNode = (JsonNode) _findRootDeserializer(this._config, JSON_NODE_TYPE).deserialize(jsonParser, _createDeserializationContext(jsonParser, this._config));
        }
        jsonParser.clearCurrentToken();
        return jsonNode;
    }

    /* access modifiers changed from: protected */
    public JsonNode _bindAndCloseAsTree(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            jsonParser.setSchema(formatSchema);
        }
        try {
            return _bindAsTree(jsonParser);
        } finally {
            try {
                jsonParser.close();
            } catch (IOException unused) {
            }
        }
    }

    protected static JsonToken _initForReading(JsonParser jsonParser) throws IOException, JsonParseException, JsonMappingException {
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
        JsonDeserializer<Object> findTypedValueDeserializer = this._provider.findTypedValueDeserializer(deserializationConfig, javaType, (BeanProperty) null);
        if (findTypedValueDeserializer != null) {
            this._rootDeserializers.put(javaType, findTypedValueDeserializer);
            return findTypedValueDeserializer;
        }
        throw new JsonMappingException("Can not find a deserializer for type " + javaType);
    }

    /* access modifiers changed from: protected */
    public DeserializationContext _createDeserializationContext(JsonParser jsonParser, DeserializationConfig deserializationConfig) {
        return new StdDeserializationContext(deserializationConfig, jsonParser, this._provider);
    }

    public JsonNode createArrayNode() {
        return this._config.getNodeFactory().arrayNode();
    }

    public JsonNode createObjectNode() {
        return this._config.getNodeFactory().objectNode();
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException {
        return withType((Class<?>) cls).readValue(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException, JsonProcessingException {
        return withType(typeReference).readValue(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException, JsonProcessingException {
        return withType(javaType).readValue(jsonParser);
    }

    public JsonParser treeAsTokens(JsonNode jsonNode) {
        return new TreeTraversingParser(jsonNode, this);
    }

    public <T> T treeToValue(JsonNode jsonNode, Class<T> cls) throws IOException, JsonProcessingException {
        return readValue(treeAsTokens(jsonNode), cls);
    }

    public void writeTree(JsonGenerator jsonGenerator, JsonNode jsonNode) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }
}
